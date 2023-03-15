import java.util.Map;
import java.util.Stack;

public class Operations{
    

    private Map<String, Double> variables;

    public double evaluate(String expression) throws IllegalArgumentException {

        String[] tokens = expression.split("(\\s|\\()");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isVariable(token)) {
                stack.push(variables.get(token));
            } else if (isFunction(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Not enough arguments for function: " + token);
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = applyFunction(token, a, b);
                stack.push(result);
            } else if (isAssignment(token)) {
                String variableName = tokens[0].substring(1);
                double value = stack.pop();
                variables.put(variableName, value);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Mismatched operators and operands");
        }
        return stack.pop();
    }


    private boolean isNumber(String tokens) {
        return tokens.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean isVariable(String tokens) {
        return tokens.matches("[a-zA-Z]+");
    }

    private boolean isFunction(String token) {
        String trimmedToken = token.trim(); 
        return trimmedToken.equals("+") || trimmedToken.equals("-") || trimmedToken.equals("*") || trimmedToken.equals("/");
    }
    
    private boolean isAssignment(String tokens) {
        return tokens.startsWith("!");
    }

    private double applyFunction(String function, double a, double b) {
        switch (function) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid function: " + function);
        }
    }
}




    


