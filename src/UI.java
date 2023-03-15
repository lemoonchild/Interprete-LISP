
import java.util.Scanner;

/**
 * UI
 */
public class UI {

    static Scanner sc = new Scanner(System.in); 
    static Operations arithOp = new Operations();

    public static void main(String[] args) {

        menuPrincipal();
    }

    public static void menuPrincipal() {
        System.out.println("\n¡Bienvenido al interprete de LISP!");
        //System.out.println("Porfavor ingresa el Path del archivo txt en el cual se encuentra tu código\n");

        //String path = sc.nextLine();
        //readFile._readfile(path);

        System.out.println("¿Que le gustaría realizar hoy?");
        System.out.println("1. Operaciones aritmeticas");

        int op = sc.nextInt(); 

        switch(op){

            case 1: 
            System.out.println("Por favor, ingrese su operacion aritmetica simple, ej. (- 5 3)");
            String operation = sc.next();
            System.out.println(arithOp.evaluate(operation));
                

        }
                
    }
}

