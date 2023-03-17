import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Variables
 */
public class Variables<T> {
    T _variable;

    public Variables(T variable) {
        this._variable = variable;
    }

    public <V> void SetQ (V aa){
        this._variable = (T) aa;
    }

    public String Quote(String quoteExpr){

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
        


