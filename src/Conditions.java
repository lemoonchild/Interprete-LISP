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

    public ArrayList<List<String>> Read_COND(ArrayList<String> part) {
        ArrayList<List<String>> Conditions = new ArrayList<List<String>>();
        for (String p : part) {
            if (p.equalsIgnoreCase("(cond")) {
                continue;
            } else if (p.equals(")")) {
                break;
            } else if (p.contains("(t")) {
                List<String> defAction = Arrays.asList(p.split(" "));
                Conditions.add(defAction);
            } else {
                List<String> a = getExpressions(p);
                Conditions.add(a);
            }
        }

        return Conditions;
    }

    public <T> void COND(ArrayList<String> Condition) {
        ArrayList<List<String>> ToDo = Read_COND(Condition);
        Predicados<T> true_false = new Predicados<>();
        Boolean fin = false;

        for (List<String> list : ToDo) {
            for (int i = 0; i < list.size(); i += 2) {
                if (list.get(i).equals("") || list.get(i).equals(" ")) {
                    continue;
                } else if (list.get(i).contains("t")) {
                    String def = list.get(2).trim();
                    true_false.start(0, "t", def);
                    break;
                } else {
                    int predicado = new SintaxScann().Decide_action(list.get(i));
                    fin = true_false.start(predicado, list.get(i), list.get(i + 1).trim());
                }

                if (fin) {
                    break;
                }
            }
            if (fin) {
                break;
            }
        }

    }

    public static List<String> getExpressions(String lispCode) {
        List<String> expressions = Arrays.asList(lispCode.split("[()]"));
        expressions = expressions.stream().collect(Collectors.toList());
        return expressions;
    }

}