import java.util.Scanner;

/**
 * Clase UI
 * Objetivo: Main e interfaz de usuario
 */

public class UI {

    static Scanner sc = new Scanner(System.in);
    static Operations arithOp = new Operations();
    static readFile read = new readFile();
    static Interpreter interpreter = new Interpreter();

    public static void main(String[] args) {
        System.out.println("\n¡Bienvenido al interprete de LISP!\n");
        System.out.println("En este momento se leera el archivo de código...\n");
        System.out.println("A continuacion, se muestran los resultados del codigo dentro del TXT utilizado:\n");
        interpreter.Interp(read._readfile("C:\\Users\\ncast\\OneDrive\\Documentos\\Universidad\\Semestres\\Tercer Semestre\\Algoritmos y Estructura de Datos\\Proyecto\\Interprete-LISP\\src\\Prueba.txt"));


        System.out.println("\nEl programa ha terminado de interpretar las funciones\n");
    }

}
