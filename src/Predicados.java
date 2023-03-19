
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Predicados
 * Objetivo:
 */

public class Predicados<T> {
    String[] elements;

    /**
     * Metodo que define las acciones que realizara predicados
     * 
     * @param action
     * @param toDo
     * @param ifTrue
     * @return
     */
    public boolean start(int action, String toDo, String ifTrue) {
        toDo = toDo.replaceAll("\\(", "").replaceAll("\\)", "");
        elements = toDo.split(" ");
        Boolean ans = false;

        switch (action) {
            case 5:
                ans = Atom(toDo);
                break;
            case 6:
                isVariable(1, 2);
                ans = Equal(elements[1], elements[2]);
                break;
            case 7:
                isVariable(1, 2);
                ans = LessThan(Double.valueOf(elements[1]), Double.valueOf(elements[2]));
                break;
            case 8:
                isVariable(1, 2);
                ans = MoreThan(Double.valueOf(elements[1]), Double.valueOf(elements[2]));
                break;
            case 9:
                listCreation(toDo);
                break;
            case 0:
                if (toDo.contains("t")) {
                    ans = true;
                }
                break;
            default:
                System.out.println("Condición inválida, por favor revisa el código");
                break;
        }

        True(ifTrue, ans);
        return ans;
    }

    /**
     * @param elemento
     * @return
     */
    public boolean Atom(String elemento) {
        elemento = elemento.replace("\\(atom", "");
        if (elemento.contains("(") & elemento.contains("))")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @param e1
     * @param e2
     * @return
     */
    public boolean Equal(String e1, String e2) {
        if (e1.equalsIgnoreCase(e2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param e1
     * @param e2
     * @return
     */
    public boolean LessThan(Double e1, Double e2) {
        if (e1 < e2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param e1
     * @param e2
     * @return
     */
    public boolean MoreThan(Double e1, Double e2) {
        if (e1 > e2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param Elements
     * @return
     */
    public String listCreation(String Elements) {
        String Createdlist = "(";
        String[] temp = Elements.split(" ");
        for (String string : temp) {
            if (string.contains("list")) {
                continue;
            } else {
                Createdlist += string + " ";
            }
        }

        return Createdlist.trim();
    }

    /**
     * @param i
     * @param j
     */
    public void isVariable(int i, int j) {
        HashMap<String, T> temp = Interpreter.variables.getVariables();

        if (temp.containsKey(elements[i])) {
            elements[i] = temp.get(elements[i]).toString();
        }
        if (temp.containsKey(elements[j])) {
            elements[j] = temp.get(elements[j]).toString();
        }

    }

    public void True(String ifTrue, Boolean ans) {
        HashMap<String, T> temp = Interpreter.variables.getVariables();
        ArrayList<ArrayList<String>> foo = new ArrayList<ArrayList<String>>();

        if (ifTrue != null) {
            if (ans) {
                if (ifTrue.contains("\"")) {
                    ifTrue = ifTrue.replaceAll("\"", "");
                    System.out.println(ifTrue);
                } else {
                    if (temp.containsKey(ifTrue)) {
                        System.out.println(temp.get(ifTrue));
                    } else {
                        ArrayList<String> trueCode = new ArrayList<String>();
                        trueCode.add("(" + ifTrue + ")");
                        foo.add(trueCode);
                        new Interpreter<>().Interp(foo);
                    }
                }
            }
        }
    }
}