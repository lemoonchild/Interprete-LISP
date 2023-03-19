import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase Interpreter 
 * Objetivo: 
 */

public class Interpreter<T> {
    Conditions condition = new Conditions();
    Operations operations = new Operations<>();
    Predicados predicados = new Predicados<>();
    static DEFUN def_funciones = new DEFUN();
    static Variables variables = new Variables<>();
    Functions funciones = new Functions();
    SintaxScann ss = new SintaxScann();

    String p1 = "";
    String p2 = "";

    Boolean ans = false;

    /**
     * Metodo que realiza las demas funciones dependiendo del metodo "decide action"
     * @param lisp_code Arraylist de Arraylist de codigo obtenido de txt 
     */
    public void Interp(ArrayList<ArrayList<String>> lisp_code) {
        for (ArrayList<String> function : lisp_code) {

            int a = ss.Decide_action(function.get(0));
            switch (a) {
                case 1: // Defun
                    def_funciones.create(function);
                    break;
                case 2: // Condiciones
                    COND(function);
                    break;
                case 3: // SetQ
                    SetQ(function);
                    break;
                case 4: // Quote
                    QUOTE(function.get(0));
                    break;
                case 5: // ATOM ¿Es una lista?
                    ans = predicados.start(5, function.get(0), null);
                    System.out.println(ans);
                    break;
                case 6: // Equal
                    dividirParam(function);
                    ans = predicados.start(6, p1, p2);
                    System.out.println(ans);
                    break;
                case 7: // <
                    dividirParam(function);
                    ans = predicados.start(7, p1, p2);
                    System.out.println(ans);
                    break;
                case 8: // >
                    dividirParam(function);
                    ans = predicados.start(8, p1, p2);
                    System.out.println(ans);
                    break;
                case 9: // List - crear listas
                    String list1 = predicados.listCreation(function.get(0));
                    System.out.println(list1);
                    break;
                case 10: // Operaciones aritmeticas 
                    for (String tokens : function) {

                        if (containsOnlyNumbers(tokens)) {
                            evaluateOnlyNumbers(function.get(0));

                        } else {
                            evaluateWithVar(function.get(0), variables.getVariables());

                        }

                    }
                case 11: // defun 
                    dividirParam(function);
                    def_funciones.used_SavedFunction("", p1, p2);
                    break;
                case 0: // no pertenece a funciones 
                    System.out.println("Existe un error en el código");
                    break;

                default:
                    break;
            }
        }
    }

    /**
     * @param aa
     */
    public void Read_COND(ArrayList<String> aa) {
        condition.Read_COND(aa);
    }

    /**
     * @param ab
     */
    public void COND(ArrayList<String> ab) {
        condition.COND(ab);
    }

    /**
     * @param bb
     */
    public void getExpressions(String bb) {
        condition.getExpressions(bb);
    }

    /**
     * @param c
     */
    public void evaluateOnlyNumbers(String c) {
        operations.evaluateOnlyNumbers(c);
    }

    /**
     * @param aa
     * @param variables
     */
    public void evaluateWithVar(String aa, HashMap<String, Double> variables) {
        operations.evaluateWithVar(aa, variables);
    }

    /**
     * @param c
     */
    public void SetQ(ArrayList<String> c) {
        variables.SetQ(c, " ", variables.getVariables());
        System.out.println(variables.getVariables());
    }

    /**
     * @param a
     */
    public void QUOTE(String a) {
    }

    /**
     * @param expressions
     * @return
     */
    public boolean containsOnlyNumbers(String expressions) {

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(expressions);

        return matcher.find();
    }

    /**
     * @param exprAssignValue
     */
    public void dividirParam(ArrayList<String> exprAssignValue) {
        ArrayList<String> tokens = readFile.split(exprAssignValue, " ");
        String newexprVar = tokens.get(2).replace("(", "").replace(")", "").trim();

        p1 = tokens.get(1);
        p2 = newexprVar;
    }

}