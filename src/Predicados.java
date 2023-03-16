import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Predicados
 */
public class Predicados<T> {
    Predicados(int action, String toDo) {
        String[] elements = toDo.split(" ");
        switch (action) {
            case 5:
                Atom(toDo);
                break;
            case 6:
                Equal(elements[1], elements[2]);
                break;
            case 7:
                LessThan(Integer.valueOf(elements[1]), Integer.valueOf(elements[2]));
                break;
            case 8:
                MoreThan(Integer.valueOf(elements[1]), Integer.valueOf(elements[2]));
                break;
            case 9:
                listCreation((ArrayList<String>) Arrays.asList(elements));
                break;

            default:
                break;
        }
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

    public boolean LessThan(int e1, int e2) {
        if (e1 < e2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean MoreThan(int e1, int e2) {
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
}