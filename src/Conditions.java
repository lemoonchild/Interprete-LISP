import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase Conditions
 * Objetivo: Permite al usuario/programador escribir una condición y guardarla
 * utilizando COND
 */

public class Conditions {

    /**
     * @param part
     * @return
     */
    public ArrayList<List<String>> Read_COND(ArrayList<String> part) {
        ArrayList<List<String>> Conditions = new ArrayList<List<String>>();
        for (String p : part) {
            if (p.equalsIgnoreCase("(cond")) {
                continue;
            } else if (p.equals(")")) {
                break;
            } else if (p.contains("(t")) {
                List<String> defAction = Arrays.asList(p.trim());
                Conditions.add(defAction);
            } else {
                List<String> a = getExpressions(p);
                Conditions.add(a);
            }
        }

        return Conditions;
    }

    /**
     * @param <T>
     * @param Condition
     */
    public <T> void COND(ArrayList<String> Condition) {
        ArrayList<List<String>> ToDo = Read_COND(Condition);
        Predicados<T> true_false = new Predicados<>();
        Boolean fin = false;

        for (List<String> list : ToDo) {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isBlank()) {
                    list.remove(i);
                }
            }

            for (int i = 0; i < list.size();) {
                if (list.get(i).isBlank()) {
                    i++;
                } else if (list.get(i).contains("cond")) {
                    i++;
                } else if (list.get(i).contains("t")) {
                    String show = list.get(i).replaceAll("\\(t ", "").trim();
                    show = show.replaceAll("\\)", "");
                    fin = true_false.start(0, "t", show);
                    i++;
                } else {
                    int predicado = new SintaxScann().Decide_action(list.get(i));
                    fin = true_false.start(predicado, list.get(i), list.get(i + 1));
                    i += 2;
                }
            }
            if (fin) {
                break;
            }

        }
    }

    /**
     * @param lispCode
     * @return
     */
    public static List<String> getExpressions(String lispCode) {
        List<String> expressions = Arrays.asList(lispCode.split("[()]"));
        expressions = expressions.stream().collect(Collectors.toList());
        return expressions;
    }

}