package geometries;

import java.util.List;
import primitives.*;

public interface Intersectable {
    public List<Point> findIntersections(Ray ray);
}
