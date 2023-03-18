import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Predicados
 */
public class Predicados<T> {
    String[] elements;

    public boolean start(int action, String toDo, String ifTrue) {
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
                System.out.println("Condición inválida, revisa tu código");
                break;
        }

        if (ifTrue != null) {
            if (ans) {
                System.out.println(ifTrue);
            }
        }
        return ans;
    }

    public boolean Atom(String elemento) {
        if (elemento.contains("(") & elemento.contains(")")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean Equal(String e1, String e2) {
        if (e1.equalsIgnoreCase(e2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean LessThan(Double e1, Double e2) {
        if (e1 < e2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean MoreThan(Double e1, Double e2) {
        if (e1 > e2) {
            return true;
        } else {
            return false;
        }
    }

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

    public void isVariable(int i, int j) {
        HashMap<String, T> temp = Interpreter.variables.getVariables();

        if (temp.containsKey(elements[i])) {
            elements[i] = temp.get(elements[i]).toString();
        }
        if (temp.containsKey(elements[j])) {
            elements[j] = temp.get(elements[j]).toString();
        }

    }
}