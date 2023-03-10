import java.util.ArrayList;

/**
 * Predicados
 */
public class Predicados<T> {

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

}