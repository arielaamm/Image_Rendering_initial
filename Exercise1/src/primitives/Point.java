package primitives;

import static primitives.Util.isZero;

public class Point {
    public static final Point ZERO = new Point(Double3.ZERO);
    protected final Double3 xyz;

    public Point(double x, double y, double z) {
        xyz = new Double3(x, y, z);
    }

    Point(Double3 xyz) {
        this.xyz = xyz;
    }

    /**
     * @param v
     * @return add {@link Point} to this point
     */
    public Point add(Vector v) {
        return new Point(this.xyz.add(v.xyz));
    }

    /**
     * @param p
     * @return subtract {@link Point}
     */
    public Vector subtract(Object p) {
        return new Vector(this.xyz.subtract(((Point)p).xyz));
    }

    /**
     * @param x
     * @param y
     * @return squared distance between x and y
     */
    public double distanceSquared(Point x, Point y) {
        return (x.xyz.d1 - y.xyz.d1) * (x.xyz.d1 - y.xyz.d1) +
                (x.xyz.d2 - y.xyz.d2) * (x.xyz.d2 - y.xyz.d2) +
                (x.xyz.d3 - y.xyz.d3) * (x.xyz.d3 - y.xyz.d3);
    }

    /**
     * @param p
     * @return distance between two points
     */
    public double distance(Point p) {
        return Math.sqrt(distanceSquared(this, p));
    }

    /* בודק האם שלושת הנקודות על אותו ישר בעזרת דטרמיננטה */

    public boolean determinant(Point p1, Point p2, Point p3) {
        if (p1 == null || p2 == null || p3 == null) {
            return false;
        }
        return (Util.isZero((p1.xyz.d1 * p2.xyz.d2 * p3.xyz.d3) -
                (p1.xyz.d1 * p2.xyz.d3 * p3.xyz.d2) +
                (p1.xyz.d2 * p2.xyz.d3 * p3.xyz.d1) -
                (p1.xyz.d2 * p2.xyz.d1 * p3.xyz.d3) +
                (p1.xyz.d3 * p2.xyz.d1 * p3.xyz.d2) -
                (p1.xyz.d3 * p2.xyz.d2 * p3.xyz.d1)));

    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Point)
            return isZero(xyz.d1 - ((Point) obj).xyz.d1) &&
                    isZero(xyz.d2 - ((Point) obj).xyz.d2) &&
                    isZero(xyz.d3 - ((Point) obj).xyz.d3);
        return false;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return xyz.toString();
    }

    public boolean isLessThan(Point point) {
        return this.distance(new Point(Double3.ZERO)) < point.distance(new Point(Double3.ZERO));
    }

/* only of the testing 
 * teacher order
 */
    public double getX() {
        return xyz.d1;
    }

    public double getY() {
        return xyz.d2;
    }

    public double getZ() {
        return xyz.d3;
    }
}
