package renderer;

import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase{

    public RayTracerBasic(Scene scene) {
        super(scene);
    }
    @Override
    public Color traceRay(Ray ray) {
        List<GeoPoint> list = super.scene.geometries.findGeoIntersections(ray);
        if(list == null) {return super.scene.background;}
        GeoPoint closest = ray.findClosestGeoPoint(list);
        return calcColor(closest);
    }

    private Color calcColor(GeoPoint point) {
        return super.scene.ambientLight.getIntensity().add(point.geometry.getEmission());
    }
}
