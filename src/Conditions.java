import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
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
        Hashtable<String, String> work = getExpressions(ToDo);

        return "";
    }

    public static Hashtable<String, String> getExpressions(String general) {
        Hashtable<String, String> cond_exp = new Hashtable<>();

        List<String> expressions = Arrays.asList(general.split("[()]"));
        expressions = expressions.stream()
                .filter(s -> s.matches("[a-zA-Z0-9]+.*"))
                .map(String::trim)
                .collect(Collectors.toList());

        expressions.remove(0);

        int checked = 0;
        for (String string : expressions) {
            cond_exp.put(expressions.get(checked), expressions.get(checked + 1));
            checked += 2;
        }
        return cond_exp;
    }

}