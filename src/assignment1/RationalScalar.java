package assignment1;

public class RationalScalar implements Scalar {
    private int numerator;
    private int denominator;

    public RationalScalar(int numerator, int denominator){
        this.numerator=numerator;
        this.denominator=denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    @Override
    public Scalar add(Scalar s) {
        return null;
    }

    @Override
    public Scalar mul(Scalar s) {
        return null;
    }

    @Override
    public Scalar neg() {
        Scalar minus = new IntegerScalar(-1);
        Scalar ans = this.mul(minus);
        return ans;
    }

    @Override
    public Scalar power(int exponent) {
        return null;
    }

    @Override
    public int sign() {
        return 0;
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        RationalScalar sRat= new RationalScalar(s.getNumber()*getDenominator(), getDenominator());
        int newNum = sRat.getNumerator() + getNumerator();
        RationalScalar ans = new RationalScalar(newNum, getDenominator());
        return ans;
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        Scalar ans;
        if(s.getDenominator()==getDenominator()){
            ans=new RationalScalar(s.numerator+getNumerator(), getDenominator());
        }
        else {

        }
    }

    public Scalar reduce(){
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RationalScalar){
            int num=((RationalScalar) obj).numerator;
            int den=((RationalScalar) obj).denominator;
            return (num == this.numerator && den == this.denominator);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.numerator + " / " + this.denominator;
    }
}
