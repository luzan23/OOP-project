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
        return s.addRational(this);
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
        double num= getNumerator();
        double den= getDenominator();
        int newNum= (int) Math.pow(num, exponent);
        int newDen= (int) Math.pow(den, exponent);
        RationalScalar ans= new RationalScalar(newNum, newDen);
        return ans.reduce();
    }

    @Override
    public int sign() {
        if((getNumerator() >0 && getDenominator()>0) ||
                (getNumerator()<0 && getDenominator()<0))
                return 1;
        else if((getNumerator()<0 && getDenominator()>0) ||
                (getNumerator()>0 && getDenominator()<0))
            return -1;
        else return 0;
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        RationalScalar sRat= new RationalScalar(s.getNumber()*getDenominator(), getDenominator());
        int newNum = sRat.getNumerator() + getNumerator();
        RationalScalar ans = new RationalScalar(newNum, getDenominator());
        return ans.reduce();
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        RationalScalar ans;
        if(s.getDenominator()==getDenominator()){
            int a= s.numerator+getNumerator();
            int b=getDenominator();
            ans=new RationalScalar(a,b);
        }
<<<<<<< HEAD
        else {
            int b=getDenominator();
            int d=s.getDenominator();
            int gcd= gcd(b,d);
            int lcm=(b/gcd)*d;
            int mul1= lcm/b;
            int mul2= lcm/d;
            int ansNum=(getNumerator()*mul1) + (s.getNumerator()*mul2);
            ans = new RationalScalar(ansNum, lcm);
        }
        return ans.reduce();
=======
        else
            return null;
        return null;
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        return null;
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return null;
>>>>>>> fbd16fd57871d0b382f17c585b4aba8438cbf67e
    }

    public Scalar reduce(){
        int gcd = gcd(getNumerator(), getDenominator());
        Scalar ans = new RationalScalar(getNumerator()/gcd, getDenominator()/gcd);
        return ans;
    }

    private int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RationalScalar) {
            int num = ((RationalScalar) obj).numerator;
            int den = ((RationalScalar) obj).denominator;
            return (num == this.numerator && den == this.denominator);
        } else {
            if (obj instanceof IntegerScalar && reduce() instanceof IntegerScalar) {
                return ((IntegerScalar) obj).getNumber() == ((IntegerScalar) reduce()).getNumber();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.numerator + " / " + this.denominator;
    }
}
