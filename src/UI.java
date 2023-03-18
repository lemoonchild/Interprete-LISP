
import java.util.ArrayList;
import java.util.Scanner;

/**
 * UI
 */
public class UI {

    static Scanner sc = new Scanner(System.in);
    static Operations arithOp = new Operations();
    static readFile read = new readFile();
    static Interpreter interpreter = new Interpreter();

    public static void main(String[] args) {
        System.out.println("\n¡Bienvenido al interprete de LISP!\n");
        System.out.println("En este momento se leera el archivo de código");
        interpreter.Interp(read._readfile("src\\Prueba.txt"));
    }


}
