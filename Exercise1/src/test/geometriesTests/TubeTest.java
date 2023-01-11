package test.geometriesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import geometries.Tube;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class TubeTest {
    Vector dir = new Vector(0d, 1d, 0d);
    Point start = new Point(0, 0, 0);
    Tube t = new Tube(new Ray(dir, start), 1);
    @Test
    void testGetAxisRay() {
        assertEquals((new Ray(dir, start)),t.getAxisRay());
    }
    @Test
    void testGetNormal() {
        Point pointEP = new Point(-1, 2, 0);
        Point pointBVA = new Point(-1, 0, 0);
        Vector expectedNormal = new Vector(-1d, 0d, 0d).normalize();
        Vector actualNormalEP = t.getNormal(pointEP);
        Vector actualNormalBVA = t.getNormal(pointBVA);
        // ============ Equivalence Partitions Tests ==============
        assertEquals("Unexpected normal: " + actualNormalEP + " expected: " + expectedNormal,
        actualNormalEP,(expectedNormal));
        // =============== Boundary Values Tests ==================
        assertEquals("Unexpected normal: " + actualNormalBVA + " expected: " + expectedNormal,
        actualNormalBVA,(expectedNormal));
    }

    @Test
    void testGetRadius() {
        assertTrue( t.getRadius() == 1);
    }
    @Test
    void testFindIntersections()
    {

    }
}
