package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import geometries.Cylinder;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class CylinderTest {
    Vector dir = new Vector(1, 0, 0);
    Point start = new Point(0, 0, 0);
    Cylinder c = new Cylinder(new Ray(dir, start), 1,5);    @Test
    void testGetHeight() {
        assertTrue(5 == c.getHeight());
    }

    @Test
    void testGetNormal() {
        Point point = new Point(1, 1, 0);
        Vector expectedNormal = new Vector(0, 1, 0);
        Vector actualNormal = c.getNormal(point);

        Point onBaseA = new Point(0,0.5,0.5);
        Vector expectedNormalBaseA = new Vector(-1, 0, 0);
        Vector actualNormalBaseA = c.getNormal(onBaseA);

        Point onBaseB = new Point(5,0.5,0.5);
        Vector expectedNormalBaseB = new Vector(1, 0, 0);
        Vector actualNormalBaseB = c.getNormal(onBaseB);


        // ============ Equivalence Partitions Tests ==============
        assertEquals("Unexpected normal: " + actualNormal + " expected: " + expectedNormal,
        actualNormal,(expectedNormal));
        // =============== Boundary Values Tests ==================
        assertEquals("Unexpected normal: " + actualNormalBaseA + " expected: " + expectedNormalBaseA,
        actualNormalBaseA,(expectedNormalBaseA));

        assertEquals("Unexpected normal: " + actualNormalBaseB + " expected: " + expectedNormalBaseB,
        actualNormalBaseB,(expectedNormalBaseB));

//TODO: לבדוק בסיסים

    }
}

