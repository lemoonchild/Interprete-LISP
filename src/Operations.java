import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Operations {

    private Map<String, Double> variables;
    private Stack<Object> stack;

    public LispInterpreter() {
        this.variables = new HashMap<>();
        this.stack = new Stack<>();
    }

    public double evaluate(String expression) throws IllegalArgumentException {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isVariable(token)) {
                stack.push(variables.get(token));
            } else if (isFunction(token)) {
                applyFunction(token);
            } else if (isAssignment(token)) {
                String variableName = tokens[0].substring(1);
                double value = (Double) stack.pop();
                variables.put(variableName, value);
            } else if (isOpeningParenthesis(token)) {
                stack.push(token);
            } else if (isClosingParenthesis(token)) {
                evaluateSubexpression();
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }
        return (Double) stack.pop();
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

    private void applyFunction(String function) throws IllegalArgumentException {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("Not enough arguments for function: " + function);
        }
        double b = (Double) stack.pop();
        double a = (Double) stack.pop();
        double result = 0;
        switch (function) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }
        stack.push(result);
    }

    private void evaluateSubexpression() throws IllegalArgumentException {
        double result = 0;
        boolean hasOperator = false;
        while (!stack.empty() && !isOpeningParenthesis((String) stack.peek())) {
            Object current = stack.pop();
            if (current instanceof Double) {
                double operand = (Double) current;
                if (!hasOperator) {
                    result = operand;
                    hasOperator = true;
                } else {
                    throw new IllegalArgumentException("Missing operator in subexpression");
                }
            } else if (current instanceof String) {
                String operator = (String) current;
                if (isFunction(operator)) {
                    if (hasOperator) {
                        throw new IllegalArgumentException("Multiple operators in subexpression");
                    } else {
                        applyFunction(operator);
                        hasOperator = true;
                    }
                } else {
                    throw new IllegalArgumentException("Invalid token in subexpression: " + operator);
                }
            }
        }
        if (isOpeningParenthesis((String) stack.peek())) {
            stack.pop(); // remove opening parenthesis
        } else {
            throw new IllegalArgumentException("Mismatched parentheses");
        }
    }
}




    


