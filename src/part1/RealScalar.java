package part1;

public class RealScalar implements Scalar {
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
        Scalar ans = new RealScalar(-1 * number);
        return ans;
    }

    @Override
    public Scalar power(int exponent) {
        double ans = 1;
        for (int i = 0; i < exponent; i++) {
            ans = ans * number;
        }
        Scalar result = new RealScalar(ans);
        return result;
    }

    @Override
    public int sign() {
        if (number > 0)
            return 1;
        if (number < 0)
            return -1;
        else
            return 0;
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        Scalar ans = new RealScalar(s.getNumber() + number );
        return ans;
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        double num = 1.0 * s.getNumerator() /s.getDenominator();
        Scalar ans = new RealScalar(num + number);
        return ans;
    }

    @Override
    public Scalar addReal(RealScalar s) {
        Scalar ans = new RealScalar(number + s.getNumber());
        return ans;
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        Scalar ans = new RealScalar(s.getNumber() * number );
        return ans;
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        double num = 1.0 * s.getNumerator() / s.getDenominator();
        Scalar ans = new RealScalar(num * number);
        return ans;
    }

    @Override
    public Scalar mulReal(RealScalar s) {
        Scalar ans = new RealScalar(number * s.getNumber());
        return ans;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Scalar) {
            Scalar other = (Scalar) o;
            return (this.add(other.neg()).sign() ==0);
        }
        return false;
    }
    @Override
    public String toString(){
        String ans="";
        ans+="" + number ;
        return ans;
    }
}
