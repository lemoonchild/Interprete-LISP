import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Variables
 */
public class Variables<T> {
    private HashMap<String, T> variables = new HashMap<>();

    public HashMap<String, T> getVariables() {
        return variables;
    }

    public void setVariables(HashMap<String, T> variables) {
        this.variables = variables;
    }

    public Variables() {
    }

    public <V> void SetQ(String nombre, T valor) {
        variables.put(nombre, valor);
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
