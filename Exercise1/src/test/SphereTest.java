package test;

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
        Point p1 = new Point(0.0662, 0.3554, 0);
        Point p2 = new Point(1.5285, 0.8428, 0);
        List<Point> result = sphere.findIntersections(new Ray(new Vector(3d, 1d, 0d), new Point(-1, 0, 0)));
        assertEquals(2, result.size(), "Wrong number of points");
        if (result.get(0).getX() > result.get(1).getX()) {
            result = List.of(result.get(1), result.get(0));
        }
        assertEquals("Ray crosses sphere", List.of(p1, p2), result);

        // TC03: Ray starts inside the sphere (1 point)
        p1 = new Point(1.8852, 0.4617, 0);
        result = sphere.findIntersections(new Ray(new Vector(3d, 1d, 0d), new Point(0.5, 0, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(p1), result, "Ray crosses sphere");

        // TC04: Ray starts after the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Vector(0.5, 1d, 0d), new Point(3, 0, 0))),
                "Ray's line out of sphere");

        // =============== Boundary Values Tests ==================

        // **** Group: Ray's line crosses the sphere (but not the center) ****
        // TC11: Ray starts at sphere and goes inside (1 points)
        p1 = new Point(0.3979, 0.8001, 0);
        result = sphere.findIntersections(new Ray(new Vector(-2d, 1d, 0d), new Point(2, 0, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(p1), result, "Ray crosses sphere");

        // TC12: Ray starts at sphere and goes outside (0 points)
        assertNull(sphere.findIntersections(new Ray(new Vector(1d, 1d, 0d), new Point(2, 0, 0))),
                "Ray's line out of sphere");

        // **** Group: Ray's line goes through the center ****
        // TC13: Ray starts before the sphere (2 points)
        p1 = new Point(0.5531, -0.8937999999999999, 0);
        p2 = new Point(1.4449, 0.8898999999999999, 0);
        result = sphere.findIntersections(new Ray(new Vector(2d, 4d, 0d), new Point(0, -2, 0)));
        assertEquals(2, result.size(), "Wrong number of points");
        if (result.get(0).getX() > result.get(1).getX()) {
            result = List.of(result.get(1), result.get(0));
        }
        assertEquals(List.of(p1, p2), result, "Ray crosses sphere");

        // TC14: Ray starts at sphere and goes inside (1 points)
        p1 = new Point(1.4479, 0.8899, 0);
        result = sphere.findIntersections(new Ray(new Vector(1.45, 2.89, 0d), new Point(0.555, -0.89, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(p1), result, "Ray crosses sphere");

        // TC15: Ray starts inside (1 points)
        p1 = new Point(1.4524, 0.8914, 0.0);
        result = sphere.findIntersections(new Ray(new Vector(2d, 4.05, 0d), new Point(1.21, 0.4, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(p1), result, "Ray crosses sphere");

        // TC16: Ray starts at the center (1 points)
        p1 = new Point(1.447, 0.894, 0);
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
