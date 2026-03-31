package assignment1;
public class Monomial {

    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent,Scalar coefficient){
        this.exponent=exponent;
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m){
        if (exponent != m.exponent)
            return null;
        Scalar s = coefficient.add(m.coefficient);
        Monomial ans = new Monomial(exponent,s);
        return ans;
    }

    public Monomial mul(Monomial m){
        Scalar s = coefficient.mul(m.coefficient);
        int exp = exponent + m.exponent;
        Monomial ans = new Monomial(exp,s);
        return ans;
    }

    public Scalar evaluate(Scalar s){
        Scalar pow = new IntegerScalar(1);
        for (int i=0; i<exponent; i++)
            pow = pow.mul(s);
        Scalar ans = pow.mul(coefficient);
        return ans;
    }

    public  Monomial derivative(){
        int exp = exponent-1;
        Scalar s = new IntegerScalar(exponent);
        Scalar coef = coefficient.mul(s);
        Monomial ans = new Monomial(exp,coef);
        return ans;
    }

    public int sign(){
        return coefficient.sign();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Monomial))
            return false;
        else{
            Monomial other = (Monomial) obj;
            return other.exponent==exponent && other.coefficient.equals(coefficient);
        }
    }

    @Override
    public String toString() {
        return "" + coefficient +"x"+"^"+ exponent;
    }
}
