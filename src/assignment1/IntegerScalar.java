package assignment1;

public class IntegerScalar implements Scalar {
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
        return s.mul(this);
    }

    @Override
    public Scalar neg() {
        Scalar ans = new IntegerScalar(-1 * number);
        return ans;
    }

    @Override
    public Scalar power(int exponent) {
        int ans = 1;
        for (int i = 0; i < exponent; i++) {
            ans = ans * number;
        }
        Scalar result = new IntegerScalar(ans);
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
        Scalar ans = new IntegerScalar(number+s.getNumber());
        return ans;
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        Scalar ans = new RationalScalar(s.getNumerator()+number*s.getDenominator(),s.getDenominator());
        return ans;
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        IntegerScalar ans =new IntegerScalar(s.getNumber()*number);
        return ans;
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        RationalScalar ans = new RationalScalar(number*s.getNumerator(),s.getDenominator());
        return ans;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Scalar))
            return false;
        if (obj instanceof RationalScalar) {
            RationalScalar instance = (RationalScalar) obj;
            if (instance.getNumerator() % instance.getDenominator() == 0)
                return number == instance.getNumerator() / instance.getDenominator();
            else
                return false;
        }
        else {
            IntegerScalar instance = (IntegerScalar) obj;
            return number == instance.getNumber();
        }
    }

        @Override
        public String toString() {
            return "" + number ;
        }
    }

