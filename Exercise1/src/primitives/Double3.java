package primitives;

// TODO: 
// + subtract(Double3):Double3
// + product(Double3):Double3
// + reduce(double):Double3
public class Double3 {
    protected static final Double3 ZERO = new Double3(0, 0, 0);

    final double d1, d2, d3;

    public Double3(double d1, double d2, double d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    /**
     * @param xyz
     * @return add {@link Double3}
     */
    public Double3 add(Double3 xyz) {
        return new Double3(d1 + xyz.d1, d2 + xyz.d2, d3 + xyz.d3);
    }

    /**
     * @param xyz
     * @return subtract {@link Double3}
     */
    public Double3 subtract(Double3 xyz) {
        return new Double3(d1 - xyz.d1, d2 - xyz.d2, d3 - xyz.d3);
    }

    
    /** 
     * @param d
     * @return 
     */
    public Double3 scale(double d) {
        return new Double3(d1 * d, d2 * d, d3 * d);
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Double3))
            return false;
        Double3 other = (Double3) obj;
        return Util.isZero(d1 - other.d1) &&
                Util.isZero(d2 - other.d2) &&
                Util.isZero(d3 - other.d3);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "(" + d1 + "," + d2 + "," + d3 + ")";
    }

}
