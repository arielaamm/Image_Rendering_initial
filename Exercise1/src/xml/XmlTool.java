package xml;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import lighting.AmbientLight;
import geometries.*;
import primitives.*;
import scene.Scene;
public abstract class XmlTool {

    public static Point StringToDouble(String str) {
		str += " ";
		double[] list = Arrays.stream(str.split(" ")).mapToDouble(Double::parseDouble).toArray();
		if (list.length == 1) {
			return new Point(list[0], 0, 0);
		}
		if (list.length == 2) {
			return new Point(list[0], list[1], 0);
		}
		if (list.length == 3) {
			return new Point(list[0], list[1], list[2]);
		}
		return null;
	}

    public static Scene xmlHendler(Scene scene, File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Parse the XML file and create a Document object
		Document doc = builder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		// Get all elements in the XML file
		NodeList elements = doc.getElementsByTagName("*");
		for (int i = 0; i < elements.getLength(); i++) {
			Element element = (Element) elements.item(i);
			System.out.println("Element name: " + element.getNodeName());
			NamedNodeMap attributes = element.getAttributes();
			for (int j = 0; j < attributes.getLength(); j++) {
				Point point1 = StringToDouble(attributes.item(j).getNodeValue());

				switch (element.getNodeName()) {
					case "scene":
						scene.setBackground(new Color(point1.getX(), point1.getY(), point1.getZ()));
						break;
					case "ambient-light":
						scene.setAmbientLight(new AmbientLight(
								new Color(point1.getX(), point1.getY(), point1.getZ()),
								new Double3(0)));
						break;
					case "sphere":
						Point point2 = StringToDouble(attributes.item(j + 1).getNodeValue());
						j++;
						scene.geometries.add(
								new Sphere(point1, point2.getX()));
						break;
					case "triangle":
						point2 = StringToDouble(attributes.item(j + 1).getNodeValue());
						Point point3 = StringToDouble(attributes.item(j + 2).getNodeValue());
						j += 2;
						scene.geometries.add(new Triangle(point1, point2, point3));
						break;
					case "polygon":
						int e = 0;
						List<Point> points = new ArrayList<Point>();
						while (attributes.item(j).getNodeName().startsWith("p")) {
							points.add(StringToDouble(attributes.item(j + e).getNodeValue()));
							e++;
						}
						j += e;
						scene.geometries.add(new Polygon(((Point[]) points.toArray())));
						break;
					case "cylinder":
						throw new MissingResourceException("the cylinder is lack of info", "basicRenderXml", null);
					case "plane":
						point2 = StringToDouble(attributes.item(j + 1).getNodeValue());
						point3 = StringToDouble(attributes.item(j + 2).getNodeValue());
						j += 2;
						scene.geometries.add(new Triangle(point1, point2, point3));
						break;
					case "tube":
						throw new MissingResourceException("the tube is lack of info", "basicRenderXml", null);
					default:
						break;
				}
			}
		}
		return scene;
	}
}
