package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import geometries.Tube;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class TubeTest {
    Tube t = new Tube(new Ray(new Vector(8, 8, 0), new Point(3, 3, 0)), 3);
    @Test
    void testGetAxisRay() {
        assertEquals(new Ray(new Vector(8, 8, 0), new Point(3, 3, 0)),t.getAxisRay());
    }
    @Test
    void testGetNormal() {
        Point pEP = new Point(6, 6, 3);
        // Point pBVA = new Point(3, 3, 3);
        // Point p0 = new Point(3, 3, 0);
        // Vector v = new Vector(8,8,0);
        // ============ Equivalence Partitions Tests ==============
        assertEquals(new Vector(-381,-381,3).normalize(), t.getNormal(pEP));
        // =============== Boundary Values Tests ==================
        // assertEquals(pBVA.subtract(p0.add(v.scale(v.dotProduct(pBVA.subtract(p0))))).normalize(), t.getNormal(pBVA));

    }

    @Test
    void testGetRadius() {
        assertTrue( t.getRadius() == 3);
    }
}
