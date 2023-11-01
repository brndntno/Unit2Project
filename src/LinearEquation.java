public class LinearEquation {


    // instance variables
    private String coordinate1;
    private String coordinate2;
    private int y2;
    private int y1;
    private int x2;
    private int x1;
    //private double slope;
    //private double yIntercept;
    //private double distance;
    //private String equation;
    private double coordinateForX;

    // constructor
    public LinearEquation(String coordinate1, String coordinate2) {
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
        y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",") + 2, coordinate2.indexOf(")")));
        y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 2, coordinate1.indexOf(")")));
        x2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf("(") + 1, coordinate2.indexOf(",")));
        x1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf("(") + 1, coordinate1.indexOf(",")));
    }

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        coordinate1 = "(" + x1 + ", " + y1 + ")";
        coordinate2 = "(" + x2 + ", " + y2 + ")";
    }


    public String getCoordinate1() {
        return coordinate1;
    }


    public String getCoordinate2() {
        return coordinate2;
    }


    public double slope() {
        double slope = (double) (y2 - y1) / (double) (x2 - x1);
        return roundedToHundredth(slope);
    }


    public double yIntercept() {
        double yIntercept = y1 - (slope() * x1);
        return roundedToHundredth(yIntercept);
    }


    public double distance() {
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return roundedToHundredth(distance);
    }

    public String equation() {
        if (y1 == y2) {
            String equation = "y = " + yIntercept();
            return equation;
        } if (yIntercept() == 0) {
            if ((y2 - y1) == (x2 - x1)) {
                String equation = "y = x";
                return equation;
            } if ((y2 - y1) == -1 * (x2 - x1)) {
                String equation = "y = -x";
                return equation;
            } if ((y2 - y1) % (x2 - x1) == 0) {
                String equation = "y = " + ((y2 - y1) / (x2 - x1)) + "x";
                return equation;
            } else if (((x2 - x1) < 0) && ((y2 - y1) < 0)) {
                String equation = "y = " + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x";
                return equation;
            } else if ((x2 - x1) < 0) {
                String equation = "y = -" + (y2 - y1) + "/" + Math.abs(x2 - x1) + "x";
                return equation;
            } else {
                String equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x";
                return equation;
            }
        } else if (yIntercept() < 0) {
            if ((y2 - y1) == (x2 - x1)) {
                String equation = "y = x - " + Math.abs(yIntercept());
                return equation;
            } if ((y2 - y1) == -1 * (x2 - x1)) {
                String equation = "y = -x - " + Math.abs(yIntercept());
                return equation;
            } if ((y2 - y1) % (x2 - x1) == 0) {
                String equation = "y = " + ((y2 - y1) / (x2 - x1)) + "x - " + Math.abs(yIntercept());
                return equation;
            } if (((x2 - x1) < 0) && ((y2 - y1) < 0)) {
                String equation = "y = " + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x - " + Math.abs(yIntercept());
                return equation;
            } else if ((x2 - x1) < 0) {
                String equation = "y = -" + (y2 - y1) + "/" + Math.abs(x2 - x1) + "x - " + Math.abs(yIntercept());
                return equation;
            } else {
                String equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x - " + Math.abs(yIntercept());
                return equation;
            }
        } if ((y2 - y1) == (x2 - x1)) {
            String equation = "y = x + " + yIntercept();
            return equation;
        } if ((y2 - y1) == -1 * (x2 - x1)) {
            String equation = "y = -x + " + yIntercept();
            return equation;
        } else if ((y2 - y1) % (x2 - x1) == 0) {
            String equation = "y = " + ((y2 - y1) / (x2 - x1)) + "x + " + yIntercept();
            return equation;
        } if (((x2 - x1) < 0) && ((y2 - y1) < 0)) {
            String equation = "y = " + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x + " + yIntercept();
            return equation;
        } else if ((x2 - x1) < 0) {
            String equation = "y = -" + (y2 - y1) + "/" + Math.abs(x2 - x1) + "x + " + yIntercept();
            return equation;
        } else {
            String equation = "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + yIntercept();
            return equation;
        }
    }

    public String lineInfo() {
        return "The two points are: " + coordinate1 + " and " + coordinate2 + "\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The y-intercept of the line is: " + yIntercept() + "\n" +
                "The distance between the points is: " + distance();
    }

    public String coordinateForX(double xValue) {
        coordinateForX = slope() * xValue + yIntercept();
        return "(" + xValue + ", " + coordinateForX + ")";
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}
