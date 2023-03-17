import java.util.ArrayList;
import java.util.HashMap;

public class DEFUN {

    HashMap<String, Functions> savedFunctions = new HashMap<>();
    ArrayList<ArrayList<String>> acciones = new ArrayList<>();
    Interpreter evaluate = new Interpreter<>();

    public void create(ArrayList<String> code) {
        Functions tempF = new Functions<>();
        String[] a = code.get(0).split(" ");

        tempF.setName(a[0]);
        partial_function(code);
        tempF.setCode(acciones);

    }

    public void partial_function(ArrayList<String> code) {
        int abre_parentesis = 0;
        int cierra_parentesis = 0;
        ArrayList<String> sf = new ArrayList<String>();

        int lineasTranscurridas = 0;

        for (int i = 0; i < code.size();) {
            do {
                String line = code.get(i);
                sf.add(line);
                String[] chars = line.split("");
                if (chars.equals("(")) {
                    abre_parentesis += 1;
                } else if (chars.equals(")")) {
                    cierra_parentesis += 1;
                }
                lineasTranscurridas++;
            } while (abre_parentesis != cierra_parentesis);
            acciones.add(sf);
            i = lineasTranscurridas;
        }

    }

    public <T> void used_SavedFunction(String toUse, T par1, T par2) {

        if (savedFunctions.containsKey(toUse)) {
            savedFunctions.get(toUse).setPar1(par1);
            savedFunctions.get(toUse).setPar2(par2);
            evaluate.Interp(savedFunctions.get(toUse).getCode());
        }
    }
}
