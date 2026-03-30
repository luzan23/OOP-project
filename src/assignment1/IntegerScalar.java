package assignment1;

public class IntegerScalar implements Scalar {
    private int number;

    public IntegerScalar(int number) {
        this.number = number;
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

