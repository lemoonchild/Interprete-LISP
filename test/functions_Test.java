import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

public class functions_Test {
    DEFUN def_fun = new DEFUN();
    ArrayList<String> lispCode = new ArrayList<>();
    String p1;
    String p2;
    String toUsefunction;
    HashMap<String, Functions> temp = def_fun.savedFunctions;

    public void stablish() {
        lispCode.add("(defun categorize-number (number)");
        lispCode.add("(cond ");
        lispCode.add("((< number 0) \"Negativo\"");
        lispCode.add("((= number 0) \"Cero\")");
        lispCode.add("((< number 10) \"Un dígito\")");
        lispCode.add("((< number 100) \"Dos dígitos\")");
        lispCode.add("((< number 1000) \"Tres dígitos\")");
        lispCode.add("(t \"Más de tres dígitos\"))");

        def_fun.create(lispCode);
    }

    public void dividirParam(ArrayList<String> exprAssignValue) {
        ArrayList<String> tokens = readFile.split(exprAssignValue, " ");
        toUsefunction = tokens.get(0).replaceAll("\\(", "");
        if (tokens.size() > 2) {
            String newexprVar = tokens.get(2).replace("(", "").replace(")", "").trim();
            p1 = tokens.get(1);
            p2 = newexprVar;
        } else { // Función de solo un parámetro
            String newexprVar = tokens.get(1).replace("(", "").replace(")", "").trim();
            p1 = newexprVar;
            p2 = null;
        }

    }

    @Test
    public void create_Function() {
        stablish();
        assertTrue(temp.containsKey("categorize-number"));
    }

    @Test
    public void evaluate_Function() {
        stablish();
        ArrayList<String> a = new ArrayList<>();
        a.add("(categorize-number (3))");
        dividirParam(a);
        def_fun.use_SavedFunction("categorize-number", p1, p2);
    }
}
