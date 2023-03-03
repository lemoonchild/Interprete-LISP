import java.util.ArrayList;

/**
 * Conditions
 * Permite al usuario/programador escribir una condición y guardarla utilizando
 * COND
 */

public class Conditions {

    public ArrayList<String> Read_COND(ArrayList<String> part) {
        ArrayList<String> Conditions = new ArrayList<String>();
        for (String p : part) {
            if (p.equalsIgnoreCase("(cond")) {
                continue;
            } else if (p.equals(")")) {
                break;
            } else {

            }
        }

        return Conditions;
    }

    public void COND(ArrayList<String> Condition) {

    }
}