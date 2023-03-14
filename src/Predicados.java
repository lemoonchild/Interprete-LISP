import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Predicados
 */
public class Predicados<T> {

    // public void Read(ArrayList<String> lines) {
    // String[] Parts;
    // int cont = 0;
    // for (String string : lines) {
    // if (lines.size() != 1) {
    // if (cont == 0) {
    // // Decide.action(string)
    // } else {
    // Parts = string.split(" ");
    // }
    // cont++;
    // } else {
    // // Decide.action(string)
    // Parts = string.split(" ");
    // if (Parts.length > 2) {
    // String e1 = Parts[Parts.length - 2];
    // String e2 = Parts[Parts.length - 1];
    // } else {
    // String elemento = Parts[Parts.length - 1];
    // }
    // }
    // }
    // }

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

    public LinkedList<T> listCreation(ArrayList<T> Elements) {
        LinkedList<T> temp = new LinkedList<>();
        for (T object : Elements) {
            temp.add((T) object);
        }
        return temp;
    }
}