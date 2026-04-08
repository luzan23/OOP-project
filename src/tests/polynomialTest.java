package tests;

import assignment1.IntegerScalar;
import assignment1.RationalScalar;
import assignment1.Scalar;
import assignment1.Polynomial;
import assignment1.Monomial;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class polynomialTest {
    @Test
    public void addPolyTest(){
        Polynomial poly1= new Polynomial("1 2 3");
        Polynomial poly2 = new Polynomial("4 5 6");
        Polynomial poly4= new Polynomial("5 7 9");
        Polynomial poly3 = new Polynomial("1/2 8 1/4 6");
        Polynomial poly5 = new Polynomial("11/2 15 37/4 6");
        assertEquals(poly4, poly1.add(poly2));
        assertEquals(poly5, poly4.add(poly3));
    }
    @Test
    public void mulPolyTest(){
        Polynomial poly4= new Polynomial("5 7 9");
        Polynomial poly3 = new Polynomial("1/2 8 1/4 6");
        poly3.mul(poly4);

    }
    @Test
    public void evaluatePolyTest(){
        Polynomial poly4= new Polynomial("5 7 9");
        Scalar eva = new IntegerScalar(2);
        Scalar s= new IntegerScalar(55) ;
        assertEquals(s.toString(),poly4.evaluate(eva).toString());
        eva = new RationalScalar(1 ,2);
        s= new RationalScalar(43,4);
    }
    @Test
    public void derivativePolyTest(){
        Polynomial poly3 = new Polynomial("8 6 1/2");
        String deri= "x"+"^"+"1"+"+"+ "6";
        assertEquals(deri,poly3.derivative().toString());
    }
    @Test
    public void EqualsPolyTest() {
        Polynomial p1 = new Polynomial("1 1/2 5");
        Polynomial p2 = new Polynomial("1 1/2 5");
        Polynomial p3 =new Polynomial("1 2 6");
        Polynomial p4 =new Polynomial("1 2 7");

        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(p3.equals(p4));
        assertFalse(p3.equals(null));
        assertFalse(p4.equals("3x^2"+"2x^1+5"));
    }
    @Test
    public void toStringPolyTest(){
        Polynomial p2 = new Polynomial("1 1/2 5");
        Polynomial p3 =new Polynomial("1 2 6");
        assertEquals("5x^2+(1/2)x^1+1", p2.toString());
        assertEquals("6x^2+2x^1+1", p3.toString());

    }


}
