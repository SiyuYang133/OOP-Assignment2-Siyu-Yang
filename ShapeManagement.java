public class ShapeManagement {
    public static void main(String[] args) {
        System.out.println("***** Shape Management Application ******");

        ShapeList shapeList = new ShapeList();

        // Create a Triangle with vertices (50,50), (20,70), (70,70)
        Triangle t1 = new Triangle(
                new Coordinates(50, 50),
                new Coordinates(20, 70),
                new Coordinates(70, 70)
        );
        shapeList.addShape(t1);

        // Create a Rectangle at (100, 20), width 10, length 15
        Rectangle r1 = new Rectangle(new Coordinates(100, 20), 10, 15);
        shapeList.addShape(r1);

        // Create a Circle at (80, 100), radius 25
        Circle c1 = new Circle(new Coordinates(80, 100), 25);
        shapeList.addShape(c1);

        // Create a Square at (90, 40), side 20
        Square s1 = new Square(new Coordinates(90, 40), 20);
        shapeList.addShape(s1);

        // Add three additional shapes
        shapeList.addShape(new Circle(new Coordinates(5, 5), 5));
        shapeList.addShape(new Rectangle(new Coordinates(10, 10), 4, 6));
        shapeList.addShape(new Square(new Coordinates(20, 20), 10));

        System.out.println("\n-- Show area and perimeter of the second shape (index 1) --");
        shapeList.printArea(1);
        shapeList.printPerimeter(1);

        System.out.println("\n-- Display information of all shapes --");
        shapeList.displayAllShapes();

        System.out.println("\n-- Remove the third shape (index 2) --");
        shapeList.removeShape(2);

        System.out.println("\n-- Translate all shapes by dx=10, dy=15 --");
        shapeList.translateAll(10, 15);
        shapeList.displayAllShapes();

        System.out.println("\n-- Scale all shapes by factor of 2 --");
        shapeList.scaleAll(2, true); // true = scale up
        shapeList.displayAllShapes();

        System.out.println("\n-- Error handling: remove shape at index 20 --");
        shapeList.removeShape(20);

        System.out.println("\n-- Error handling: print area of shape at index 100 --");
        shapeList.printArea(100);

        System.out.println("\n***** End of Test Cases *****");
    }
}
