package part1;

public abstract class Scalar {
    public abstract Scalar add(Scalar s);
    public abstract Scalar mul(Scalar s);
    public abstract Scalar neg();
    public abstract Scalar power(int exponent);
    public abstract int sign();
    public abstract Scalar addInteger(IntegerScalar s);
    public abstract Scalar addRational(RationalScalar s);
    public abstract Scalar addReal(RealScalar s);
    public abstract Scalar mulInteger(IntegerScalar s);
    public abstract Scalar mulRational(RationalScalar s);
    public abstract Scalar mulReal(RealScalar s);

    @Override
    public boolean equals(Object o){
        if (o instanceof Scalar) {
            Scalar other = (Scalar) o;
            return (this.add(other.neg()).sign() ==0);
        }
        return false;
    }
    @Override
    public abstract String toString();
}