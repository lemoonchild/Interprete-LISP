import java.util.*;
import java.util.Scanner;

/**
 * UI
 */
public class UI {

    static Scanner sc = new Scanner(System.in); 
    static Operations arithOp = new Operations();
    static readFile read = new readFile();
    static Interpreter interpreter = new Interpreter<>();


    public static void main(String[] args) {
        ArrayList<ArrayList<String>> Array_sucio = read._readfile("C:\\Users\\villa\\Desktop\\Clases_S3\\Proyecto-LISP\\src\\Prueba.txt"); 
        interpreter.Interp(Array_sucio);
        System.out.println("Fin del Programa");
    }

    public static void menuPrincipalLISP() {
        System.out.println("\n¡Bienvenido al interprete de LISP!\n");
        System.out.println("Porfavor ingresa el Path del archivo txt en el cual se encuentra tu código\n");

        String path = sc.nextLine();
        read._readfile(path);
        
    }
    public static void Leer_un_codigo(){
        ArrayList<ArrayList<String>> Array_sucio = read._readfile("C:\\Users\\villa\\Desktop\\Clases_S3\\Proyecto-LISP\\src\\Prueba.txt"); 
        //funcion limpair(); 
        for (ArrayList<String> arrayList : Array_sucio) {
            ArrayList<String> cada_uno = new ArrayList<>();
            cada_uno = read.split(arrayList, " ");
            for (String aa : cada_uno) {
                System.out.println(aa);
            }
        }
    }

    
}

