package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.*;
import primitives.*;

public class GeometriesTest {
    Geometries geometries = new Geometries();
    Triangle t1 = new Triangle(new Point(-3, 4, 0), new Point(-4, 5, 0), new Point(-2, 4, 0));
    Sphere s = new Sphere(new Point(-4, 2, 0), 1);
    Triangle t2 = new Triangle(new Point(-2, 0, -1), new Point(-2, 3, 0), new Point(0, 3, -1));
    Triangle t3 = new Triangle(new Point(-7, 1, 0), new Point(-8, 3, -1), new Point(-6, 1, -1));

    Ray ray;
    @Test
    void testAdd() {
        geometries.add(t1, t2, s);
        assertEquals(3, geometries.intersecList.size(), "Wrong number of points");
    }

    @Test
    void testFindIntersections() {
        // ============ Equivalence Partitions Tests ==============
        // TC-EP: some geometries intersection
        ray = new Ray(new Vector(-3.5, 0, 0), new Point(0.5,2.5,-0.5)); 
        Geometries geometriesSomeIntersection = new Geometries(t1,s,t3);
        int numSize = geometriesSomeIntersection.findIntersections(ray).size();
        assertEquals(numSize,2, "should be 3 Intersections expectd: 2, got: " + numSize);
        // =============== Boundary Values Tests ==================
        // TC-BVA01: Empty geometries
        ray = new Ray(new Vector(-3.5, 0, 0), new Point(0.5,2.5,-0.5));
        Geometries geometriesEmpty = new Geometries();
        assertNull(geometriesEmpty.findIntersections(ray), "the Intersections should be null");
        // TC-BVA02: no intersections
        ray = new Ray(new Vector(-3, -2.5, 0), new Point(0.5,2.5,-0.5)); 
        Geometries geometriesNoIntersections = new Geometries(t1,s,t2,t3);
        assertNull(geometriesNoIntersections.findIntersections(ray), "the Intersections should be null");
        // TC-BVA03: 1 intersection T
        ray = new Ray(new Vector(-3, 0, -0.5), new Point(0.5,2.5,-0.5)); 
        Geometries geometries1Intersection = new Geometries(t2,s,t3);
        numSize = geometries1Intersection.findIntersections(ray).size();
        assertEquals(numSize,1, "should be 1 Intersections expectd: 1, got: " + numSize);
        // TC-BVA03: 1 intersection S
        ray = new Ray(new Vector(-3, 0, 0.5), new Point(0.5,2.5,-0.5)); 
        geometries1Intersection = new Geometries(t2,s,t3);
        numSize = geometries1Intersection.findIntersections(ray).size();
        assertEquals(numSize,2, "should be 2 Intersections expectd: 2, got: " + numSize);
        // TC-BVA03: all geometries intersection
        ray = new Ray(new Vector(-2.58,0.24,0), new Point(0.5, 1.5, -0.8)); 
        Geometries geometriesAllIntersection = new Geometries(t2,s,t3);
        numSize = geometriesAllIntersection.findIntersections(ray).size();
        assertEquals(numSize,4, "should be 4 Intersections expectd: 4, got: " + numSize);
    }
}
