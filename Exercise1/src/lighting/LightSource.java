package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public interface LightSource {
    /**
     * @param p - {@link Point}
     * @return the intensity of the light - {@link Color}
     */
    public Color getIntensity(Point p);

    /**
     * @param p - {@link Point}
     * @return - the direction of the lightSource
     */
    public Vector getL(Point p);

    double getDistance(Point point);
}
