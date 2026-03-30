package assignment1;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar neg();
    Scalar power(int exponent);
    int sign();

    Scalar addInteger(IntegerScalar s);
    Scalar addRational(RationalScalar s);
    @Override
    boolean equals(Object o);
    @Override
    String toString();
}