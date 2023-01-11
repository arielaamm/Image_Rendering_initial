package test.rendererTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import geometries.*;
import primitives.*;
import renderer.Camera;

/**
 * Testing Camera Class
 * 
 * @author Ariel Moreshet
 *
 */
public class CameraTest {
    static final Point ZERO_POINT = new Point(0, 0, 0);

    /**
     * Test method for
     * {@link elements.Camera#constructRay(int, int, int, int)}.
     */
    @Test
    void testConstructRay() {
        Camera camera = new Camera(ZERO_POINT, new Vector(0, 0, -1), new Vector(0, -1, 0))
            .setViewPlaneDistance(10);
        String badRay = "Bad ray";

        // ============ Equivalence Partitions Tests ==============
        // EP01: 4X4 Inside (1,1)
        assertEquals(new Ray(new Vector(1, -1, -10), ZERO_POINT),
            camera.setViewPlaneSize(8, 8).constructRay(4, 4, 1, 1), badRay);

        // =============== Boundary Values Tests ==================
        // BV01: 3X3 Center (1,1)
        assertEquals(new Ray(new Vector(0, 0, -10), ZERO_POINT),
            camera.setViewPlaneSize(6, 6).constructRay(3, 3, 1, 1), badRay);

        // BV02: 3X3 Center of Upper Side (0,1)
        assertEquals(new Ray(new Vector(0, -2, -10), ZERO_POINT),
            camera.setViewPlaneSize(6, 6).constructRay(3, 3, 1, 0), badRay);

        // BV03: 3X3 Center of Left Side (1,0)
        assertEquals(new Ray(new Vector(2, 0, -10), ZERO_POINT),
            camera.setViewPlaneSize(6, 6).constructRay(3, 3, 0, 1), badRay);

        // BV04: 3X3 Corner (0,0)
        assertEquals(new Ray(new Vector(2, -2, -10), ZERO_POINT),
            camera.setViewPlaneSize(6, 6).constructRay(3, 3, 0, 0), badRay);

        // BV05: 4X4 Corner (0,0)
        assertEquals(new Ray(new Vector(3, -3, -10), ZERO_POINT),
            camera.setViewPlaneSize(8, 8).constructRay(4, 4, 0, 0), badRay);

        // BV06: 4X4 Side (0,1)
        assertEquals(new Ray(new Vector(1, -3, -10), ZERO_POINT),
            camera.setViewPlaneSize(8, 8).constructRay(4, 4, 1, 0), badRay);
    }

    @Test
    void testConstructRayWithSphere() {
        Camera camera;
        Sphere sphere;
        int count = 0;
        // TC01
        sphere = new Sphere(new Point(0, 0, -3), 1);
        camera = new Camera(ZERO_POINT, new Vector(0, 0, -1), new Vector(0, -1, 0)).setViewPlaneDistance(1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((sphere.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += sphere.findIntersections(
                        camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }
        }
        assertEquals(2, count);
        count = 0;
        // TC02
        sphere = new Sphere(new Point(0, 0, -2.5), 2.5);
        camera = new Camera(new Point(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, -1, 0))
            .setViewPlaneDistance(1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((sphere.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += sphere.findIntersections(
                        camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }
        }
        assertEquals(18, count);
        count = 0;
        // TC03
        sphere = new Sphere(new Point(0, 0, -2), 2);
        camera = new Camera(new Point(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, -1, 0))
            .setViewPlaneDistance(1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((sphere.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += sphere.findIntersections(
                        camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }
        }
        assertEquals(10, count);
        count = 0;
        // TC04
        sphere = new Sphere(new Point(0, 0, -1), 4);
        camera = new Camera(new Point(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, -1, 0))
            .setViewPlaneDistance(1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((sphere.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += sphere.findIntersections(
                        camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }
        }
        assertEquals(9, count);
        count = 0;
        // TC05
        sphere = new Sphere(new Point(0, 0, 1), 0.5);
        camera = new Camera(new Point(0, 0, 0), new Vector(0, 0, -1), new Vector(0, -1, 0))
            .setViewPlaneDistance(1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((sphere.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += sphere.findIntersections(
                        camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }
        }
        assertEquals(0, count);
        count = 0;
    }

    @Test
    void testConstructRayWithPlane() {
        Camera camera = new Camera(ZERO_POINT, new Vector(0, 0, -1), new Vector(0, -1, 0)).setViewPlaneDistance(1);
        Plane plane;
        int count = 0;
        Point p1, p2, p3;
        // TC01
        p1 = new Point(-2, 0, -2);
        p2 = new Point(2, -2, -2);
        p3 = new Point(0, 0, -2);
        plane = new Plane(p1, p2, p3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((plane.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += plane.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }
        }
        assertEquals(9, count);
        count = 0;
        // TC02
        p1 = new Point(3, -3, -3);
        p2 = new Point(-1.5, 0, -1.5);
        p3 = new Point(0, 0, -2);
        plane = new Plane(p1, p2, p3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((plane.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += plane.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }
        }
        assertEquals(9, count);
        count = 0;
        // TC03 // filed
        p1 = new Point(-0.5,0,0);
        p2 = new Point(0.5,-1.5,-1);
        p3 = new Point(0.5,1.5,-1);
        plane = new Plane(p1, p2, p3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((plane.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += plane.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }
        }
        assertEquals(6, count);
        count = 0;
    }

    @Test
    void testConstructRayWithTriangle() {
        Triangle triangle;
        Camera camera = new Camera(ZERO_POINT, new Vector(0, 0, -1), new Vector(0, -1, 0)).setViewPlaneDistance(1);
        int count = 0;
        Point p1, p2, p3;
        // TC01
        p1 = new Point(0, 1, -2);
        p2 = new Point(1, -1, -2);
        p3 = new Point(-1, -1, -2);
        triangle = new Triangle(p1, p2, p3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((triangle.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += triangle.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }
        }
        assertEquals(1, count);
        count = 0;
        // TC02
        p1 = new Point(0, 20, -2);
        p2 = new Point(1, -1, -2);
        p3 = new Point(-1, -1, -2);
        triangle = new Triangle(p2, p1, p3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((triangle.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)) != null)) {
                    count += triangle.findIntersections(camera.setViewPlaneSize(3, 3).constructRay(3, 3, j, i)).size();
                }
            }

        }
        assertEquals(2, count);
        count = 0;

    }
}