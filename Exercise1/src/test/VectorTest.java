package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import primitives.Vector;
import static primitives.Util.isZero;

public class VectorTest {
    Vector v1 = new Vector(-7d,-9d,4d);
    Vector v2 = new Vector(0d,2d,0d);
    Vector v3 = new Vector(-7d,8d,4d);
    Vector v1SameDirec = new Vector(1d, -2d, 3d);
    Vector v2SameDirec = new Vector(1d, -2d, -2d);
    Vector v1DifDirec = new Vector(2d,1d,5d);
    Vector v2DifDirec = new Vector(-2d,-1d,-5d);
    Vector v1DifDirecSize = new Vector(2d,1d,6d);
    Vector v2DifDirecSize = new Vector(-2d,-1d,-7d);
    Vector v1Vertical = new Vector(0d,0d,6d);
    Vector v2Vertical = new Vector(0d,3d,0d);

    
    @Test
    void testAdd() {

    Vector v1_add_v2SameDirec = new Vector(2d,-4d,1d);
    Vector v1_add_v2DifDirecSize = new Vector(0d,0d,-1d);
    Vector v1_add_v2Vertical = new Vector(0d, 3d, 6d);
    Vector v1_add_v2 = new Vector(-7d, -7d, 4d);
    Vector v1_add_v3= new Vector(-14d,-1d,8d);
    // ============ Equivalence Partitions Tests ==============
    assertEquals("v1 + v2 not equal to v2 + v1",v1.add(v2), v2.add(v1));
    assertEquals("v2 + v1 not equal to v1 + v2",v1.add(v2), v1_add_v2);
    assertEquals("v1 + v2 not equal to v1_add_v2",v2.add(v1), v1_add_v2);
    
    assertEquals("v1 + v2 not equal to v2 + v1",v1.add(v3), v3.add(v1));
    assertEquals("v2 + v1 not equal to v1 + v2",v1.add(v3), v1_add_v3);
    assertEquals("v1 + v2 not equal to v1_add_v2",v3.add(v1), v1_add_v3);
    // =============== Boundary Values Tests ==================
    assertEquals("v1 + v2 not equal to v2 + v1",v1SameDirec.add(v2SameDirec), v2SameDirec.add(v1SameDirec));
    assertEquals("v2 + v1 not equal to v1 + v2",v1SameDirec.add(v2SameDirec), v1_add_v2SameDirec);
    assertEquals("v1 + v2 not equal to v1_add_v2",v2SameDirec.add(v1SameDirec), v1_add_v2SameDirec);

    assertEquals("v1 + v2 not equal to v2 + v1",v1DifDirecSize.add(v2DifDirecSize), v1DifDirecSize.add(v2DifDirecSize));
    assertEquals("v2 + v1 not equal to v1 + v2",v1DifDirecSize.add(v2DifDirecSize), v1_add_v2DifDirecSize);
    assertEquals("v1 + v2 not equal to v1_add_v2",v2DifDirecSize.add(v1DifDirecSize), v1_add_v2DifDirecSize);

    assertEquals("v1 + v2 not equal to v2 + v1",v1Vertical.add(v2Vertical), v2Vertical.add(v1Vertical));
    assertEquals("v2 + v1 not equal to v1 + v2",v1Vertical.add(v2Vertical), v1_add_v2Vertical);
    assertEquals("v1 + v2 not equal to v1_add_v2",v2Vertical.add(v1Vertical), v1_add_v2Vertical);
    assertThrows("crossProduct() for parallel vectors does not throw an exception",
    IllegalArgumentException.class, () -> v1DifDirec.add(v2DifDirec));

    }

