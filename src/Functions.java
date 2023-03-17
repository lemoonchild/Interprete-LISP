import java.util.ArrayList;
import java.util.HashMap;

/**
 * Functions
 */
public class Functions {
    HashMap<String, ArrayList<String>> savedFunctions = new HashMap<>();
    ArrayList<String> acciones = new ArrayList<>();

    public void DEFUN(ArrayList<String> code) {
        for (int i = 1; i < code.size(); i++) {
            new Interpreter<>().act(i, code);
        }

        String[] a = code.get(0).split(" ");
        savedFunctions.put(a[1], acciones);

    }

}