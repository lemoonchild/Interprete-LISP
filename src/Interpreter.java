import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interpreter
 * 
 * @param <T>
 */
public class Interpreter<T> {
    Conditions condition = new Conditions();
    Operations operations = new Operations<>();
    Predicados predicados = new Predicados<>();
    static Variables variables = new Variables<>();

    public void Read_COND(ArrayList<String> aa) {
        condition.Read_COND(aa);
    }

    public void COND(ArrayList<String> ab) {
        condition.COND(ab);
    }

    public void getExpressions(String bb) {
        condition.getExpressions(bb);
    }

    public void evaluateOnlyNumbers(String c) {
        operations.evaluateOnlyNumbers(c);
    }

    public void evaluateWithVar(String aa, HashMap<String, Double> variables) {
        operations.evaluateWithVar(aa, variables);
    }

    public void SetQ(String c) {
        operations.setq(c);
    }

}