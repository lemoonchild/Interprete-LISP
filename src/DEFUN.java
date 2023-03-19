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

    /**
     * @param code
     */
    public void create(ArrayList<String> code) {
        Functions tempF = new Functions<>();
        String[] a = code.get(0).split(" ");

        tempF.setName(a[1].trim());
        partial_function(code);
        tempF.setCode(acciones);

        savedFunctions.put(tempF.getName(), tempF);

    }

    /**
     * @param code
     */
    public void partial_function(ArrayList<String> code) {
        ArrayList<String> sf = new ArrayList<String>();
        code.remove(0);

        for (String line : code) {
            line.replaceAll("\\))", "\\)");
            sf.add(line);

            acciones.add(sf);
        }

    }

    /**
     * @param <T>
     * @param toUse
     * @param par1
     * @param par2
     */
    public <T> void used_SavedFunction(String toUse, T par1, T par2) {

        if (savedFunctions.containsKey(toUse)) {
            if (par1 != null) {
                savedFunctions.get(toUse).setPar1(par1);
            }
            if (par2 != null) {
                savedFunctions.get(toUse).setPar2(par2);
            }
            evaluate.Interp(savedFunctions.get(toUse).getCode());
        } else {
            System.out.println("Esta función no se encuentra registrada en el programa");
        }
    }
}
