package renderer;

import java.util.MissingResourceException;

import primitives.*;

public class Camera {
    private Point p0;
    private Vector Vto, Vup, Vright;
    double height, width, distance;
    private ImageWriter imageWriter;
    private RayTracerBase rayTracerBase;

    /**
     * @param p0 - location of camera
     */
    public Camera(Point p0, Vector vto, Vector vup) {
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

    public Camera setRayTracer(RayTracerBase rayTracerBase) {
        this.rayTracerBase = rayTracerBase;
        return this;
    }

    public Camera setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
        return this;
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

    public void renderImage() {
        if (this.imageWriter == null) {
            throw new MissingResourceException("the imageWriter is null", "ImageWriter", null);
        } else if (this.rayTracerBase == null) {
            throw new MissingResourceException("the rayTracerBase is null", "RayTracerBase", null);
        }
        for (int i = 0; i < imageWriter.getNy(); i++) {
            for (int j = 0; j < imageWriter.getNx(); j++) {
                imageWriter.writePixel(i, j,castRay((imageWriter.getNx()),(imageWriter.getNy()),i,j));
            }
        }
    }

    public Color castRay(int nX, int nY, int i, int j){
        return rayTracerBase.traceRay(constructRay(nX,nY,i,j));
    }

    /**
     * @param nX - number of column
     * @param nY - number of row
     * @param j  - index of column
     * @param i  - index of row
     * @return {@link Ray} to object on the view plane
     */
    public Ray constructRay(int nX, int nY, int j, int i) {
        Point Pc = p0.add(Vto.scale(distance));
        double Ry = height / nY;
        double Rx = width / nX;
        double Xj = ((double) j - ((nX - 1) / 2.0)) * Rx;
        double Yi = -((double) i - ((nY - 1) / 2.0)) * Ry;
        Point Pij = Pc;
        if (Xj != 0) {
            Pij = Pij.add(Vright.scale(Xj));
        }
        if (Yi != 0) {
            Pij = Pij.add(Vup.scale(Yi));
        }
        Vector Vij = Pij.subtract(p0);
        return new Ray(Vij, p0);
    }

    public void printGrid(int interval, Color color) {
        if (imageWriter != null) {
            for (int i = 0; i < imageWriter.getNy(); i++) {
                for (int j = 0; j < imageWriter.getNx(); j++) {
                    if (i % interval == 0) {
                        imageWriter.writePixel(i, j, color);
                    } if (j % interval == 0) {
                        imageWriter.writePixel(i, j, color);
                    }
                }
            }
        }
        else
        {
            throw new MissingResourceException("the imageWriter is null", "ImageWriter", null);
        }
    }

    public void writeToImage() {
        if (imageWriter != null) {
            imageWriter.writeToImage();
        }
        else
        {
            throw new MissingResourceException("the imageWriter is null", "ImageWriter", null);
        }
    }
}
