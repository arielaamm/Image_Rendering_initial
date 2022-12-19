package primitives;

public class Vector extends Point {
    Vector(Double3 xyz) {
        super(xyz);
        if (xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("the vector is the zero vector");
        }
    }

    public Vector(Double x, Double y, Double z) {
        super(x, y, z);
        if (new Double3(x, y, z).equals(Double3.ZERO)) {
            throw new IllegalArgumentException("the vector is the zero vector");
        }
    }

    /**
     * @param v
     * @return add {@link Vector}
     */
    public Vector add(Vector v) {
        return new Vector(super.add(v).xyz);
    }

    public Vector scale(double d) {
        return new Vector(xyz.scale(d));
    }

    public double lengthSquared() {
        return distanceSquared(new Point(Double3.ZERO), new Point(xyz));
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public Vector normalize() {
        return new Vector(xyz.scale(1 / length()));
    }

    // TODO:
    // + crossProduct(Vector): Vector
    // + dotProduct(Vector): double

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Vector))
            return false;
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "->" + super.toString();
    }
}
