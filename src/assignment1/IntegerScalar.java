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
        return null;
    }

    @Override
    public Scalar mul(Scalar s) {
        return null;
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
        return null;
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        return null;
    }

    public boolean equals2(Object obj) {
        if(!(obj instanceof Scalar))
            return false;
        else {
            Scalar other= (Scalar)obj;
            return (this.add(other.neg()).sign())==0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Scalar))
            return false;
        return false;
    }

        @Override
        public String toString() {
            return "" + number ;
        }
    }

