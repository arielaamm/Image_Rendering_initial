package lighting;

import primitives.Color;
import primitives.Point;
import static primitives.Util.*;
import primitives.Vector;

public class SpotLight extends PointLight {
    /**
     * the direction that the light is facing
     */
    private Vector direction; 

    public SpotLight(Color intensity, Point position,Vector direction) {
        super(intensity, position);
        this.direction = direction.normalize();
    }

    @Override
    public Color getIntensity(Point p) {
        double projection = this.direction.dotProduct(getL(p));

        if (isZero(projection)) {
            return Color.BLACK;
        }

        double factor = Math.max(0, projection);
        Color pointLightIntensity = super.getIntensity(p);

        return (pointLightIntensity.scale(factor));
    }

    @Override
    public double getDistance(Point p) {
        return super.getDistance(p);
    }
}
