public class ParabolaEquation {
    // instance variables
    private int a;
    private int b;
    private int c;
    
    // constructor
    public ParabolaEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // public getter and setter methods
    // public void setA(int newA) {
    //     a = newA;
    // }
    // public int getA() {
    //     return a;
    // }
    // public void setB(int newB) {
    //     b = newB;
    // }
    // public int getB() {
    //     return b;
    // }
    // public void setC(int newC) {
    //     c = newC;
    // }
    // public int getC() {
    //     return c;
    // }
    
    // other public methods
    public int yIntercept() {
        return c;
    }
    public int coordinateForX(int x) {
        return a * (int) Math.pow(x, 2) + b * x + c;
    }
    public String graphInfo() {
        if (Util.isInt(xIntercept1()) && Util.isInt(xIntercept2())) {
            if (realRoots()) {
                return "\nx-intercepts: " + (int) xIntercept1() + ", " + (int) xIntercept2() + 
                "\ncoordinates of x-intercepts: \n(" + (int) xIntercept1() + ", 0) \n(" + (int) xIntercept2() + ", 0)" + 
                "\ny-intercepts: " + yIntercept() + 
                "\ncoordinates of y-intercepts: \n(0, " + yIntercept() + ")";
            } else {
                return "\nx-intercepts: " + (int) nonRealXIntercept1() + "i, " + (int) nonRealXIntercept2() + "i" +
                "\ncoordinates of x-intercepts: \n(" + (int) nonRealXIntercept1() + "i, 0) \n(" + (int) nonRealXIntercept2() + "i, 0)" + 
                "\ny-intercepts: " + yIntercept() + 
                "\ncoordinates of y-intercepts: \n(0, " + yIntercept() + ")";
            }
        }
        if (realRoots()) {
            return "\nx-intercepts: " + Util.roundedToHundredth(xIntercept1()) + ", " + Util.roundedToHundredth(xIntercept2()) + 
            "\ncoordinates of x-intercepts: \n(" + xIntercept1() + ", 0) \n(" + xIntercept2() + ", 0)" + 
            "\ny-intercepts: " + yIntercept() + 
            "\ncoordinates of y-intercepts: \n(0, " + yIntercept() + ")";
        } else {
            return "\nx-intercepts: " + Util.roundedToHundredth(nonRealXIntercept1()) + "i, " + Util.roundedToHundredth(nonRealXIntercept2()) + "i"+ 
            "\ncoordinates of x-intercepts: \n(" + nonRealXIntercept1() + ", 0) \n(" + nonRealXIntercept2() + ", 0)" + 
            "\ny-intercepts: " + yIntercept() + 
            "\ncoordinates of y-intercepts: \n(0, " + yIntercept() + ")";
        }
    }

    // private helper methods
    private boolean realRoots() {
        if (Math.pow(b, 2) - (4 * a * c) >= 0) {
            return true;
        } else {
            return false;
        }
    }
    private double xIntercept1() {
        return ((-1 * b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
    }
    private double xIntercept2() {
        return ((-1 * b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
    }
    private double nonRealXIntercept1() {
        return ((-1 * b) - Math.sqrt(Math.abs(Math.pow(b, 2) - (4 * a * c)))) / (2 * a);
    }
    private double nonRealXIntercept2() {
        return ((-1 * b) + Math.sqrt(Math.abs(Math.pow(b, 2) - (4 * a * c)))) / (2 * a);
    }
}
