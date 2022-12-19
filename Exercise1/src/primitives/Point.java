package primitives;
//complied
public class Point {
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
    public Vector subtract(Point p) {
        return new Vector(this.xyz.subtract(p.xyz));
    }
    
    
    /** 
     * @param x
     * @param y
     * @return squared distance between x and y
     */
    public double distanceSquared(Point x,Point y) {
        return (x.xyz.d1 - y.xyz.d1) * (x.xyz.d1 - y.xyz.d1) +
               (x.xyz.d2 - y.xyz.d2) * (x.xyz.d2 - y.xyz.d2) + 
               (x.xyz.d3 - y.xyz.d3) * (x.xyz.d3 - y.xyz.d3);
    }

    
    /** 
     * @param p
     * @return distance between two points
     */
    public double distance(Point p)
    {
        return Math.sqrt(distanceSquared(this, p));
    }

    
    /** 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Point))
            return false;
        return super.equals(obj);
    }

    
    
    /** 
     * @return 
     */
    @Override
    public String toString() {
        return xyz.toString();
    }

}
