import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Operations<T extends Number> {

    private Map<String, T> variables;
    private Stack<Object> stack;

    public Operations() {
        this.variables = new HashMap<>();
        this.stack = new Stack<>();
    }

    public T evaluate(String expression) throws IllegalArgumentException {

        String[] tokens = expression.split("\\s+|(?=\\()|(?<=\\))");
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
    
            } else if (isAssignment(token)) {

                String variableName = tokens[0].substring(1);
                T value = (T) stack.pop();
                variables.put(variableName, value);
    
            } else if (isOpeningParenthesis(token)) {

                stack.push(token);
    
            } else if (isClosingParenthesis(token)) {

                evaluatePendingTokens(pendingTokens);
                evaluateSubexpression();
    
            } else {

                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }
        System.out.println("El resultado de la operacion es el siguiente: ");
        return (T) stack.pop();
    }
    private boolean isNumber(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean isVariable(String token) {
        return token.matches("[a-zA-Z]+");
    }

    private boolean isFunction(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean isAssignment(String token) {
        return token.startsWith("!");
    }

    private boolean isOpeningParenthesis(String token) {
        return token.equals("(");
    }

    private boolean isClosingParenthesis(String token) {
        return token.equals(")");
    }

    private void evaluatePendingTokens(List<Object> tokens) {
        while (tokens.size() > 1 && tokens.get(tokens.size() - 2) instanceof Double) {
            double b = (double) tokens.remove(tokens.size() - 1);
            double a = (double) tokens.remove(tokens.size() - 1);
            String operator = (String) tokens.remove(tokens.size() - 1);
            double result = evaluateOperator(a, b, operator);
            stack.push(result);
            tokens.add(result);
        }
    }

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
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private void evaluateSubexpression() throws IllegalArgumentException {
        double result = 0;
        boolean hasOperator = false;

        while (!stack.empty() && Double.isNaN((Double) stack.peek())) {
            stack.pop(); // remove opening parenthesis

            if (!hasOperator) {
                result = Double.parseDouble(stack.pop().toString());
                hasOperator = true;

            } else {
                throw new IllegalArgumentException("Missing operator in subexpression");
                
            }
        }
        if (hasOperator) {
            stack.push(result);
        }
    }
}
        
    





    


