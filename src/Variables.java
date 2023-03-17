import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * Variables
 */
public class Variables<T> {
    static readFile read = new readFile();
     ArrayList<String> araaaa = new ArrayList<String>();

    private HashMap<String, T> variables = new HashMap<>();

    public HashMap<String, T> getVariables() {
        return variables;
    }

    public void setVariables(HashMap<String, T> variables) {
        this.variables = variables;
    }

    public Variables() {
    }

    public static <T> void SetQ(ArrayList<String> exprAssignValue, String delimiter,HashMap<String, T> variables) {
        ArrayList<String> tokens = read.split(exprAssignValue, delimiter);
        String newexprVar = tokens.get(2).replace("(", "").replace(")", "").trim();

        if (tokens.size() < 3 || !tokens.get(0).contains("setq")) {

            throw new IllegalArgumentException("Este no es un SetQ");
        }

        String variableName = tokens.get(1);
        T varValue = (T) newexprVar;

        variables.put(variableName, varValue);
    }

    public String Quote(String quoteExpr) {

        Pattern pattern = Pattern.compile("\\(quote\\(([^)]+)\\)\\)");
        Matcher matcher = pattern.matcher(quoteExpr);
        if (matcher.find()) {
            String textInside = matcher.group(1);
            return "'(" + textInside.replaceFirst("^quote\\(", "").replaceFirst("\\)$", "") + ")'";
        } else {
            throw new IllegalArgumentException("¡Cuidado! La cadena no cumple con parametros de Quote");
        }
    }

}
