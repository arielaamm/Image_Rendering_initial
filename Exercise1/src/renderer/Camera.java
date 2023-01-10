package renderer;

import primitives.*;

public class Camera {
    private Point p0;
    private Vector Vto;
    private Vector Vup;
    private Vector Vright;
    double height;
    double width;
    double distance;

    /**
     * @param p0 - location of camera
     */
    public Camera(Point p0,Vector vto, Vector vup) {
        if (vto.dotProduct(vup) == 0) {
            this.p0 = p0;
            Vto = vto.normalize();
            Vup = vup.normalize();
            Vright = vto.crossProduct(vup).normalize();
        } else {
            throw new IllegalArgumentException(
                    "the vector:" + vto.toString() + " is not orthogonal to the vector:" + vup.toString());
        }
    }

    
    /** 
     * @param width
     * @param height
     * @return this {@link Camera}
     */
    public Camera setViewPlaneSize(double width, double height) {
        this.width = width;
        this.height = height;
        return this;
    }

    
    /** 
     * @param distance of the View Plane from the {@link Camera}
     * @return this {@link Camera}
     */
    public Camera setViewPlaneDistance(double distance) {
        this.distance = distance;
        return this;
    }

    
    /** 
     * @param nX - number of column
     * @param nY - number of row
     * @param j - index of column
     * @param i - index of row
     * @return {@link Ray} to object on the view plane
     */
    public Ray constructRay(int nX, int nY, int j, int i) {
        Point Pc = p0.add(Vto.scale(distance));
        double Ry = height / nY;
        double Rx = width / nX;
        double Xj = ((double)j-((nX-1)/2.0))*Rx;
        double Yi = -((double)i-((nY-1)/2.0))*Ry;
        Point Pij = Pc;
        if (Xj != 0)
        {
            Pij = Pij.add(Vright.scale(Xj));
        }
        if (Yi != 0)
        {
            Pij = Pij.add(Vup.scale(Yi));
        }
        Vector Vij = Pij.subtract(p0);
        return new Ray(Vij, p0);
    }
}
