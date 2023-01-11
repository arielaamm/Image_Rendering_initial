package test.geometriesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Triangle;
import primitives.*;

public class TriangleTest {

    Triangle t = new Triangle(new Point(-8, 3, 2), new Point(-4, 6, 1), new Point(-7, 4, -1));

    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC-EP: point point inside the triangle
        assertEquals(new Vector(-0.5865, 0.8065, 0.0733).normalize(), t.getNormal(new Point(-678, 4d, 0.79)));
        // =============== Boundary Values Tests ==================
        // TC-BVA: point on the apex of the triangle
        assertEquals(new Vector(-0.5865, 0.8065, 0.0733).normalize(), t.getNormal(new Point(-8, 3, 2)));
    }

    @Test
    void testFindIntersections() {
        // ============ Equivalence Partitions Tests ==============
        // TC01-EP: Ray to point inside the triangle (1 point)
        Point point = new Point(-6.8299,3.9608,0.7997);
        List<Point> result = t.findIntersections(new Ray(new Vector(-1.68, 1.38, 0.28), new Point(-2, 0, 0)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(point), result, "Ray crosses sphere");

        // TC02-EP: Ray to point outside the triangle (0 point)
        assertNull(t.findIntersections(new Ray(new Vector(2d, -2d, 1.41d), new Point(-2, 0, 0))),"Ray's line out of sphere");

        // TC03-EP: Ray to point between to ray sides' the triangle (0 point)
        assertNull(t.findIntersections(new Ray(new Vector(0.13, 2.05, 0.29), new Point(-2, 0, 0))),"Ray's line out of sphere");

        // =============== Boundary Values Tests ==================
        // TC01-VBA: Ray to point on the side of the triangle (0 point)
        assertNull(t.findIntersections(new Ray(new Vector(-1.12, -1.15, 0.41), new Point(-2, 0, 0))),"Ray's line out of sphere");

        // TC02-VBA: Ray to point on the Ray on the side of the triangle (0 point)  
        assertNull(t.findIntersections(new Ray(new Vector(0d, 1.99, 0.13), new Point(-2, 0, 0))),"Ray's line out of sphere");

        // TC03-VBA: Ray to point on the vertex of the triangle (0 point)
        assertNull(t.findIntersections(new Ray(new Vector(-1.585, 1.41, 0.57), new Point(-2, 0, 0))),"Ray's line out of sphere");
    }
}
