package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class PointLight extends Light implements LightSource {
    /**
     * The light source position
     */
    private Point position; 
    double kC = 1, kL = 0, kQ = 0;

    public PointLight(Color intensity, Point position) {
        super(intensity);
        this.position = position;

    }
    @Override
    public Color getIntensity(Point p) {
        double distance = getDistance(p);
        double sum = 1/(kC  + kL * distance + kQ * distance * distance);
        return getIntensity().scale(sum);
    }

    @Override
    public Vector getL(Point p) {
        return p.subtract(this.position).normalize();
    }

    public PointLight setKc(double kC) {
        this.kC = kC;
        return this;
    }

    public PointLight setKl(double kL) {
        this.kL = kL;
        return this;
    }

    public PointLight setKq(double kQ) {
        this.kQ = kQ;
        return this;
    }
    @Override
    public double getDistance(Point point) {
        return this.position.distance(point);
        
    }
}
