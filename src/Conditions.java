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
     * Interpreta la expresión creada para cond, divide cada conjunto de condición -
     * expresión
     * 
     * @param part
     * @return conjunto de condiciones - expresiones a evaluar
     */
    public ArrayList<List<String>> Read_COND(ArrayList<String> part) {
        ArrayList<List<String>> Conditions = new ArrayList<List<String>>();
        for (String p : part) {
            if (p.equalsIgnoreCase("(cond")) { // ignora la linea inicial que contiene solo cond
                continue;
            } else if (p.equals(")")) { // termina el proceso al llegar a la linea que contiene solo paréntesis de
                                        // cierre
                break;
            } else if (p.contains("(t")) { // caso especial - default
                List<String> defAction = Arrays.asList(p.trim());
                Conditions.add(defAction);
            } else { // añade cada linea de condición encontrada a un listado
                List<String> a = getExpressions(p);
                Conditions.add(a);
            }
        }

        return Conditions;
    }

    /**
     * evalua el código de cond, cada una de las posibilidades
     * 
     * @param <T>
     * @param Condition
     */
    public <T> void COND(ArrayList<String> Condition) {
        ArrayList<List<String>> ToDo = Read_COND(Condition);
        Predicados<T> true_false = new Predicados<>();
        Boolean fin = false;

        for (List<String> list : ToDo) {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isBlank()) { // remueve lineas en blanco del listado
                    list.remove(i);
                }
            }

            for (int i = 0; i < list.size();) {
                if (list.get(i).isBlank()) { // ignora las lineas que hayan quedado en blanco
                    i++;
                } else if (list.get(i).contains("cond")) { // ignora las lineas que solo digan cond
                    i++;
                } else if (list.get(i).contains("t")) { // accion especial en caso de llegar al caso default
                    String show = list.get(i).replaceAll("\\(t ", "").trim();
                    show = show.replaceAll("\\)", "");
                    fin = true_false.start(0, "t", show);
                    i++;
                } else { // evalua la condición encontrada
                    int predicado = new SintaxScann().Decide_action(list.get(i));
                    fin = true_false.start(predicado, list.get(i), list.get(i + 1));
                    i += 2;
                }
            }
            if (fin) { // rompe todo el ciclo si encuentra resultado positivo
                break;
            }

        }
    }

    /**
     * Toma una sola linea y la divide de acuerdo a los paréntesis encontrados
     * 
     * @param lispCode
     * @return
     */
    public static List<String> getExpressions(String lispCode) {
        List<String> expressions = Arrays.asList(lispCode.split("[()]"));
        expressions = expressions.stream().collect(Collectors.toList());
        return expressions;
    }

}