package part1;
public class Monomial {

    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent,Scalar coefficient){
        this.exponent=exponent;
        this.coefficient = coefficient;
    }

    public int getExponent(){
        return exponent;
    }

    public Scalar getCoefficient(){
        return this.coefficient;
    }

    public Monomial add(Monomial m){
        if (getExponent() != m.getExponent())
            return null;
        Scalar s = getCoefficient().add(m.getCoefficient());
        return new Monomial(getExponent(),s);
    }

    public Monomial mul(Monomial m){
        Scalar s = getCoefficient().mul(m.getCoefficient());
        int exp = getExponent() + m.getExponent();
        return new Monomial(exp,s);
    }

    public Scalar evaluate(Scalar s){
        return this.coefficient.mul(s.power(getExponent()));
    }

    public  Monomial derivative(){
        if(getExponent()==0){
            Scalar zero = new IntegerScalar(0);
            return new Monomial(0,zero);
        }
        int exp = getExponent()-1;
        Scalar s = new IntegerScalar(getExponent());
        Scalar coef = getCoefficient().mul(s);
        return new Monomial(exp,coef);
    }

    public int sign(){
        return this.coefficient.sign();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Monomial))
            return false;
        else{
            Monomial other = (Monomial) obj;
            return other.getExponent()==getExponent() && other.getCoefficient().equals(getCoefficient());
        }
    }

    @Override
    public String toString() {
        Scalar one=new IntegerScalar(1);
        Scalar minusOne=new IntegerScalar(-1);

        if(getCoefficient().sign()==0)
            return "0";

        else if(getExponent()==0)
            return this.coefficient.toString();

        else if(getExponent()==1){
            if(getCoefficient().equals(one))
                return "x";
            if(getCoefficient().equals(minusOne))
                return "-x";
            else  return this.coefficient.toString() + "x";
        }

        else if(getCoefficient().equals(one))
            return "x^"+getExponent();

        else if(getCoefficient().equals(minusOne))
            return "-x^"+getExponent();

        else return this.coefficient.toString() +"x"+"^"+ getExponent();
    }
}
