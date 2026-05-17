package part1;

import java.awt.event.ItemEvent;
import java.util.*;

public class Polynomial {

    private Collection<Monomial> polynomial;

    public Polynomial(){
        this.polynomial= new ArrayList<>();
    }

    public Collection<Monomial> getPolynomial(){
        return this.polynomial;
    }

    public Polynomial(String input){
        this.polynomial=build(input).polynomial;
    }

    static Polynomial build(String input){
        Polynomial poly=new Polynomial();
        String[] coefficients = input.split("\\s+");
        for (int i=0; i<coefficients.length; i++){
            Scalar s;
            if(coefficients[i].contains("/")){
                String[] frac = coefficients[i].split("/");
                int numerator=Integer.parseInt(frac[0]);
                int denominator=Integer.parseInt(frac[1]);
                s= new RationalScalar(numerator, denominator);
            }
            else if (coefficients[i].contains(".")){
                double number = Double.parseDouble(coefficients[i]);
                s=new RealScalar(number);
            }
            else {
                int number = Integer.parseInt(coefficients[i]);
                s = new IntegerScalar(number);
            }
            Monomial mon=new Monomial(i, s);
            Scalar zero = new IntegerScalar(0);
            if(!mon.getCoefficient().equals(zero))
                poly.polynomial.add(mon);
        }
        return poly;
    }

    public Polynomial add(Polynomial p){
        Polynomial added=new Polynomial();
        TreeMap<Integer, Monomial> mergedTerms = new TreeMap<>();

        for(Monomial currGiven : p.getPolynomial()){
            Integer currExpKey = currGiven.getExponent();
            if(mergedTerms.containsKey(currExpKey)) {
                Monomial oldVal = mergedTerms.get(currExpKey);
                Monomial sumRes = currGiven.add(oldVal);
                Scalar zero = new IntegerScalar(0);
                if(!sumRes.getCoefficient().equals(zero))
                    mergedTerms.put(currExpKey, sumRes);
                else mergedTerms.remove(currExpKey);
            }
            else mergedTerms.put(currExpKey, currGiven);
        }

        for (Monomial currThis : getPolynomial()){
            Integer currExpKey = currThis.getExponent();
            if(mergedTerms.containsKey(currExpKey)) {
                Monomial oldVal = mergedTerms.get(currExpKey);
                Monomial sumRes = currThis.add(oldVal);
                Scalar zero = new IntegerScalar(0);
                if(!sumRes.getCoefficient().equals(zero))
                    mergedTerms.put(currExpKey, sumRes);
                else mergedTerms.remove(currExpKey);
            }
            else mergedTerms.put(currExpKey, currThis);
        }

        added.polynomial.addAll(mergedTerms.values());
        return added;
    }


    public Polynomial mul(Polynomial p){
        Polynomial multi=new Polynomial();
        TreeMap<Integer, Monomial> mergedTerms = new TreeMap<>();

        for (Monomial currGiven: p.getPolynomial()) {
            for (Monomial currHere : getPolynomial()) {
                Monomial result = currGiven.mul(currHere);
                int resExp = result.getExponent();
                if (mergedTerms.containsKey(resExp)) {
                    Monomial oldVal = mergedTerms.get(resExp);
                    Monomial sumRes = result.add(oldVal);
                    Scalar zero = new IntegerScalar(0);
                    if(!sumRes.getCoefficient().equals(zero))
                        mergedTerms.put(resExp, sumRes);
                    else mergedTerms.remove(resExp);
                }
                else mergedTerms.put(resExp,result);
            }
        }
        multi.polynomial.addAll(mergedTerms.values());
        return  multi;
    }

    public Scalar evaluate(Scalar s){
        Scalar ans =new IntegerScalar(0);
        for(Monomial mono : getPolynomial()){
           ans= ans.add(mono.evaluate(s));
        }
        return ans;
    }

    public Polynomial derivative(){
        Polynomial derPol = new Polynomial();
        for(Monomial mono : getPolynomial()) {
            Monomial drvMon = mono.derivative();
            Scalar zero = new IntegerScalar(0);
            if (!drvMon.getCoefficient().equals(zero)) {
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
                for (Monomial monomial : getPolynomial()) {
                    Monomial monoObj = polObj.next();
                    if (!monoObj.equals(monomial))
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (polynomial.isEmpty())
            return "0";

        Iterator<Monomial> iter = this.polynomial.iterator();
        Monomial curr=iter.next();
        String ans = curr.toString();

        while(iter.hasNext()){
            curr=iter.next();

            if(curr.sign()==-1)
                ans += curr.toString();
            else if(curr.sign()==1)
                ans += "+" +curr.toString();
        }
        return ans;
    }
}
