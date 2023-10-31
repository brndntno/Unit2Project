public class LinearEquation {


    // instance variables
    private String coordinate1;
    private String coordinate2;
    private int y2;
    private int y1;
    private int x2;
    private int x1;
    private double slope;
    private double yIntercept;
    private double distance;
    private String equation;
    public double xValue;
    private double coordinateForX;

    // constructor
    public LinearEquation(String coordinate1, String coordinate2) {
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }


    public String getCoordinate1() {
        return coordinate1;
    }


    public String getCoordinate2() {
        return coordinate2;
    }


    public double slope() {
        y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",") + 2, coordinate2.indexOf(")")));
        y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 2, coordinate1.indexOf(")")));
        x2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf("(") + 1, coordinate2.indexOf(",")));
        x1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf("(") + 1, coordinate1.indexOf(",")));
        slope = (double) (y2 - y1) / (double) (x2 - x1);
        return slope;
    }


    public double yIntercept() {
        yIntercept = y1 - (slope * x1);
        return yIntercept;
    }


    public double getDistance() {
        distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return distance;
    }

    public String getEquation() {
        equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + yIntercept;
        return equation;
    }

    public void lineInfo() {
        System.out.println("The two points are: " + coordinate1 + " and " + coordinate2 + "\n" +
        "The equation of the line between these points is: " + equation + "\n" +
        "The slope of this line is: " + slope + "\n" +
        "The y-intercept of the line is: " + yIntercept + "\n" +
        "The distance between the points is: " + distance);
        System.out.println();
    }

    public double getCoordinateForX() {
        coordinateForX = slope * xValue + yIntercept;
        return coordinateForX;
    }
}

