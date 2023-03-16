
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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
        System.out.println("\n¡Bienvenido al interprete de LISP!\n");
        //System.out.println("Porfavor ingresa el Path del archivo txt en el cual se encuentra tu código\n");

        //String path = sc.nextLine();
        //readFile._readfile(path);

        System.out.println("¿Que le gustaría realizar hoy?");
        System.out.println("\t1. Operaciones aritmeticas\n");


        int op = sc.nextInt(); 
        sc.nextLine();
        switch(op){

            case 1:
            System.out.println("\n");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Importante a tomar en cuenta para ingresar operaciones");
            System.out.println("\t1. Tomar espacios entre parentesis, operadores y operandos.");   
            System.out.println("\t\t Ej. ( - 6 5 )");
            System.out.println("\t2. Agregar operaciones con formato LISP, si no dara error el programa.");
            System.out.println("\t 3. Si son operaciones complejas, tomar en cuenta el siguiente formato: ");
            System.out.println("\t\t Ej 1. ( *( + 3 2 )(/ 8 2 ))");
            System.out.println("\t\t Ej 2. ( * 3( + 5 2))");
            System.out.println("4. Si se busca evaluar con variables, usar el simbolo: !");
            System.out.println("Por cualquier error, consultar la guía de usuario ");
            System.out.println("-------------------------------------------------------------------------------\n");
            
            System.out.println("¿Qué operacion le gustaría evaluar?");
            String operation = sc.nextLine(); 
            System.out.println(arithOp.evaluate(operation));
            System.out.println("\n");
                

        }
                
    }
}

