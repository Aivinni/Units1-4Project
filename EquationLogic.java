import java.util.Scanner;

public class EquationLogic {
    // instance variables
    private Scanner scan;
    private String equationString;
    private int a;
    private int b;
    private int c;
    private ParabolaEquation equation;
    private LinearEquation secretEquation;
    private boolean isLinear;
    private boolean isQuadratic;
    private int i;


    //constructor
    public EquationLogic() {
        scan = new Scanner(System.in);
        isLinear = false;
        isQuadratic = false;
    }

    // public methods
    public void start() {
        System.out.println("------------------------ Hello there ----------------------");
        System.out.println("------------- This is the Parabola Calculator -------------");
        System.out.println("--- Equations must be entered in the form ax^2 + bx + c ---");
        System.out.println("--------If a coefficient is 1, the 1 may be ommitted-------");
        System.out.println("------If a coefficient is 0, the term may be ommitted------");
        System.out.println("This program will give you the x and y intercepts of the equation");
        getEquation();
        if (isQuadratic) {
            xForQuadratic();
        } else if (isLinear) {
            xForLinear();
        }
    }
    private void getEquation() {
        System.out.println("Enter thine equation:");
        System.out.print("y = ");
        // Equation in form ax^2 + bx + c
        equationString = scan.nextLine().toLowerCase();
        // Get A
        if (equationString.indexOf("x^2 ") == -1) {
            a = 0;
        } else if (equationString.substring(0, equationString.indexOf("x^2 ")).equals("")) {
            a = 1;
        } else {
            a = Integer.parseInt(equationString.substring(0, equationString.indexOf("x^2 "))); 
        }

        // Get B
        if (equationString.indexOf("x^2 + ") > -1) {
            if (equationString.indexOf("x + ") > -1) {
                if (equationString.substring(equationString.indexOf("x^2 + ") + 6, equationString.indexOf("x + ")).equals("")) {
                    b = 1;
                } else {
                    b = Integer.parseInt(equationString.substring(equationString.indexOf("x^2 + ") + 6, equationString.indexOf("x + ")));
                }
            } else if (equationString.indexOf("x - ") > -1) {
                if (equationString.substring(equationString.indexOf("x^2 + ") + 6, equationString.indexOf("x - ")).equals("")) {
                    b = -1;
                } else {
                    b = -1 * Integer.parseInt(equationString.substring(equationString.indexOf("x^2 + ") + 6, equationString.indexOf("x - ")));
                }
            } else {
                String newString = equationString.substring(equationString.indexOf("x") + 1);
                if (newString.contains("x")) {
                    b = Integer.parseInt(newString.substring(newString.indexOf("^2") + 5, newString.indexOf("x")));
                } else {
                   b = 0; 
                }
            }
        } else if (equationString.indexOf("x^2 - ") > -1) {
            if (equationString.indexOf("x + ") > -1) {
                if (equationString.substring(equationString.indexOf("x^2 - ") + 6, equationString.indexOf("x + ")).equals("")) {
                    b = 1;
                } else {
                    b = Integer.parseInt(equationString.substring(equationString.indexOf("x^2 - ") + 6, equationString.indexOf("x + ")));
                }
            } else if (equationString.indexOf("x - ") > -1) {
                if (equationString.substring(equationString.indexOf("x^2 - ") + 6, equationString.indexOf("x - ")).equals("")) {
                    b = -1;
                } else {
                    b = -1 * Integer.parseInt(equationString.substring(equationString.indexOf("x^2 - ") + 6, equationString.indexOf("x - ")));
                }
            } else {
                String newString = equationString.substring(equationString.indexOf("x") + 1);
                if (newString.contains("x")) {
                    b = -1 * Integer.parseInt(newString.substring(newString.indexOf("^2") + 5, newString.indexOf("x")));
                } else {
                   b = 0; 
                }
            }
        } else {
            if (equationString.indexOf("x + ") > -1) {
                if (equationString.substring(0, equationString.indexOf("x + ")).equals("")) {
                    b = 1;
                } else {
                    b = Integer.parseInt(equationString.substring(0, equationString.indexOf("x + ")));
                }
            } else if (equationString.indexOf("x - ") > -1) {
                if (equationString.substring(0, equationString.indexOf("x - ")).equals("")) {
                    b = 1;
                } else {
                    b = Integer.parseInt(equationString.substring(0, equationString.indexOf("x - ")));
                } 
            } else {
                b = 0;
            }
        }

        // Get C
        if (equationString.indexOf("x + ") > -1) {
            c = Integer.parseInt(equationString.substring(equationString.indexOf("x + ") + 4));
        } else if (equationString.indexOf("x - ") > -1) {
            c = -1 * Integer.parseInt(equationString.substring(equationString.indexOf("x - ") + 4));
        } else {
            if (equationString.indexOf("x^2 + ") > -1) {
                if (equationString.substring(equationString.length() - 1).equals("x")) {
                    c = 0;
                } else {
                    c = Integer.parseInt(equationString.substring(equationString.indexOf("x^2 + ") + 6));
                }
            } else if (equationString.indexOf("x^2 - ") > -1) {
                if (equationString.substring(equationString.length() - 1).equals("x")) {
                    c = 0;
                } else {
                    c = -1 * Integer.parseInt(equationString.substring(equationString.indexOf("x^2 - ") + 6));
                }
            } else {
                if (equationString.indexOf("-") > -1) {
                    if (equationString.substring(equationString.length() - 1).equals("x")) {
                        c = 0;
                    } else {
                        c = -1 * Integer.parseInt(equationString.substring(equationString.indexOf("-") + 1));
                    }
                } else {
                    if (equationString.substring(equationString.length() - 1).equals("x")) {
                        c = 0;
                    } else {
                        c = Integer.parseInt(equationString);
                    }
                }
            }
        }
        if (a != 0) {
            equation = new ParabolaEquation(a, b, c);
            isQuadratic = true;
        } else {
            secretEquation = new LinearEquation(equationString, b, c);
            isLinear = true;
        }
        if (isQuadratic) {
            System.out.println(equation.graphInfo());
        } else if (isLinear) {
            System.out.println(secretEquation.graphInfo());
        }
    }
    private void xForQuadratic() {
        System.out.println("How many x values do you want input?");
        int numValues = scan.nextInt();
        scan.nextLine();
        boolean end = false;
        while (!end) {
            System.out.println("Which x values do you want to input?");
            System.out.println("Enter in form a b c, with only a space between each number");
            String numbersString = scan.nextLine();
            for (i = 0; i < numValues; i++) {
                int x;
                if (numbersString.indexOf(" ") != -1) {
                    x = Integer.parseInt(numbersString.substring(0, numbersString.indexOf(" ")));
                } else {
                    x = Integer.parseInt(numbersString);
                }
                numbersString = numbersString.substring(numbersString.indexOf(" ") + 1);
                System.out.println(equation.coordinateForX(x));
            }
            System.out.println("Enter more values? (y/n)");
            if (scan.nextLine().equalsIgnoreCase("y")) {
                end = false;
                System.out.println("How many values do you want? ");
                numValues = scan.nextInt();
                scan.nextLine();
            } else {
                end = true;
                System.out.println("Goodbye!");
            }
        }
    }
    private void xForLinear() {
        System.out.println("How many x values do you want input?");
        int numValues = scan.nextInt();
        scan.nextLine();
        boolean end = false;
        while (!end) {
            System.out.println("Which x values do you want to input?");
            System.out.println("Enter in form a b c, with only a space between each number");
            String numbersString = scan.nextLine();
            for (i = 0; i < numValues; i++) {
                int x;
                if (numbersString.indexOf(" ") != -1) {
                    x = Integer.parseInt(numbersString.substring(0, numbersString.indexOf(" ")));
                } else {
                    x = Integer.parseInt(numbersString);
                }
                numbersString = numbersString.substring(numbersString.indexOf(" ") + 1);
                System.out.println(secretEquation.coordinateForX(x));
            }
            System.out.println("Enter more values? (y/n)");
            if (scan.nextLine().equalsIgnoreCase("y")) {
                end = false;
                System.out.println("How many values do you want? ");
                numValues = scan.nextInt();
                scan.nextLine();
            } else {
                end = true;
                System.out.println("Goodbye!");
            }
        }
    }
}
