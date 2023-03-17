
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


    public static void menuPrincipalLISP() {
        System.out.println("\n¡Bienvenido al interprete de LISP!\n");
        System.out.println("Porfavor ingresa el Path del archivo txt en el cual se encuentra tu código\n");

        String path = sc.nextLine();
        read._readfile(path);
        
    //ArrayList<ArrayList<String>> lisp_code = readfile._readfile("C:\\Users\\ncast\\OneDrive\\Documentos\\Universidad\\Semestres\\Tercer Semestre\\Algoritmos y Estructura de Datos\\Proyecto\\Proyecto-LISP\\Lisp code.txt"); 
       // LISP.Interp(lisp_code);
    }
}




