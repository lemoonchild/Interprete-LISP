import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase DEFUN
 * Objetivo:
 */

public class DEFUN {

    HashMap<String, Functions> savedFunctions = new HashMap<>();
    ArrayList<ArrayList<String>> acciones = new ArrayList<>();
    Interpreter evaluate = new Interpreter<>();
    Functions tempF = new Functions<>();

    /**
     * @param code
     */
    public void create(ArrayList<String> code) {
        String[] a = code.get(0).split(" ");

        tempF.setName(a[1].trim());
        partial_function(code);
        tempF.setCode(acciones);
        assignParameters(a);

        savedFunctions.put(tempF.getName(), tempF);

    }

    /**
     * @param code
     */
    public void partial_function(ArrayList<String> code) {
        ArrayList<String> sf = new ArrayList<String>();
        code.remove(0);

        for (String line : code) {
            line = line.replaceAll("\\)\\)", "\\)");
            sf.add(line);
        }

        acciones.add(sf);

    }

    /**
     * @param <T>
     * @param toUse
     * @param par1
     * @param par2
     */
    public <T> void use_SavedFunction(String toUse, T par1, T par2) {

        if (savedFunctions.containsKey(toUse)) {
            if (par1 != null) {
                savedFunctions.get(toUse).setVPar1(par1);
            }
            if (par2 != null) {
                savedFunctions.get(toUse).setVPar2(par2);
            }
            evaluate.Interp(savedFunctions.get(toUse).getCode());
        } else {
            System.out.println("Esta función no se encuentra registrada en el programa");
        }
    }

    public void assignParameters(String[] values) {
        if (values.length > 3) {
            String p1 = values[2].replaceAll("\\(", "").replaceAll("\\)", "");
            String p2 = values[3].replaceAll("\\(", "").replaceAll("\\)", "");
            tempF.setPar(p1, p2);
        } else {
            String p1 = values[2].replaceAll("\\(", "").replaceAll("\\)", "");
            tempF.setPar(p1, null);
        }

    }
}
