package test.geometriesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Sphere;
import primitives.*;

public class SphereTest {
    Sphere s = new Sphere(new Point(2, 2, 2), 3);

    @Test
    void testGetCenter() {
        assertEquals(new Point(2, 2, 2), s.getCenter());
    }

    @Test
    void testGetNormal() {
        assertEquals((new Vector(-2d, 1d, -2d)).normalize(), s.getNormal(new Point(0, 3, 0)));
    }

    @Test
    void testGetRadius() {
        assertTrue(3 == s.getRadius());
    }

    /**
     * Test method for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
     */
    @Test
    public void testFindIntersections() {
        Sphere sphere = new Sphere(new Point(1, 0, 0), 1d);
        // ============ Equivalence Partitions Tests ==============
        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Vector(1d, 1d, 0d), new Point(-1, 0, 0))),
                "Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point p1 = new Point(0.06515307716504659,0.35505102572168223,0.0);
        Point p2 = new Point(1.5348469228349528,0.8449489742783177,0.0);
        List<Point> result = sphere.findIntersections(new Ray(new Vector(3d, 1d, 0d), new Point(-1, 0, 0)));
        assertEquals(2, result.size(), "Wrong number of points");
        if (result.get(0).getX() > result.get(1).getX()) {
            result = List.of(result.get(1), result.get(0));
        }
        assertEquals("Ray crosses sphere", List.of(p1, p2), result);

        // TC03: Ray starts inside the sphere (1 point)
        p1 = new Point(1.8867496997597595,0.4622498999199199,0.0);
        result = sphere.findIntersections(new Ray(new Vector(3d, 1d, 0d), new Point(0.5, 0, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(p1), result, "Ray crosses sphere");

        // TC04: Ray starts after the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Vector(0.5, 1d, 0d), new Point(3, 0, 0))),
                "Ray's line out of sphere");

        // =============== Boundary Values Tests ==================

        // **** Group: Ray's line crosses the sphere (but not the center) ****
        // TC11: Ray starts at sphere and goes inside (1 points)
        p1 = new Point(0.40000000000000013,0.7999999999999999,0.0);
        result = sphere.findIntersections(new Ray(new Vector(-2d, 1d, 0d), new Point(2, 0, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(p1), result, "Ray crosses sphere");

        // TC12: Ray starts at sphere and goes outside (0 points)
        assertNull(sphere.findIntersections(new Ray(new Vector(1d, 1d, 0d), new Point(2, 0, 0))),
                "Ray's line out of sphere");

        // **** Group: Ray's line goes through the center ****
        // TC13: Ray starts before the sphere (2 points)
        p1 = new Point(0.5527864045000421,-0.8944271909999157,0.0);
        p2 = new Point(1.4472135954999579,0.8944271909999157,0.0);
        result = sphere.findIntersections(new Ray(new Vector(2d, 4d, 0d), new Point(0, -2, 0)));
        assertEquals(2, result.size(), "Wrong number of points");
        if (result.get(0).getX() > result.get(1).getX()) {
            result = List.of(result.get(1), result.get(0));
        }
        assertEquals(List.of(p1, p2), result, "Ray crosses sphere");

        // TC14: Ray starts at sphere and goes inside (1 points)
        p1 = new Point(1.4496799755809229,0.8931897444337015,0.0);
        result = sphere.findIntersections(new Ray(new Vector(1.45, 2.89, 0d), new Point(0.555, -0.89, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(p1), result, "Ray crosses sphere");

        // TC15: Ray starts inside (1 points)
        p1 = new Point(1.4527771452991114,0.8916237192307006,0.0);
        result = sphere.findIntersections(new Ray(new Vector(2d, 4.05, 0d), new Point(1.21, 0.4, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(p1), result, "Ray crosses sphere");

        // TC16: Ray starts at the center (1 points)
        p1 = new Point(1.4472135954999579,0.8944271909999159,0.0);
        result = sphere.findIntersections(new Ray(new Vector(1d, 2d, 0d), new Point(1, 0, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(p1), result, "Ray crosses sphere");

        // TC17: Ray starts at sphere and goes outside (0 points)
        assertNull(sphere.findIntersections(new Ray(new Vector(1d, 2d, 0d), new Point(1.4563, 0.8898999999999999, 0))),
                "Ray's line out of sphere");

        // TC18: Ray starts after sphere (0 points) //failed
        assertNull(sphere.findIntersections(new Ray(new Vector(1d, 2d, 0d), new Point(1.59, 1.19, 0))),
                "Ray's line out of sphere");

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        assertNull(sphere.findIntersections(new Ray(new Vector(1d, 0d, 0d), new Point(0, 1, 0))),
                "Ray's line out of sphere");

        // TC20: Ray starts at the tangent point
        assertNull(sphere.findIntersections(new Ray(new Vector(3d, 0d, 0d), new Point(1, 1, 0))),
                "Ray's line out of sphere");

        // TC21: Ray starts after the tangent point
        assertNull(sphere.findIntersections(new Ray(new Vector(2d, 0d, 0d), new Point(2, 1, 0))),
                "Ray's line out of sphere");

        // **** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's
        // center line
        assertNull(sphere.findIntersections(new Ray(new Vector(3d, 0d, 0d), new Point(1, 2, 0))),
                "Ray's line out of sphere");
    }
}
