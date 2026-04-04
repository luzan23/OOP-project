package assignment1;
import java.util.*;

public class Polynomial {

    private Collection<Monomial> polynomial;

    public Polynomial(){
        this.polynomial= new ArrayList<>();
    }

    public Polynomial(String input){
        this.polynomial=build(input).polynomial;
    }

    static Polynomial build(String input){
        Polynomial poly=new Polynomial();
        String[] coefficients = input.split("\\s+");
        for (int i=0; i<coefficients.length; i++){
            if(coefficients[i].contains("/")){
                String[] frac = coefficients[i].split("/");
                int numerator=Integer.parseInt(frac[0]);
                int denominator=Integer.parseInt(frac[1]);
                Scalar s= new RationalScalar(numerator, denominator);
                Monomial mon=new Monomial(i, s);
                poly.polynomial.add(mon);
            }
            else{
                int number = Integer.parseInt(coefficients[i]);
                Scalar s=new IntegerScalar(number);
                Monomial mon=new Monomial(i, s);
                poly.polynomial.add(mon);
            }
        }
        return poly;
    }

    public Polynomial add(Polynomial p){
        Polynomial ans=new Polynomial();

        Iterator<Monomial> thisItr=this.polynomial.iterator();
        Iterator<Monomial> pItr=p.polynomial.iterator();
        Monomial currThis;
        Monomial currP;

        while(thisItr.hasNext() && pItr.hasNext()){
            currThis=thisItr.next();
            currP=pItr.next();
            if(currP.getExponent()<currThis.getExponent())
                ans.polynomial.add(currP);
            else if(currP.getExponent()>currThis.getExponent())
                ans.polynomial.add(currThis);
            else ans.polynomial.add(currP.add(currThis));
        }

        while(thisItr.hasNext()){
            currThis=thisItr.next();
            ans.polynomial.add(currThis);
        }

        while(pItr.hasNext()){
            currP=pItr.next();
            ans.polynomial.add(currP);
        }
        return ans;
    }

    public Polynomial mul(Polynomial p){
        Polynomial multi=new Polynomial();
        TreeMap<Integer, Monomial> mergedTerms = new TreeMap<>();

        for (Monomial currGiven: p.polynomial) {
            for (Monomial currHere : this.polynomial) {
                Monomial result = currGiven.mul(currHere);
                int resExp = result.getExponent();
                if (mergedTerms.containsKey(resExp)) {
                    Monomial oldVal = mergedTerms.get(resExp);
                    Monomial sumRes = result.add(oldVal);
                    mergedTerms.put(resExp, sumRes);
                } else {
                    mergedTerms.put(resExp,result);

                }
            }
        }
        if (!mergedTerms.isEmpty()) {
            int maxExp = mergedTerms.lastKey();
            for (int i = 0; i <= maxExp; i++) {
                if (mergedTerms.containsKey(i)) {
                    Monomial current = mergedTerms.get(i);
                    multi.polynomial.add(current);
                } else {
                    Scalar zero = new IntegerScalar(0);
                    Monomial zeroMon = new Monomial(i, zero);
                    multi.polynomial.add(zeroMon);
                }
            }
        }
        return  multi;
    }

    public Scalar evaluate(Scalar s){
        Scalar ans =new IntegerScalar(0);
        for(Monomial mono : this.polynomial){
            ans.add(mono.evaluate(s));
        }
        return ans;
    }

    public Polynomial derivative(){
        Polynomial derPol=new Polynomial();
        for(Monomial mono : this.polynomial){
            Scalar exp=new IntegerScalar(mono.getExponent());
            Monomial drvMon=new Monomial(mono.getExponent()-1, exp.mul(mono.getCoefficient()));
            if(drvMon.getCoefficient().sign()!=0){
                derPol.polynomial.add(drvMon);
            }
        }
        return derPol;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Polynomial) {
            if (((Polynomial) obj).polynomial.size() != polynomial.size())
                return false;
            else {
                Iterator<Monomial> polObj = ((Polynomial) obj).polynomial.iterator();
                for (Monomial monomial : this.polynomial) {
                    Monomial monoObj = polObj.next();
                    if (!monoObj.equals(monomial))
                        return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String ans="";
        Iterator<Monomial> itr= polynomial.iterator();
        Monomial curr;
        int counter=0;
        while(counter< polynomial.size()-1 && itr.hasNext()){
            curr=itr.next();
            if(curr.sign()==1)
                ans="+"+curr+ans;
            else ans= curr + ans;
            counter++;
        }
        curr=itr.next();
        ans=curr+ans;
        return ans;
    }
}
