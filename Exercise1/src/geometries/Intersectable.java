package geometries;

import java.util.List;
import java.util.stream.Collectors;
import primitives.*;

public abstract class Intersectable {
    public final List<Point> findIntersections(Ray ray) {
        List<GeoPoint> geoList = findGeoIntersections(ray);
        return geoList == null ? null
                : geoList.stream().map(gp -> gp.point).collect(Collectors.toList());
    }

    protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray);

    public List<GeoPoint> findGeoIntersections(Ray ray) {
        return findGeoIntersectionsHelper(ray);
    }

    public static class GeoPoint {
        /**
         * the type of the {@link Geometry}
         */
        public Geometry geometry;
        /**
         * {@link Point} on the {@link Geometry}
         */
        public Point point;

        /**
         * @param geometry - {@link Geometry}
         * @param point    - {@link Point}
         */
        public GeoPoint(Geometry geometry, Point point) {
            this.geometry = geometry;
            this.point = point;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            GeoPoint other = (GeoPoint) obj;
            if (geometry == null) {
                if (other.geometry != null)
                    return false;
            } else if (!geometry.equals(other.geometry))
                return false;
            if (point == null) {
                if (other.point != null)
                    return false;
            } else if (!point.equals(other.point))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "GeoPoint [geometry=" + geometry.toString() + ", point=" + point.toString() + "]";
        }

        public boolean isLessThan(GeoPoint point1, GeoPoint point2) {
            return point1.point.distance(new Point(0, 0, 0)) < point2.point.distance(new Point(0, 0, 0));
        }
    }

}
