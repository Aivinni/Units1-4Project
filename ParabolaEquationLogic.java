import java.util.Scanner;

public class ParabolaEquationLogic {
    // instance variables
    private Scanner scan;
    private String equationString;
    private int a;
    private int b;
    private int c;
    private ParabolaEquation equation;

    //constructor
    public ParabolaEquationLogic() {
        scan = new Scanner(System.in);
    }

    // public methods
    // Moethod Works
    public void start() {
        System.out.println("---------------------- Hello there --------------------");
        System.out.println("----------- This is the Parabola Calculator -----------");
        System.out.println("- Equations must be entered in the form ax^2 + bx + c -");
        System.out.println("This program will give you the x and y intercepts of the equation");
        getEquation();
        printInfo();
    }
    private void getEquation() {
        System.out.println("Enter thine equation:");
        // Equation in form ax^2 + bx + c
        equationString = scan.nextLine();
        a = Integer.parseInt(equationString.substring(0, equationString.indexOf("x^2 "))); 
        b = Integer.parseInt(equationString.substring(equationString.indexOf("x^2 + ") + 6, equationString.indexOf("x + ")));
        c = Integer.parseInt(equationString.substring(equationString.indexOf("x + ") + 4));
        equation = new ParabolaEquation(a, b, c);
    }
    private void printInfo() {
        System.out.println("x-intercepts: ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
