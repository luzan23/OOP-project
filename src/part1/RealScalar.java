package part1;

public class RealScalar extends Scalar {
    private double number;

    public RealScalar(double number){
        this.number = number;
    }

    public double getNumber(){
        return number;

    }

    @Override
    public Scalar add(Scalar s) {
        return s.addReal(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulReal(this);
    }

    @Override
    public Scalar neg() {
        return new RealScalar(-1 * getNumber());
    }

    @Override
    public Scalar power(int exponent) {
        double ans = 1;
        for (int i = 0; i < exponent; i++) {
            ans = ans * getNumber();
        }
        return new RealScalar(ans);
    }

    @Override
    public int sign() {
        double epsilon = 1e-6;
        if (getNumber() > epsilon)
            return 1;
        if (getNumber()< -epsilon)
            return -1;
        else
            return 0;
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        return new RealScalar(s.getNumber() + getNumber() );
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        double num = 1.0 * s.getNumerator() /s.getDenominator();
        return new RealScalar(num + getNumber());
    }

    @Override
    public Scalar addReal(RealScalar s) {
        return new RealScalar(getNumber() + s.getNumber());
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return new RealScalar(s.getNumber() * getNumber() );
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        double num = 1.0 * s.getNumerator() / s.getDenominator();
        return new RealScalar(num * getNumber());
    }

    @Override
    public Scalar mulReal(RealScalar s) {
        return new RealScalar(getNumber()* s.getNumber());
    }

    @Override
    public String toString(){
        return"" + getNumber();
    }
}
