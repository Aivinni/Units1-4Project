public class LinearEquation {
    private final int X1;
    private final int Y1;
    private final int X2;
    private final int Y2;
    private String sign = "+ ";
    private double yInterceptDouble;
    private double yInterceptDoublePrint;
    private int yIntercept;
    private int yInterceptPrint;
    private int slope;

    // PRECONDITION: X2 != X1
    public LinearEquation(int X1, int Y1, int X2, int Y2) {
        this.X1 = X1;
        this.Y1 = Y1;
        this.X2 = X2;
        this.Y2 = Y2;
        yInterceptDouble = yIntercept();
        slope = (int) slope();
        yIntercept = (int) yInterceptDouble;
        yInterceptDoublePrint = yInterceptDouble;
        yInterceptPrint = yIntercept;
    }

    private boolean isInt(double num) {
        return num - (int)num == 0;
    }
    private double roundedToHundredth(double toRound) {
        toRound *= 100;
        toRound = (int)toRound;
        toRound /= 100.0;
        return toRound;
    }
    public double distance() {
        double distX = Math.abs(X2 - X1);
        double distY = Math.abs(Y2 - Y1);
        return roundedToHundredth(Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2)));
    }
    public double slope() {
        double run = X2 - X1;
        double rise = Y2 - Y1;
        if (!(run == 0)) {
            return roundedToHundredth(rise / run);
        } else {
            return 0;
        }
    }
    public String slopeFraction() {
        int i;
        int higher;
        int run = X2 - X1;
        int rise = Y2 - Y1;
        higher = Math.max(run, rise);
        for (i = 1; i < higher; i++) {
            if (run % i == 0 && rise % i == 0) {
                run = run / i;
                rise = rise / i;
            }
        }
        return rise + "/" + run;
    }
    public boolean errorCheck() {
        double run = X2 - X1;
        double rise = Y2 - Y1;
        return run == 0 && rise != 0;
    }
    public double yIntercept() {
        return Y1 - (X1 * slope());
    }
    public String equation() {
        if (errorCheck()) {
            return "x = " + X1;
        }
        if (yInterceptDouble < 0) {
            sign = "- ";
            yIntercept *= -1;
            yInterceptDouble *= -1;
        }
        if (slope() == 0 && yIntercept() == 0) {
            return "y = 0";
        } else if (slope() == 1 && yIntercept() == 0) {
            return "y = x";
        }
        if (isInt(slope())){
            if (isInt(yIntercept())) {
                if (slope() == 0) {
                    return "y = " + yIntercept;
                } else if (slope() == 1) {
                    return "y = x " + sign + yIntercept;
                } else if (yIntercept() == 0) {
                    return "y = " + slope + "x";
                }
                return "y = " + slope + "x " + sign + yIntercept;
            } else {
                if (slope() == 0) {
                    return "y = " + yInterceptDouble;
                } else if (slope() == 1) {
                    return "y = x " + sign + yInterceptDouble;
                } else if (yIntercept() == 0) {
                    return "y = " + slope + "x";
                }
                return "y = " + slope + "x " + sign + yInterceptDouble;
            }
        } else {
            if (isInt(yIntercept())) {
                if (slope() == 0) {
                    return "y = " + yIntercept;
                } else if (slope() == 1) {
                    return "y = x " + sign + yIntercept;
                } else if (yIntercept() == 0) {
                    return "y = " + slopeFraction() + "x";
                }
                return "y = " + slopeFraction() + "x " + sign + yIntercept;
            } else {
                if (slope() == 0) {
                    return "y = " + yInterceptDouble;
                } else if (slope() == 1) {
                    return "y = x " + sign + yInterceptDouble;
                } else if (yIntercept() == 0) {
                    return "y = " + slopeFraction() + "x";
                }
                return "y = " + slopeFraction() + "x " + sign + yInterceptDouble;
            }
        }

    }
    public String coordinateForX(double x) {
        if (isInt(x)) {
            if (isInt((slope() * x) + yIntercept())) {
                return "(" + (int)x + ", " + (int)((slope() * x) + yIntercept()) + ")";
            } else {
                return "(" + (int)x + ", " + ((slope() * x) + yIntercept()) + ")";
            }
        } else {
            if (isInt((slope() * x) + yIntercept())) {
                return "(" + x + ", " + (int)((slope() * x) + yIntercept()) + ")";
            } else {
                return "(" + x + ", " + ((slope() * x) + yIntercept()) + ")";
            }
        }
    }
    public String lineInfo() {
        if (isInt(slope())) {
            if (isInt(yIntercept())) {
                return "The two points are: " + "(" + X1 + ", " + Y1 + ")" + " and " + "(" + X2 + ", " + Y2 + ")" + " \n" +
                        "The equation of the line between these points is: " + equation() + " \n" +
                        "The slope of this line is: " + slope + " \n" +
                        "The y-intercept of this line is: " + yInterceptPrint + " \n" +
                        "The distance between these points is " + distance();
            } else {
                return "The two points are: " + "(" + X1 + ", " + Y1 + ")" + " and " + "(" + X2 + ", " + Y2 + ")" + " \n" +
                        "The equation of the line between these points is: " + equation() + " \n" +
                        "The slope of this line is: " + slope + " \n" +
                        "The y-intercept of this line is: " + yInterceptDoublePrint + " \n" +
                        "The distance between these points is " + distance();
            }
        } else {
            if (isInt(yIntercept())) {
                return "The two points are: " + "(" + X1 + ", " + Y1 + ")" + " and " + "(" + X2 + ", " + Y2 + ")" + " \n" +
                        "The equation of the line between these points is: " + equation() + " \n" +
                        "The slope of this line is: " + slopeFraction() + " \n" +
                        "The y-intercept of this line is: " + yInterceptPrint + " \n" +
                        "The distance between these points is " + distance();
            } else {
                return "The two points are: " + "(" + X1 + ", " + Y1 + ")" + " and " + "(" + X2 + ", " + Y2 + ")" + " \n" +
                        "The equation of the line between these points is: " + equation() + " \n" +
                        "The slope of this line is: " + slopeFraction() + " \n" +
                        "The y-intercept of this line is: " + yInterceptDoublePrint + " \n" +
                        "The distance between these points is " + distance();
            }
        }
    }
}
