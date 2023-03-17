
import java.util.ArrayList;
import java.util.Scanner;

/**
 * UI
 */
public class UI {

    static Scanner sc = new Scanner(System.in); 
    static Operations arithOp = new Operations();
    static readFile readfile = new readFile();
    static Interpreter LISP = new Interpreter();

    public static void main(String[] args) {
        
        ArrayList<ArrayList<String>> lisp_code = readfile._readfile("C:\\Users\\ncast\\OneDrive\\Documentos\\Universidad\\Semestres\\Tercer Semestre\\Algoritmos y Estructura de Datos\\Proyecto\\Proyecto-LISP\\Lisp code.txt"); 

        LISP.Interp(lisp_code);
    }
}




