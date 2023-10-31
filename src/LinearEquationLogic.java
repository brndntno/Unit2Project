import java.util.Scanner;
public class LinearEquationLogic {
    private LinearEquation linearEquation;
    private Scanner myScanner;
    public LinearEquationLogic() {
        linearEquation = null;
        myScanner = new Scanner(System.in);
    }

    public void start() {
        getLineInfo();
        getData();
    }

    private void getLineInfo() {
        System.out.print("Enter coordinate 1: ");
        String coordinate1 = myScanner.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coordinate2 = myScanner.nextLine();
        System.out.println();
        linearEquation = new LinearEquation(coordinate1, coordinate2);
        linearEquation.getCoordinate1();
        linearEquation.getCoordinate2();
        linearEquation.slope();
        linearEquation.yIntercept();
        linearEquation.distance();
        linearEquation.equation();
        if (linearEquation.getCoordinate1().substring(1, linearEquation.getCoordinate1().indexOf(",")).equals(linearEquation.getCoordinate2().substring(1, linearEquation.getCoordinate2().indexOf(",")))) {
            System.out.println("These points are on a vertical line: x = " + linearEquation.getCoordinate1().substring(1, linearEquation.getCoordinate1().indexOf(",")));
            System.out.println();
        } else if (linearEquation.getCoordinate1().substring(linearEquation.getCoordinate1().indexOf(",") + 2, linearEquation.getCoordinate1().indexOf(")")).equals(linearEquation.getCoordinate2().substring(linearEquation.getCoordinate2().indexOf(",") + 2, linearEquation.getCoordinate2().indexOf(")")))) {
            System.out.println("These points are on a horizontal line: y = " + linearEquation.yIntercept());
            System.out.println();
        } else {
            System.out.println(linearEquation.lineInfo());
            System.out.print("Enter a value for x: ");
            double xValue = Double.parseDouble(myScanner.nextLine());
            System.out.println();
            System.out.println("The point on the line is (" + xValue + ", " + linearEquation.coordinateForX(xValue) + ")");
            System.out.println();
        }
    }

    private void getData() {
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String yOrN = myScanner.nextLine();
        if (yOrN.equals("y")) {
            start();
        } else {
            System.out.println("Thank you for using the slope calculator, goodbye!");
        }
    }
}
