package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import geometries.Cylinder;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class CylinderTest {
    Vector dir = new Vector(1d, 0d, 0d);
    Point start = new Point(0, 0, 0);
    Cylinder c = new Cylinder(new Ray(dir, start), 1, 5);

    @Test
    void testGetHeight() {
        assertTrue(5 == c.getHeight());
    }

    @Test
    void testGetNormal() {
        Point point = new Point(1, 1, 0);
        Vector expectedNormal = new Vector(0d, 1d, 0d);
        Vector actualNormal = c.getNormal(point);

        Point onBaseA = new Point(0, 0.5, 0.5);
        Vector expectedNormalBaseA = new Vector(-1d, 0d, 0d);
        Vector actualNormalBaseA = c.getNormal(onBaseA);

        Point onBaseB = new Point(5, 0.5, 0.5);
        Vector expectedNormalBaseB = new Vector(1d, 0d, 0d);
        Vector actualNormalBaseB = c.getNormal(onBaseB);

        // ============ Equivalence Partitions Tests ==============
        assertEquals("Unexpected normal: " + actualNormal + " expected: " + expectedNormal,
                actualNormal, (expectedNormal));
        // =============== Boundary Values Tests ==================
        assertEquals("Unexpected normal: " + actualNormalBaseA + " expected: " + expectedNormalBaseA,
                actualNormalBaseA, (expectedNormalBaseA));

        assertEquals("Unexpected normal: " + actualNormalBaseB + " expected: " + expectedNormalBaseB,
                actualNormalBaseB, (expectedNormalBaseB));
    }

    @Test
    void testFindIntersections() {

    }
}
