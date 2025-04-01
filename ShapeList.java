import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> shapes;

    // Constructor
    public ShapeList() {
        shapes = new ArrayList<>();
    }

    // Add a shape
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    // Remove a shape at a specific index
    public void removeShape(int index) {
        if (index >= 0 && index < shapes.size()) {
            shapes.remove(index);
            System.out.println("Shape at index " + index + " removed successfully.");
        } else {
            System.out.println("Error: No shape found at index " + index);
        }
    }

    // Display all shapes
    public void displayAllShapes() {
        if (shapes.isEmpty()) {
            System.out.println("No shapes in the list.");
            return;
        }

        for (int i = 0; i < shapes.size(); i++) {
            System.out.println("Shape #" + i + ":\n" + shapes.get(i).display() + "\n");
        }
    }

    // Translate all shapes
    public void translateAll(int dx, int dy) {
        for (Shape shape : shapes) {
            shape.translate(dx, dy);
        }
    }

    // Scale all shapes
    public void scaleAll(int factor, boolean sign) {
        for (Shape shape : shapes) {
            shape.scale(factor, sign);
        }
    }

    // Get shape at a given index
    public Shape getShape(int index) {
        if (index >= 0 && index < shapes.size()) {
            return shapes.get(index);
        } else {
            System.out.println("Error: Shape at index " + index + " does not exist.");
            return null;
        }
    }

    // Get area of a shape
    public void printArea(int index) {
        Shape s = getShape(index);
        if (s != null) {
            System.out.println("Area of shape #" + index + ": " + s.getArea());
        }
    }

    // Get perimeter of a shape
    public void printPerimeter(int index) {
        Shape s = getShape(index);
        if (s != null) {
            System.out.println("Perimeter of shape #" + index + ": " + s.getPerimeter());
        }
    }

    // Get number of shapes
    public int size() {
        return shapes.size();
    }
}
