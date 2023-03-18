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

    /**
     * Constructor de la clase 
     */
    public Variables() {

    }

    /**
     * Obtiene las variables del Hashmap 
     * @return Hashmap con variables 
     */
    public HashMap<String, T> getVariables() {
        return variables;
    }

    /**
     * Agrega variables al Hashmap 
     * @param variables Hashmap donde guardar variables 
     */
    public void setVariables(HashMap<String, T> variables) {
        this.variables = variables;
    }

    /**
     * Método que guarda dentro de una variable un valor 
     * @param <T> Generico 
     * @param exprAssignValue Arraylist con tokens dados por usuario 
     * @param delimiter Delimitador para separar los tokens 
     * @param variables Hashmap donde se guardan las variables 
     */
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

    /**
     * Método que imprime lo que el usuario ingresa 
     * @param quoteExpr Expresion a la que se le quiere aplicar el quote 
     * @return Expresion entre apostrofes 
     */
    public String Quote(String quoteExpr) {

        Pattern pattern = Pattern.compile("\\((quote|')\\(([^)]+)\\)\\)");
        Matcher matcher = pattern.matcher(quoteExpr);
        if (matcher.find()) {
            if(quoteExpr.contains("'")){
                String textInside = matcher.group(2);
                return "'(" + textInside.replaceFirst("^'\\(", "").replaceFirst("\\)$", "") + ")'";
            }
            String textInside = matcher.group(2);
            return "'(" + textInside.replaceFirst("^quote\\(", "").replaceFirst("\\)$", "") + ")'";
        } else {
            throw new IllegalArgumentException("¡Cuidado! La cadena no cumple con parametros de Quote");
        }
    }

}
