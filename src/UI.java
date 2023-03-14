import java.util.Scanner;

/**
 * UI
 */
public class UI {

    static Scanner sc = new Scanner(System.in);
    static Operations operations = new Operations();

    public static void main(String[] args) {

        menuPrincipal();
    }

    public static void menuPrincipal() {
        System.out.println("\n¡Bienvenido al interprete de LISP!");
        System.out.println("Porfavor ingresa el Path del archivo txt en el cual se encuentra tu código\n");

        String op = sc.nextLine();
        readFile._readfile(op);

    }
}
