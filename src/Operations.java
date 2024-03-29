import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Clase Operations
 * Objetivo: Realizacion de operaciones aritmeticas con numeros o numeros y
 * varaibles
 */

public class Operations<T extends Number> {

    private Stack<Object> stack;

    public Operations() {
        this.stack = new Stack<>();
    }

    /**
     * Metodo que realiza la logica en la que ingresan las operaciones unicamente
     * con numeros
     * 
     * @param expression Expresion ingresada por usuario
     * @return Resultado de la operacion
     * @throws IllegalArgumentException Error cuando encuentre un token invalido
     */
    public T evaluateOnlyNumbers(String expression) throws IllegalArgumentException {

        String[] tokens = expression.split("\\s+|(?=\\()|(?<=\\))"); // La expresión regular utiliza tres patrones para
                                                                     // dividir la cadena de entrada en tokens separados
                                                                     // por uno o más espacios en blanco, paréntesis
                                                                     // izquierdos o paréntesis derechos
        List<Object> pendingTokens = new ArrayList<>();

        for (String token : tokens) {

            if (isNumber(token)) {

                stack.push(Double.parseDouble(token));
                pendingTokens.add(Double.parseDouble(token));

            } else if (isFunction(token)) {

                pendingTokens.add(token);

            } else if (isOpeningParenthesis(token)) {

                stack.push(token);

            } else if (isClosingParenthesis(token)) {

                evaluatePendingTokens(pendingTokens);
                evaluateSubexpression();

            } else {

                throw new IllegalArgumentException("Token invalido: " + token);
            }
        }
        return (T) stack.pop(); // resultado de la operacion al terminar la expresion
    }

    /**
     * Metodo que realiza la logica en la que ingresan las operaciones con variables
     * 
     * @param expression Expresion ingresada por usuario
     * @return Resultado de la operacion
     * @throws IllegalArgumentException Error cuando encuentre un token invalido
     */
    public T evaluateWithVar(String expression, HashMap<String, Double> variables) throws IllegalArgumentException {

        String[] tokens = expression.trim().split("\\s+|(?=\\()|(?<=\\))"); // La expresión regular utiliza tres patrones para
                                                                     // dividir la cadena de entrada en tokens separados
                                                                     // por uno o más espacios en blanco, paréntesis
                                                                     // izquierdos o paréntesis derechos
        List<Object> pendingTokens = new ArrayList<>();

        for (String token : tokens) {

            if (isNumber(token)) {

                stack.push(Double.parseDouble(token));
                pendingTokens.add(Double.parseDouble(token));

            } else if (isVariable(token)) {

                stack.push(variables.get(token));
                pendingTokens.add(variables.get(token));

            } else if (isFunction(token)) {

                pendingTokens.add(token);

            } else if (isOpeningParenthesis(token)) {

                stack.push(token);

            } else if (isClosingParenthesis(token)) {

                evaluatePendingTokens(pendingTokens);
                evaluateSubexpression();

            } else {

                throw new IllegalArgumentException("Token invalido: " + token);
            }
        }
        return (T) stack.pop(); // resultado de la operacion al terminar la expresion
    }

    /**
     * Evalua si es numero la expresion ingresada
     * 
     * @param token Token
     * @return true si es numero, false si no es
     */
    private boolean isNumber(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Evalua si es variabke la expresion ingresada
     * 
     * @param token Token
     * @return true si es variable, false si no es
     */
    private boolean isVariable(String token) {
        return token.matches("[a-zA-Z]+");
    }

    /**
     * Evalua si es operador la expresion ingresada
     * 
     * @param token Token
     * @return true si es operador, false si no es
     */
    private boolean isFunction(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    /**
     * Evalua si es parentesis abierto la expresion ingresada
     * 
     * @param token Token
     * @return true si es parentesis abierto, false si no es
     */
    private boolean isOpeningParenthesis(String token) {
        return token.equals("(");
    }

    /**
     * Evalua si es parentesis cerrado la expresion ingresada
     * 
     * @param token Token
     * @return true si es parentesis cerrado, false si no es
     */
    private boolean isClosingParenthesis(String token) {
        return token.equals(")");
    }

    /**
     * Evalua los tokens dentro de la lista de tokens pendientes para realizar las
     * operaciones segun su operador
     * IMPORTANTE: Deberán de haber 3, 1 operando y 2 operadores para que funcione
     * 
     * @param token Lista de tokens pendientes guardados
     * @return Resultado que forma los tokens dentro de la lista
     */
    private void evaluatePendingTokens(List<Object> tokens) {
 
            double b = (double) tokens.remove(tokens.size() - 1);
            Object cc = (Object) tokens.remove(tokens.size() - 1);
            double a = Double.valueOf(cc.toString());
            String operator = (String) tokens.remove(tokens.size() - 1);
            double result = evaluateOperator(a, b, operator);
            stack.push(result);
            tokens.add(result);
        
    }

    /**
     * Evalua el operador
     * 
     * @param a        token Double de lista de tokens pendientes
     * @param b        token Double de lista de tokens pendientes
     * @param operator token String de lista de tokens pendientes
     */
    private double evaluateOperator(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "^":
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Operador ingresado invalido: " + operator);
        }
    }

    /**
     * Evalua la expresion cuando encuentra un parentesis cerrado
     * 
     * @throws IllegalArgumentException Error cuando no se puede completar la
     *                                  operacion
     */
    private void evaluateSubexpression() throws IllegalArgumentException {
        double result = 0;
        boolean hasOperator = false;

        while (!stack.empty() && Double.isNaN((Double) stack.peek())) { // verifica que el stack no este vacio y el
                                                                        // número superior es diferente de tipo NaN
                                                                        // Double
            stack.pop();

            if (!hasOperator) {
                result = Double.parseDouble(stack.pop().toString());
                hasOperator = true;

            } else {
                throw new IllegalArgumentException("¡No se ha podido completar la operacion! Intenta de nuevo...");

            }
        }
        if (hasOperator) {
            stack.push(result);
        }
    }
}
