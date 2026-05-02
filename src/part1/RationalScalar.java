package part1;

public class RationalScalar implements Scalar {
    private int numerator;
    private int denominator;

    public RationalScalar(int numerator, int denominator){
        if(denominator==0)
            throw new IllegalArgumentException("denominator cant be 0");
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
       return s.mulRational(this);
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
    }

    @Override
    public Scalar addReal(RealScalar s) {
        double num = 1.0 * numerator / denominator;
        Scalar ans = new RealScalar(num + s.getNumber());
        return ans;
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        RationalScalar ans;
        int newNum=getNumerator()*s.getNumerator();
        int newDen=getDenominator()*s.getDenominator();
        ans=new RationalScalar(newNum, newDen);
        return ans.reduce();
    }

    @Override
    public Scalar mulReal(RealScalar s) {
        double num = 1.0 * numerator / denominator;
        Scalar ans = new RealScalar(num * s.getNumber());
        return ans;
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        RationalScalar ans=new RationalScalar(s.getNumber()*getNumerator(), getDenominator());
        return ans.reduce();
    }

    public Scalar reduce(){
        int gcd = gcd(getNumerator(), getDenominator());
        int newNum=getNumerator()/gcd;
        int newDen=getDenominator()/gcd;

        if (newDen < 0) {
            newNum = newNum * -1;
            newDen = newDen * -1;
        }

        Scalar ans = new RationalScalar(newNum, newDen);
        if(newDen==1){
            ans = new IntegerScalar(newNum);
        }
        else if(newDen==newNum){
            ans=new IntegerScalar(1);
        }
        return ans;
    }

    private int gcd(int a, int b){
        if(b==0)
            return Math.abs(a);
        return gcd(b, a%b);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Scalar) {
            Scalar other = (Scalar) obj;
            return (this.add(other.neg()).sign() ==0);
        }
        return false;
    }

    @Override
    public String toString() {
        String ans = "("+this.numerator + "/" + this.denominator+")";
        return ans;
    }
}
