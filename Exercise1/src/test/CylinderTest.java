package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import geometries.Cylinder;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class CylinderTest {
    Cylinder c = new Cylinder(new Ray(new Vector(8, 8, 0), new Point(3, 3, 0)), 3,3);
    @Test
    void testGetHeight() {
        assertTrue(3 == c.getHeight());
    }

    @Test
    void testGetNormal() {
        Point pEP1 = new Point(6, 6, 3);//on the side
        Point pEP3 = new Point(0, 0, 1);//on the base1
        Point pEP2 = new Point(8, 8, 2);//on the base2

        // Point pBVA1 = new Point(3, 3, 3);//orthogonal to p0
        // Point pBVA2 = new Point(0, 0, 0);//center of base1
        // Point pBVA3 = new Point(8, 8, 3);//center of base2

        // Point p0 = new Point(3, 3, 0);
        // Vector v = new Vector(8,8,0);
        // ============ Equivalence Partitions Tests ==============
        assertEquals(new Vector(-381.0,-381.0,3.0).normalize(), c.getNormal(pEP1));
        assertEquals(new Vector(-635.0,-635.0,2.0).normalize(), c.getNormal(pEP2));
        assertEquals(new Vector(381.0,381.0,1.0).normalize(), c.getNormal(pEP3));
        // =============== Boundary Values Tests ==================
        // assertEquals(pBVA1.subtract(p0.add(v.scale(v.dotProduct(pBVA1.subtract(p0))))).normalize(), c.getNormal(pBVA1));
        // assertEquals(pBVA2.subtract(p0.add(v.scale(v.dotProduct(pBVA2.subtract(p0))))).normalize(), c.getNormal(pBVA2));
        // assertEquals(pBVA3.subtract(p0.add(v.scale(v.dotProduct(pBVA3.subtract(p0))))).normalize(), c.getNormal(pBVA3));

    }
}

