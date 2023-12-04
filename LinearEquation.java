public class LinearEquation {
    private String equation;
    private int b;
    private int c;
    
    // PRECONDITION: X2 != X1
    public LinearEquation(String equation, int b, int c) {
        this.equation = equation;
        this.b = b;
        this.c = c;

    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
    // public String equation() {
    //     return equation;
    // }
    // public void setSlope(int b) {
    //     this.b = b;
    // }
    public int getSlope() {
        return b;
    }
    // public void setYIntercept(int c) {
    //     this.c = c;
    // }
    public int getYIntercept() {
        return c;
    }
    public double xIntercept() {
        return (double) (-c) / b;
    }
    public int coordinateForX(double x) {
        return (int) (getSlope() * x) + getYIntercept();
    }
    public String graphInfo() {
        if (Util.isInt(xIntercept())){
            return "\nequation of line: " + equation + 
        "\nslope of line: " + getSlope() + 
        "\ny-intercept of line: " + getYIntercept() + 
        "\nx-intercept: " + (int) xIntercept();
        }
        return "\nequation of line: " + equation + 
        "\nslope of line: " + getSlope() + 
        "\ny-intercept of line: " + getYIntercept() + 
        "\nx-intercept: " + xIntercept();
    }
}
