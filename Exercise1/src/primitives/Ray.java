package primitives;

public class Ray {
    private final Point p0;
    private final Vector dir;
    public Ray(Vector v, Point p) {
        p0 = p;
        dir = v.normalize();
    }

    
    /** 
     * @return P0
     */ 
    public Point getP0(){
        return p0;
    }
    
    /** 
     * @return Dir
     */
    public Vector getDir(){
        return dir;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Ray))
            return false;
        return p0.equals(((Ray)obj).p0) && dir.equals(((Ray)obj).dir);
    }

    
    @Override
    public String toString() {
        return p0.toString() +", " + dir.toString();
    }
}
