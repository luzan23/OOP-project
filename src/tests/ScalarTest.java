package tests;

import assignment1.IntegerScalar;
import assignment1.RationalScalar;
import assignment1.Scalar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScalarTest {
    @Test
    public void  testAdd(){
        Scalar s1 = new RationalScalar(1,2);
        Scalar s2 = new RationalScalar(3,4);
        assertEquals( "5 / 4",s1.add(s2).toString() );
        s1= new RationalScalar(4,6);
        s2 = new RationalScalar(8,4);
        assertEquals("8 / 3", s1.add(s2).toString());
        s1 = new RationalScalar(3,4);
        s2 = new IntegerScalar(2);
        assertEquals("11 / 4", s1.add(s2).toString());
        assertEquals("11 / 4", s2.add(s1).toString());
        s1 = new IntegerScalar(5);
        s2 = new IntegerScalar(-5);
        assertEquals("0",s1.add(s2).toString());
    }
    @Test
    public void  testMul(){

    }
    @Test
    public void testNeg(){

    }
    @Test
    public void testPower(){

    }
    @Test
    public void testEquals(){

    }
     @Test
    public void testTostring(){

     }

     @Test
    public void testResuce(){

     }












}
