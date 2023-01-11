package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase{

    public RayTracerBasic(Scene scene) {
        super(scene);
    }
    @Override
    public Color traceRay(Ray ray) {
        List<Point> list = super.scene.geometries.findIntersections(ray);
        if(list == null) {return super.scene.background;}
        Point closest = ray.findClosestPoint(list);
        return calcColor(closest);
    }

    private Color calcColor(Point point) {
        return super.scene.ambientLight.getIntensity();
    }
}
