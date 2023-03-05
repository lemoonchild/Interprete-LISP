/**
 * Operations
 */
public class Operations {

    SintaxScann validOp = new SintaxScann();
    static ArithmeticEvaluation ArithmeticOp = new ArithmeticEvaluation(); 

    public int simpleOperations(String expression){
        
        boolean isValid = validOp.evalateOperation("^[ ]*[+*-/][ ]+[0-9]+[ ]+[0-9]+[ ]*[ ]*$", expression); 
        
        if(isValid){

            String[] operation = expression.split("");

            String operator = operation[0]; 
            String a = operation[1];
            String b = operation[2]; 

            if (operation.length != 3){

                System.out.println("La entrada ha sido invalida para ser resuelta");
            }

            if(!operator.matches("[+/-*]]")){
                System.out.println("¡El operador colocado " + operator + " ha sido invalido!");
            }
            
            return calculateOp(operator, a, b); 
        }

    }
    private static int calculateOp(String op, String a, String b){
        
        int result = 0; 

        switch(op){

            case "+": 
                result = ArithmeticOp.suma(a, b);
                break; 

            case "-": 
                result = ArithmeticOp.resta(a, b);
                break; 
                
            case "*": 
                result = ArithmeticOp.mult(a, b);
                break; 
                
            case "/": 
                result = ArithmeticOp.div(a, b);
                break; 

            default:
                System.out.println("Operador invalido: " + op);
                
        }

        return result; 

    }

}   