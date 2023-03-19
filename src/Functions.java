import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Functions
 * Objetivo:
 */

public class Functions<T> {
    private String name;
    private ArrayList<ArrayList<String>> code;
    private String par1 = "";
    private String par2 = "";

    public void setPar(String par1, String par2) {
        this.par1 = par1;
        this.par2 = par2;
    }

    public T getPar1() {
        return (T) Interpreter.variables.getVariables().get(par1);
    }

    public void setVPar1(T value_par1) {
        Interpreter.variables.getVariables().put(par1, value_par1);
    }

    public T getPar2() {
        return (T) Interpreter.variables.getVariables().get(par2);
    }

    public void setVPar2(T value_par2) {
        Interpreter.variables.getVariables().put(par2, value_par2);
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public ArrayList<ArrayList<String>> getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(ArrayList<ArrayList<String>> code) {
        this.code = code;
    }

}