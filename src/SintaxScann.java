
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SintaxScann
 */
public class SintaxScann {
    Scanner sc = new Scanner(System.in);

    /**
     * Según lo escrito por el usuario permiete reconocer lo siguiente a realizarse
     * 
     * @return Entero que representa la acción que se realizará
     * @param solicita la entrada de la primera línea de código de una funcion
     *                 por el usuario
     */
    public int Decide_action(String action) {

        String[] Parts = action.split(" ");

        if (Parts[0].contains("(defun")) {
            return 1; // Definir función
        } else if (Parts[0].contains("cond")) {
            return 2; // Condiciones
        } else if (Parts[0].contains("setq")) {
            return 3; // asignar valor a una variable
        } else if (Parts[0].contains("quote")) {
            return 4; // Tomar datos literales
        } else if (Parts[0].contains("atom")) {
            return 5; // ¿será una lista? - PREDICADO
        } else if (Parts[0].contains("equal") || Parts[0].contains("=")) {
            return 6; // ¿elementos iguales? - PREDICADO
        } else if (Parts[0].contains("<")) {
            return 7; // Menor que - PREDICADO
        } else if (Parts[0].contains(">")) {
            return 8; // Mayor que - PREDICADO
        } else if (Parts[0].contains("list")) {
            return 9; // Crear una list
        } else if (matchArithmeticOp(action)){
            return 10; 
        }else {
            return 0; 
        }

    }
    public boolean matchArithmeticOp(String expressions){

        Pattern pattern = Pattern.compile("[/*+-]");
        Matcher matcher = pattern.matcher(expressions);

        return matcher.find();
    }
    public boolean evalateOperation(String regex, String expression) {

        String newExpression = expression.replace("(", "");
        newExpression = expression.replace(")", "");

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(newExpression);

        return matcher.find();
    }
} 
         
        

     

    