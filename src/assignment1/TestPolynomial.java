package assignment1;

public class TestPolynomial {

    public static void main(String[] args) {
        Polynomial pol=new Polynomial("6 6 3");
        Polynomial pol1=new Polynomial("6 6 3");
        System.out.println(pol);
        System.out.println(pol.mul(pol1));

    }
}
