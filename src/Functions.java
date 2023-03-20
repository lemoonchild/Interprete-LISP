import java.util.ArrayList;

/**
 * Clase Functions
 * Objetivo: Clase para guardar el codigo de DEFUN
 */

public class Functions<T> {
    private String name;
    private ArrayList<ArrayList<String>> code;
    private String par1 = "";
    private String par2 = "";

    /**
     * Este método se encarga de guardar los nombres de los parámetros a usar en la
     * función
     * 
     * @param par1 nombre del parámetro 1
     * @param par2 nombre del parámetro 2
     */
    public void setPar(String par1, String par2) {
        this.par1 = par1;
        this.par2 = par2;
    }

    /**
     * Se encarga de devolver el valor asignado en el parámetro 1
     * 
     * @return valor parámetro 1
     */
    public T getPar1() {
        return (T) Interpreter.variables.getVariables().get(par1);
    }

    /**
     * Registra el parámetro 1 de la función como una variable dentro del hashmap
     * creado en el programa.
     * 
     * @param value_par1
     */
    public void setVPar1(T value_par1) {
        Interpreter.variables.getVariables().put(par1, value_par1);
    }

    /**
     * Se encarga de devolver el valor asignado en el parámetro 2
     * 
     * @return valor parámetro 2
     */
    public T getPar2() {
        return (T) Interpreter.variables.getVariables().get(par2);
    }

    /**
     * Registra el parámetro 2 de la función como una variable dentro del hashmap
     * creado en el programa.
     * 
     * @param value_par2
     */
    public void setVPar2(T value_par2) {
        Interpreter.variables.getVariables().put(par2, value_par2);
    }

    /**
     * Devuelve el nombre asignado a esta función
     * 
     * @return nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Define el nombre para la función
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el arraylist con el código de la función
     * 
     * @return código
     */
    public ArrayList<ArrayList<String>> getCode() {
        return code;
    }

    /**
     * Permite registrar el arraylist con el código de la función
     * 
     * @param code
     */
    public void setCode(ArrayList<ArrayList<String>> code) {
        this.code = code;
    }

}