package tests;

import assignment1.IntegerScalar;
import assignment1.RationalScalar;
import assignment1.Scalar;
import assignment1.Polynomial;
import assignment1.Monomial;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class polynomialTest {
    @Test
    public void addPoly(){
        Polynomial poly1= new Polynomial("1 2 3");
        Polynomial poly2 = new Polynomial("4 5 6");
        Polynomial poly4= new Polynomial("5 7 9");
        Polynomial poly3 = new Polynomial("1/2 8 1/4 6");
        Polynomial poly5 = new Polynomial("11/2 15 37/4 6");
        assertEquals(poly4, poly1.add(poly2));
        assertEquals(poly5, poly4.add(poly3));
    }
    @Test
    public void mulPoly(){
        Polynomial poly4= new Polynomial("5 7 9");
        Polynomial poly3 = new Polynomial("1/2 8 1/4 6");
        poly3.mul(poly4);
        System.out.println(poly3.mul(poly4).toString());

    }


}
