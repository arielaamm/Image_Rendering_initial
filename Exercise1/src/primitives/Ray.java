package primitives;

public class Ray {
    private final Point p0;
    private final Vector dir;

    public Ray(Vector v, Point p) {
        p0 = p;
        dir = v.normalize();
    }

    /**
     * @return P0 {@link Point}
     */
    public Point getP0() {
        return p0;
    }

    /**
     * @return Dir {@link Vector}
     */
    public Vector getDir() {
        return dir;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Ray))
            return false;
        return p0.equals(((Ray) obj).p0) && dir.equals(((Ray) obj).dir);
    }

    public Point getPoint(double t) {
        return getP0().add(getDir().scale(t));
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return p0.toString() + ", " + dir.toString();
    }
}
