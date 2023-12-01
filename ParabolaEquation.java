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
    public void setA(int newA) {
        a = newA;
    }
    public int getA() {
        return a;
    }
    public void setB(int newB) {
        b = newB;
    }
    public int getB() {
        return b;
    }
    public void setC(int newC) {
        c = newC;
    }
    public int getC() {
        return c;
    }
    
    // other public methods
    public boolean realRoots() {
        if (Math.pow(b, 2) - (4 * a * c) >= 0) {
            return true;
        } else {
            return false;
        }
    }
    public int yIntercept() {
        return c;
    }
    public double xIntercept1() {
        return ((-1 * b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
    }
    public double xIntercept2() {
        return ((-1 * b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
    }
    public double NonRealXIntercept1() {
        return ((-1 * b) - Math.sqrt(Math.abs(Math.pow(b, 2) - (4 * a * c)))) / (2 * a);
    }
    public double nonRealXIntercept2() {
        return ((-1 * b) + Math.sqrt(Math.abs(Math.pow(b, 2) - (4 * a * c)))) / (2 * a);
    }
}
