package assignment1;

public class RationalScalar implements Scalar {
    private int numerator;
    private int denominator;

    public RationalScalar(int numerator, int denominator){
        this.numerator=numerator;
        this.denominator=denominator;
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
        return null;
    }

    @Override
    public Scalar power(int exponent) {
        int newNum= (int)Math.pow(this.numerator, exponent);
        int newDen= (int)Math.pow(this.denominator, exponent);

        Scalar ans = new RationalScalar(newNum, newDen);
        return ans;
    }

    @Override
    public int value() {
        return 0;
    }

    @Override
    public int sign() {
        if ( (this.denominator<0 && this.numerator<0) ||
                (this.denominator>0 && this.numerator>0))
            return 1;
        else if( (this.denominator<0 && this.numerator>0) ||
                (this.denominator>0 && this.numerator<0))
            return -1;
        else return 0;
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
