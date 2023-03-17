
import java.util.Scanner;

/**
 * UI
 */
public class UI {

    static Scanner sc = new Scanner(System.in); 
    static Operations arithOp = new Operations();


    public static void main(String[] args) {

        menuPrincipalLISP();
    }

    public static void menuPrincipalLISP() {
        System.out.println("\n¡Bienvenido al interprete de LISP!\n");
        System.out.println("Porfavor ingresa el Path del archivo txt en el cual se encuentra tu código\n");

        String path = sc.nextLine();
        readFile._readfile(path);

        
    }
}

