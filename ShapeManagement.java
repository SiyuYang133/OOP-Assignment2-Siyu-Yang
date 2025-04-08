import java.util.Scanner;


public class ShapeManagement {
    private ShapeList shapeList;  // Collection to store all shapes
    private Scanner scanner;      // Scanner to read user input

    // Constructor that initializes the ShapeList and Scanner
    public ShapeManagement() {
        shapeList = new ShapeList();
        scanner = new Scanner(System.in);
    }


    public void start() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer
            switch (choice) {
                case 1:
                    addShape();
                    break;
                case 2:
                    removeShape();
                    break;
                case 3:
                    getShapeInfo();
                    break;
                case 4:
                    displayAreaPerimeter();
                    break;
                case 5:
                    displayAllShapes();
                    break;
                case 6:
                    translateShapes();
                    break;
                case 7:
                    scaleShapes();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (choice != 0);
    }


    private void showMenu() {
        System.out.println("\n----- Shape Management Menu -----");
        System.out.println("1: Add a shape");
        System.out.println("2: Remove a shape by position");
        System.out.println("3: Get information about a shape by position");
        System.out.println("4: Display the area and perimeter of a shape by position");
        System.out.println("5: Display information of all shapes");
        System.out.println("6: Translate all shapes");
        System.out.println("7: Scale all shapes");
        System.out.println("0: Quit the program");
        System.out.print("Enter your choice: ");
    }


    private void addShape() {
        System.out.println("\nSelect the type of shape to add:");
        System.out.println("1: Circle");
        System.out.println("2: Rectangle");
        System.out.println("3: Triangle");
        System.out.println("4: Square");
        System.out.print("Enter your choice: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        Shape newShape = null;
        switch (type) {
            case 1:
                newShape = createCircle();
                break;
            case 2:
                newShape = createRectangle();
                break;
            case 3:
                newShape = createTriangle();
                break;
            case 4:
                newShape = createSquare();
                break;
            default:
                System.out.println("Invalid shape type.");
                return;
        }
        shapeList.addShape(newShape);
        System.out.println("Shape added successfully!");
    }


    private void removeShape() {
        System.out.print("Enter the position of the shape to remove (starting from 0): ");
        int pos = scanner.nextInt();
        scanner.nextLine();
        shapeList.removeShape(pos);
    }


    private void getShapeInfo() {
        System.out.print("Enter the position of the shape to get information (starting from 0): ");
        int pos = scanner.nextInt();
        scanner.nextLine();
        Shape shape = shapeList.getShape(pos);
        if (shape != null) {
            System.out.println("Shape information:");
            System.out.println(shape.display());
        }
    }


    private void displayAreaPerimeter() {
        System.out.print("Enter the position of the shape to display its area and perimeter (starting from 0): ");
        int pos = scanner.nextInt();
        scanner.nextLine();
        shapeList.printArea(pos);
        shapeList.printPerimeter(pos);
    }


    private void displayAllShapes() {
        shapeList.displayAllShapes();
    }


    private void translateShapes() {
        System.out.print("Enter the translation distance for x (dx): ");
        int dx = scanner.nextInt();
        System.out.print("Enter the translation distance for y (dy): ");
        int dy = scanner.nextInt();
        scanner.nextLine();
        shapeList.translateAll(dx, dy);
        System.out.println("All shapes have been translated.");
    }


    private void scaleShapes() {
        System.out.print("Enter the scaling factor: ");
        int factor = scanner.nextInt();
        System.out.print("Enter 1 for scaling up, 0 for scaling down: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        boolean sign = (option == 1);
        shapeList.scaleAll(factor, sign);
        System.out.println("All shapes have been scaled.");
    }


    private Coordinates inputCoordinates(String pointName) {
        System.out.print("Enter the x coordinate for " + pointName + ": ");
        int x = scanner.nextInt();
        System.out.print("Enter the y coordinate for " + pointName + ": ");
        int y = scanner.nextInt();
        scanner.nextLine();
        return new Coordinates(x, y);
    }


    private Circle createCircle() {
        Coordinates center = inputCoordinates("center");
        System.out.print("Enter the radius: ");
        double radius = scanner.nextDouble();
        scanner.nextLine();
        return new Circle(center, radius);
    }


    private Rectangle createRectangle() {
        Coordinates topLeft = inputCoordinates("top-left corner");
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();
        System.out.print("Enter the length: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        return new Rectangle(topLeft, width, length);
    }


    private Triangle createTriangle() {
        System.out.println("Enter the coordinates for the first vertex:");
        Coordinates p1 = inputCoordinates("point 1");
        System.out.println("Enter the coordinates for the second vertex:");
        Coordinates p2 = inputCoordinates("point 2");
        System.out.println("Enter the coordinates for the third vertex:");
        Coordinates p3 = inputCoordinates("point 3");
        return new Triangle(p1, p2, p3);
    }


    private Square createSquare() {
        Coordinates topLeft = inputCoordinates("top-left corner");
        System.out.print("Enter the side length: ");
        int side = scanner.nextInt();
        scanner.nextLine();
        return new Square(topLeft, side);
    }

    public static void main(String[] args) {
        ShapeManagement management = new ShapeManagement();
        management.start();
    }
}
