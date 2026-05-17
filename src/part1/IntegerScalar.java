package part1;

public class IntegerScalar extends Scalar {
    private int number;

    public IntegerScalar(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(-1 * getNumber());
    }

    @Override
    public Scalar power(int exponent) {
        int ans = 1;
        for (int i = 0; i < exponent; i++) {
            ans = ans * getNumber();
        }
        return new IntegerScalar(ans);
    }

    @Override
    public int sign() {
        if (getNumber() > 0)
            return 1;
        else if (getNumber() < 0)
            return -1;
        else
            return 0;
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        return new IntegerScalar(getNumber()+s.getNumber());
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        int newNum = s.getNumerator()+getNumber()*s.getDenominator();
        RationalScalar ans = new RationalScalar(newNum,s.getDenominator());
        return ans.reduce();
    }

    @Override
    public Scalar addReal(RealScalar s) {
        return new RealScalar(s.getNumber()+getNumber());
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return new IntegerScalar(s.getNumber()*getNumber());
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        RationalScalar ans = new RationalScalar(getNumber()*s.getNumerator(),s.getDenominator());
        return ans.reduce();
    }

    @Override
    public Scalar mulReal(RealScalar s) {
        return new RealScalar(s.getNumber() * getNumber() );
    }

    @Override
    public String toString() {
        return "" +getNumber();

    }
}


