# Image Rendering Project

This is an image rendering project in Java that allows you to create and render images using different geometric shapes and Light structures. The project is built in an architectural way with a variety of design patterns to make it modular and extensible.

## Features

The following are some of the features of this image rendering project:

- Creation of different geometric shapes, including squares, rectangles, circles, and triangles.
- Configuration of the color and size of the geometric shapes.
- Rendering of the shapes onto an image canvas.
- Addition of Light structures to the canvas, including ambient, directional, and point lights.
- Configuration of the intensity, direction, and color of the lights.
- Rendering of shadows and reflections on the canvas.
- support geometric shapes, such as polygons or 3D shapes.


## Architecture

This project is built using a variety of design patterns to achieve flexibility and extensibility. The following are some of the design patterns used:

- Composite Pattern: The `Intersectable` interface and its implementations provide a structure for composing complex shapes from simpler ones.
- Strategy Pattern: The `Light` interface and its implementations provide different strategies for lighting the scene.
- Iterator Pattern: The `Intersectable` class uses the iterator pattern to iterate over the `geometris` in the image.
- Builder Pattern: The `Scene` and `Material` class uses the builder pattern to create an `scene` or `Material` object with configurable properties such as size and background color.
- Wrapper Pattern: The `Color` interface and its implementations provide a structure for adding different color properties to the shapes.
- Template Method Pattern: The `GeoIntersections` class use the template method pattern to define a common structure for creating points on the shapes, while allowing for customization of specific methods by the implementations.
- Delegation Pattern: `point` and `vector` classs use the delegation pattern avoid the smell of unnecessary repetitions

By applying these additional design patterns, the image rendering project can become even more modular, maintainable, and extensible.

## Building and Running

To build and run the image rendering project, follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project directory in the terminal.
3. Run `javac *.java` to build the application.
4. Run the test cases.
5. Check the `images` folder for the rendered images.

## Extending the Project

This image rendering project can be extended to add more functionality such as:

- Adding support for different materials, such as reflective or transparent materials.
- Adding support for more complex scenes, such as animations or simulations.

## Dependencies

This image rendering project has the following dependencies:

- JUnit 5: for unit testing

## Conclusion

This image rendering project is a well-architected and modular project that uses a variety of design patterns to achieve flexibility and extensibility. It allows you to create and render images using different geometric shapes and Light structures. The project can be extended to add more functionality. The resulting images can be found in the `images` folder.
