import java.util.ArrayList;
import java.util.HashMap;

public class SetQ {
    static readFile read = new readFile();
    static Variables variables = new Variables<>();
    static ArrayList<String> araaaa = new ArrayList<String>();

    public static <T> void setQ_parame(ArrayList<String> exprAssignValue, String delimiter,HashMap<String, T> variables) {
        araaaa.add("(setq x 10)");
        ArrayList<String> tokens = read.split(exprAssignValue, delimiter);
        String newexprVar = tokens.get(2).replace("(", "").replace(")", "").trim();

        if (tokens.size() < 3 || !tokens.get(0).contains("setq")) {

            throw new IllegalArgumentException("Este no es un SetQ");
        }

        String variableName = tokens.get(1);
        T varValue = (T) newexprVar;

        variables.put(variableName, varValue);
    }

    public static void main(String[] args) {
        setQ_parame(araaaa, " ", variables.getVariables());
        System.out.println(variables.getVariables());
    }
}
