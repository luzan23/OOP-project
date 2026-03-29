package assignment1;

public class RationalScalar implements Scalar {
    private int numerator;
    private int denominator;


    @Override
    public int value() {
        return 0;
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
        return null;
    }

    @Override
    public int sign() {
        return 0;
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
