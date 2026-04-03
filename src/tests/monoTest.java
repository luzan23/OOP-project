package tests;

import assignment1.IntegerScalar;
import assignment1.Monomial;
import assignment1.Scalar;
import org.junit.jupiter.api.Test;

public class monoTest {

    @Test
    public void add(){
        Scalar coe=new IntegerScalar(3);
        Monomial m1=new Monomial(2, coe);
        Monomial m2=new Monomial(3, coe);
    }
}
