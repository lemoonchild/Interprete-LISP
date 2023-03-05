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

    public static void menuPrincipal(){
        System.out.println("\n¡Bienvenido al interprete de LISP!");
        System.out.println("¿Qué desea realizar?\n");
        System.out.println("\t1. Realizar operaciones aritméticas");
        
        int op = sc.nextInt(); 

        switch(op){

            case 1: 
            System.out.println("¿Qué operación desea realizar?");
            System.out.println("1. Operaciones Simples, ej. (+34)");
            int type = sc.nextInt(); 

            switch(type){

                case 1: 
                System.out.println("Por favor, ingrese su operacion aritmetica simple, ej. (-53)");
                String operation = sc.next();
                System.out.println("Resultaod de la operación" + operations.simpleOperations(operation));
                

            }
                
        }
    }
}
