package test.rendererTests;

import org.junit.jupiter.api.Test;

import primitives.Color;
import renderer.ImageWriter;

public class ImageWriterTest {
    @Test
    void testImageWriter() {
        ImageWriter writer = new ImageWriter("photo", 800, 500);
        for (int i = 0; i < writer.getNx(); i++) {
            for (int j = 0; j < writer.getNy(); j++) {
                if (i % 50 == 0) {
                    writer.writePixel(i, j, new Color(255, 46, 0));
                } else if (j % 50 == 0) {
                    writer.writePixel(i, j, new Color(255, 46, 0));
                } else {
                    writer.writePixel(i, j, new Color(255, 255, 0));
                }
            }
        }
        writer.writeToImage();
    }
}
