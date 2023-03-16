import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Conditions
 * Permite al usuario/programador escribir una condición y guardarla utilizando
 * COND
 */

public class Conditions {

    public String Read_COND(ArrayList<String> part) {
        String Conditions = new String();
        for (String p : part) {
            if (p.equalsIgnoreCase("(cond")) {
                continue;
            } else if (p.equals(")")) {
                break;
            } else {
                Conditions += p;
            }
        }

        return Conditions;
    }

    public String COND(ArrayList<String> Condition) {
        String ToDo = Read_COND(Condition);
        List<String> work = getExpressions(ToDo);

        for (int i = 0; i < work.size() / 2; i += 2) {
            int predicado = new SintaxScann().Decide_action(work.get(i));
            new Predicados<>(predicado, ToDo);
        }

        return "";
    }

    public static List<String> getExpressions(String general) {

        List<String> expressions = Arrays.asList(general.split("[()]"));
        expressions = expressions.stream()
                .filter(s -> s.matches("[a-zA-Z0-9]+.*"))
                .map(String::trim)
                .collect(Collectors.toList());

        expressions.remove(0);

        return expressions;
    }

}