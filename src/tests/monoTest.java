package tests;

import assignment1.IntegerScalar;
import assignment1.Monomial;
import assignment1.RationalScalar;
import assignment1.Scalar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class monoTest {

    @Test
    public void testAdd() {
        Scalar coe = new IntegerScalar(3);
        Monomial m1 = new Monomial(2, coe);
        Monomial m2 = new Monomial(3, coe);
        assertNull(m1.add(m2)); // Exponents are different

        Scalar coe1 = new IntegerScalar(9);
        m2 = new Monomial(2, coe1);
        assertEquals("12x^2", m1.add(m2).toString());

        coe = new RationalScalar(3, 4);
        coe1 = new RationalScalar(1, 4);
        m1 = new Monomial(3, coe);
        m2 = new Monomial(3, coe1);
        assertEquals("x^3", m1.add(m2).toString());

        coe1 = new IntegerScalar(4);
        m2 = new Monomial(3, coe1);
        assertEquals("(19/4)x^3", m1.add(m2).toString()); // Assumes format "19/4x^3" without parentheses based on standard toString implementation
    }

    @Test
    public void testEvaluate() {
        Scalar coe = new IntegerScalar(3);
        Monomial m1 = new Monomial(2, coe);
        // Evaluating 3x^2 at x=3 -> 3 * (3^2) = 27
        assertEquals("27", m1.evaluate(coe).toString());

        coe = new RationalScalar(2, 3);
        m1 = new Monomial(3, coe);
        Scalar evl = new IntegerScalar(5);
        assertEquals("(250/3)", m1.evaluate(evl).toString());
    }

    @Test
    public void testMul() {
        Scalar coe1 = new IntegerScalar(3);
        Monomial m1 = new Monomial(2, coe1);

        Scalar coe2 = new IntegerScalar(4);
        Monomial m2 = new Monomial(3, coe2);

        assertEquals("12x^5", m1.mul(m2).toString());

        Scalar coe3 = new RationalScalar(1, 2);
        Monomial m3 = new Monomial(1, coe3);
        assertEquals("6x^6", m1.mul(m2).mul(m3).toString());
    }

    @Test
    public void testDerivative() {
        Scalar coe = new IntegerScalar(4);
        Monomial m1 = new Monomial(3, coe);
        assertEquals("12x^2", m1.derivative().toString());
        Monomial m2 = new Monomial(0, new IntegerScalar(5));
        assertEquals("0", m2.derivative().toString());
    }

    @Test
    public void testSign() {
        Monomial mPositive = new Monomial(2, new IntegerScalar(5));
        assertEquals(1, mPositive.sign());

        Monomial mNegative = new Monomial(3, new IntegerScalar(-7));
        assertEquals(-1, mNegative.sign());

        Monomial mZero = new Monomial(1, new IntegerScalar(0));
        assertEquals(0, mZero.sign());
    }

    @Test
    public void testEquals() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(3));
        Monomial mDifferentExp = new Monomial(4, new IntegerScalar(3));
        Monomial mDifferentCoef = new Monomial(2, new IntegerScalar(8));

        assertTrue(m1.equals(m2));
        assertFalse(m1.equals(mDifferentExp));
        assertFalse(m1.equals(mDifferentCoef));
        assertFalse(m1.equals(null));
        assertFalse(m1.equals("3x^2"));
    }

    @Test
    public void testToString() {
        Monomial m1 = new Monomial(5, new IntegerScalar(0));
        assertEquals("0", m1.toString());

        Monomial m2 = new Monomial(0, new IntegerScalar(7));
        assertEquals("7", m2.toString());

        Monomial m3 = new Monomial(4, new IntegerScalar(1));
        assertEquals("x^4", m3.toString());

        Monomial m4 = new Monomial(3, new IntegerScalar(-5));
        assertEquals("-5x^3", m4.toString());
    }

}
