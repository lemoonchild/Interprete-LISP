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
        isVariable(1, 2);

        switch (action) {
            case 5:
                ans = Atom(toDo);
                break;
            case 6:
                ans = Equal(elements[1], elements[2]);
                break;
            case 7:
                ans = LessThan(Double.valueOf(elements[1]), Double.valueOf(elements[2]));
                break;
            case 8:
                ans = MoreThan(Double.valueOf(elements[1]), Double.valueOf(elements[2]));
                break;
            case 9:
                listCreation((ArrayList<String>) Arrays.asList(elements));
                break;
            case 0:
                if (elements[0].equalsIgnoreCase("t") || elements[0].equalsIgnoreCase("(t")) {
                    ans = true;
                }
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
            return true;
        } else {
            return false;
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

    public LinkedList<String> listCreation(ArrayList<String> Elements) {
        LinkedList<String> temp = new LinkedList<>();
        for (String object : Elements) {
            temp.add(object);
        }
        return temp;
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