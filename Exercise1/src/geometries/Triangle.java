package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.*;
import static primitives.Util.*;

public class Triangle extends Polygon {

    public Triangle(Point point1, Point point2, Point point3) {
        super(point1, point2, point3);
    }

    /**
     * @param p
     * @return normal {@link Vector}
     */
    @Override
    public Vector getNormal(Point p) {
        return super.getNormal(p);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Triangle " + super.toString();
    }

    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        List<Point> temp = new ArrayList<Point>();
        List<GeoPoint> list = new ArrayList<GeoPoint>();
        temp = super.plane.findIntersections(ray);
        if(temp == null) {
            return null;
        }
        Vector v1 = vertices.get(0).subtract(ray.getP0());
        Vector v2 = vertices.get(1).subtract(ray.getP0());
        Vector v3 = vertices.get(2).subtract(ray.getP0());
        Vector n1 = v1.crossProduct(v2).normalize();
        Vector n2 = v2.crossProduct(v3).normalize();
        Vector n3 = v3.crossProduct(v1).normalize();
        double dp1 = ray.getDir().dotProduct(n1);
        double dp2 = ray.getDir().dotProduct(n2);
        double dp3 = ray.getDir().dotProduct(n3);
        if (!isZero(dp1) && !isZero(dp2) && !isZero(dp3)) {
            if (checkSign(dp1, dp2) && checkSign(dp2, dp3) && checkSign(dp3, dp1)) {
                temp.forEach(i->list.add(new GeoPoint(this, i)));
                return list.size() == 0 ? null : list;
            }
        }
        return null;
    }
}
