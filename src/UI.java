
import java.util.Scanner;

import javax.annotation.processing.SupportedOptions;
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
        System.out.println("\t1. Operaciones aritmeticas");
        System.out.println("\t2. Quote");
        System.out.println("\t3. SetQ\n");


        int op = sc.nextInt(); 
        sc.nextLine();
        switch(op){

            case 1:
            System.out.println("\n");
            System.out.println("\n Implementacion de Operaciones Aritmeticas\n");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Importante a tomar en cuenta para ingresar expresiones");
            System.out.println("\t1. Tomar espacios entre parentesis, operadores y operandos.");   
            System.out.println("\t\t Ej. ( - 6 5 )");
            System.out.println("\t2. Agregar operaciones con formato LISP, si no dara error el programa.");
            System.out.println("\t 3. Si son operaciones complejas, tomar en cuenta el siguiente formato: ");
            System.out.println("\t\t Ej 1. ( *( + 3 2 )(/ 8 2 ))");
            System.out.println("\t\t Ej 2. ( * 3( + 5 2))");
            System.out.println("4. Si se busca evaluar con variables, usar el simbolo: !");
            System.out.println("Por cualquier error, consultar la guía de usuario ");
            System.out.println("-------------------------------------------------------------------------------\n");

            System.out.println("¿Qué expresion le gustaría agregar?");
            String operation = sc.nextLine(); 
            System.out.println(arithOp.evaluate(operation));
            System.out.println("\n");

            break; 

            case 2: 
                System.out.println("\nImplementacion de funcion QUOTE\n");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Importante a tomar en cuenta para ingresar expresiones");
                System.out.println("\t1. Seguir el siguiente formato: (quote (cadena))");
                System.out.println("Por cualquier error, consultar la guía de usuario ");
                System.out.println("-------------------------------------------------------------------------------\n");

                System.out.println("¿Que expresion le gustaría agregar?");

                String quoteExpr = sc.nextLine(); 

                if(!quoteExpr.contains("quote")){
                    System.out.println("Parece que no se han cumplido las condiciones de quote... resisa tu expresion por favor ");
                }

                Variables variables = new Variables(quoteExpr); 
                System.out.println("\nResultado del quote: ");
                System.out.println("\t" + variables.evaluateQuoteExpr(quoteExpr));
                System.out.println("\n");

                


            break; 

            case 3: 

            break; 

                

        }
                
    }
}

