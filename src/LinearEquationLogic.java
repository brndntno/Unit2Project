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
        linearEquation = new LinearEquation(coordinate1, coordinate2);
        linearEquation.getCoordinate1();
        linearEquation.getCoordinate2();
        linearEquation.slope();
        linearEquation.yIntercept();
        linearEquation.getDistance();
        linearEquation.getEquation();
        linearEquation.lineInfo();
        System.out.print("Enter a value for x: ");
        double xValue = Integer.parseInt(myScanner.nextLine());
        System.out.println("The point on the line is (" + xValue + ", " + linearEquation.getCoordinateForX() + ")");
    }

    private void getData() {
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String yOrN = myScanner.nextLine();
        while (yOrN.equals("y")) {
            getLineInfo();
        }
    }
}
