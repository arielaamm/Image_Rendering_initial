package geometries;
import java.util.ArrayList;
import java.util.List;

import primitives.*;

public class Polygon implements Geometry {

    protected final List<Point> vertices = new ArrayList<Point>();
    protected Plane plane;
    
    /** 
     * @param p
     * @return normal {@link Vector}
     */
    public Vector getNormal(Point p) {
        return plane.getNormal(p);
    }
    
    /** 
     * @return 
     */
    //TODO: חסר הקוד שמשלים נמצא בקבצים שמודל
    // הבנאי והכל השיט
    @Override
    public String toString() {
        return "Polygon [vertices=" + vertices + ", plane=" + plane + "]";
    }
    
}
