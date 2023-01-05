package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Polygon;
import primitives.*;

public class PolygonTest {
	/**
	 * Test method for {@link geometries.Polygon#Polygon(primitives.Point...)}.
	 */
	@Test
	public void testConstructor() {
		// ============ Equivalence Partitions Tests ==============

		// TC01: Correct concave quadrangular with vertices in correct order
		try {
			new Polygon(
					new Point(0, 0, 1),
					new Point(1, 0, 0),
					new Point(0, 1, 0),
					new Point(-1, 1, 1));
		} catch (IllegalArgumentException e) {
			fail("Failed constructing a correct polygon");
		}

		// TC02: Wrong vertices order
		assertThrows(IllegalArgumentException.class, //
				() -> new Polygon(
						new Point(0, 0, 1),
						new Point(0, 1, 0),
						new Point(1, 0, 0),
						new Point(-1, 1, 1)), //
				"Constructed a polygon with wrong order of vertices");

		// TC03: Not in the same plane
		assertThrows(IllegalArgumentException.class, //
				() -> new Polygon(
						new Point(0, 0, 1),
						new Point(1, 0, 0),
						new Point(0, 1, 0),
						new Point(0, 2, 2)), //
				"Constructed a polygon with vertices that are not in the same plane");

		// TC04: Concave quadrangular
		assertThrows(IllegalArgumentException.class, //
				() -> new Polygon(
						new Point(0, 0, 1),
						new Point(1, 0, 0),
						new Point(0, 1, 0),
						new Point(0.5, 0.25, 0.5)), //
				"Constructed a concave polygon");

		// =============== Boundary Values Tests ==================

		// TC10: Vertex on a side of a quadrangular
		assertThrows(IllegalArgumentException.class, //
				() -> new Polygon(
						new Point(0, 0, 1),
						new Point(1, 0, 0),
						new Point(0, 1, 0),
						new Point(0, 0.5, 0.5)),
				"Constructed a polygon with vertix on a side");

		// TC11: Last point = first point
		assertThrows(IllegalArgumentException.class, //
				() -> new Polygon(
						new Point(0, 0, 1),
						new Point(1, 0, 0),
						new Point(0, 1, 0),
						new Point(0, 0, 1)),
				"Constructed a polygon with vertice on a side");

		// TC12: Co-located points
		assertThrows(IllegalArgumentException.class, //
				() -> new Polygon(
						new Point(0, 0, 1),
						new Point(1, 0, 0),
						new Point(0, 1, 0),
						new Point(0, 1, 0)),
				"Constructed a polygon with vertice on a side");

	}

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point)}.
	 */
	@Test
	public void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: There is a simple single test here
		Polygon pl = new Polygon(
				new Point(0, 0, 1),
				new Point(1, 0, 0),
				new Point(0, 1, 0),
				new Point(-1, 1, 1));
		double sqrt3 = Math.sqrt(1d / 3);
		assertEquals(new Vector(sqrt3, sqrt3, sqrt3).normalize(), pl.getNormal(new Point(0, 0, 1)),
				"Bad normal to trinagle");
	}

	@Test
	void testFindIntersections() {/*
		Polygon polygon = new Polygon(
				new Point(0, -1, 2),
				new Point(-1, 1, 1),
				new Point(0, 1, 0),
				new Point(1, 0, 0),
				new Point(1, -1, 1));
		// ============ Equivalence Partitions Tests ==============
		// TC01-EP: Ray to point inside the polygon (1 point)
		Point point = new Point(0.56,-0.096,0.55);
		List<Point> result = polygon.findIntersections(new Ray(new Vector(-1d, -1.27, 0.22), new Point(3, 3, 0)));
		assertEquals(1, result.size(), "Wrong number of points");
		assertEquals(List.of(point), result, "Ray crosses sphere");

		// TC02-EP: Ray to point outside the polygon (0 point)
		assertNull(polygon.findIntersections(new Ray(new Vector(-1d,-5d,1d), new Point(3, 3, 0))),
				"Ray's line out of sphere");

		// TC03-EP: Ray to point between to ray sides' the triangle (0 point)
		assertNull(polygon.findIntersections(new Ray(new Vector(-1d, -6d, 2d), new Point(3, 3, 0))),
				"Ray's line out of sphere");

		// =============== Boundary Values Tests ==================
		// TC01-VBA: Ray to point on the side of the polygon (0 point)
		assertNull(polygon.findIntersections(new Ray(new Vector(-1d, -1.59, 0.6), new Point(3, 3, 0))),
				"Ray's line out of sphere");

		// TC02-VBA: Ray to point on the Ray on the side of the polygon (0 point)
		assertNull(polygon.findIntersections(new Ray(new Vector(0d,-2.6,0d), new Point(3, 3, 0))),
				"Ray's line out of sphere");

		// TC03-VBA: Ray to point on the vertex of the polygon (0 point)
		assertNull(polygon.findIntersections(new Ray(new Vector(-1.64,0.82,0.41), new Point(3, 3, 0))),
				"Ray's line out of sphere");*/
	}
}