    @Test
    void testCrossProduct() {
        // ============ Equivalence Partitions Tests ==============
        Vector vr = v1SameDirec.crossProduct(v2SameDirec);
        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals("crossProduct() wrong result length", v1SameDirec.length() * v2SameDirec.length(), vr.length(), 0.10001);
        // TC02: Test cross-product result orthogonality to its operands
        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1SameDirec)));
        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v2SameDirec)));

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors
        Vector v3 = new Vector(2d, -4d, 6d);
        assertThrows("crossProduct() for parallel vectors does not throw an exception",
        IllegalArgumentException.class, () -> v1SameDirec.crossProduct(v3));
        }

    @Test
    void testDotProduct() {
        // ============ Equivalence Partitions Tests ==============
        assertTrue("v1.dotProduct(v2) wrong", -18 == v1.dotProduct(v2));
        assertTrue("v2.dotProduct(v1) wrong", -18 == v2.dotProduct(v1));
        assertTrue("v1.dotProduct(v1) wrong", 146 == v1.dotProduct(v1));
        assertTrue("v2.dotProduct(v2) wrong", 4 == v2.dotProduct(v2));

        assertTrue("v1.dotProduct(v3) wrong", -7 == v1.dotProduct(v3));
        assertTrue("v2.dotProduct(v1) wrong", -7 == v3.dotProduct(v1));
        assertTrue("v1.dotProduct(v1) wrong", 146 == v1.dotProduct(v1));
        assertTrue("v2.dotProduct(v3) wrong", 129 == v3.dotProduct(v3));
        // =============== Boundary Values Tests ==================
        assertTrue("v1.dotProduct(v2) wrong", -1 == v1SameDirec.dotProduct(v2SameDirec));
        assertTrue("v2.dotProduct(v1) wrong", -1 == v2SameDirec.dotProduct(v1SameDirec));
        assertTrue("v1.dotProduct(v1) wrong", 14 == v1SameDirec.dotProduct(v1SameDirec));
        assertTrue("v2.dotProduct(v2) wrong", 9 == v2SameDirec.dotProduct(v2SameDirec));

        assertTrue("v1.dotProduct(v2) wrong", -30 == v1DifDirec.dotProduct(v2DifDirec));
        assertTrue("v2.dotProduct(v1) wrong", -30 == v2DifDirec.dotProduct(v1DifDirec));
        assertTrue("v1.dotProduct(v1) wrong", 30 == v1DifDirec.dotProduct(v1DifDirec));
        assertTrue("v2.dotProduct(v2) wrong", 30 == v2DifDirec.dotProduct(v2DifDirec));

        assertTrue("v1.dotProduct(v2) wrong", -47 == v1DifDirecSize.dotProduct(v2DifDirecSize));
        assertTrue("v2.dotProduct(v1) wrong", -47 == v2DifDirecSize.dotProduct(v1DifDirecSize));
        assertTrue("v1.dotProduct(v1) wrong", 41 == v1DifDirecSize.dotProduct(v1DifDirecSize));
        assertTrue("v2.dotProduct(v2) wrong", 54 == v2DifDirecSize.dotProduct(v2DifDirecSize));

        assertTrue("v1.dotProduct(v2) wrong", 0 == v1Vertical.dotProduct(v2Vertical));
        assertTrue("v2.dotProduct(v1) wrong", 0 == v2Vertical.dotProduct(v1Vertical));
        assertTrue("v1.dotProduct(v1) wrong", 36 == v1Vertical.dotProduct(v1Vertical));
        assertTrue("v2.dotProduct(v2) wrong", 9 == v2Vertical.dotProduct(v2Vertical));
    }

    @Test
    void testEquals() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1d, 2d, 3d);
        Vector v2 = new Vector(1d, 2d, 3d);
        assertTrue("equals went wrong",v2.equals(v1));
        assertTrue("equals went wrong",v2.equals(v2));
        assertTrue("equals went wrong",v1.equals(v1));
        assertTrue("equals went wrong",v1.equals(v2));

        Vector v3 = new Vector(-2d, -4d, -6d);
        Vector v4 = new Vector(-2d, -4d, -6d);
        assertTrue("equals went wrong",v3.equals(v4));
        assertTrue("equals went wrong",v4.equals(v3));
        assertTrue("equals went wrong",v3.equals(v3));
        assertTrue("equals went wrong",v4.equals(v4));
        // =============== Boundary Values Tests ==================
        assertFalse("v1.dotProduct(v2) wrong",v1SameDirec.equals(v2SameDirec));
        assertFalse("v2.equals(v1) wrong", v2SameDirec.equals(v1SameDirec));

        assertFalse("v1.equals(v2) wrong", v1DifDirec.equals(v2DifDirec));
        assertFalse("v2.equals(v1) wrong", v2DifDirec.equals(v1DifDirec));

        assertFalse("v1.equals(v2) wrong", v1DifDirecSize.equals(v2DifDirecSize));
        assertFalse("v2.equals(v1) wrong", v2DifDirecSize.equals(v1DifDirecSize));

        assertFalse("v1.equals(v2) wrong",v1Vertical.equals(v2Vertical));
        assertFalse("v2.equals(v1) wrong",v2Vertical.equals(v1Vertical));
    }

    @Test
    void testLength() {
        assertTrue(Math.sqrt(146) == v1.length());
        assertTrue(2 == v2.length());
    }

    @Test
    void testLengthSquared() {
        assertTrue(146 == v1.lengthSquared());
        assertTrue(4 == v2.lengthSquared());
    }
}
