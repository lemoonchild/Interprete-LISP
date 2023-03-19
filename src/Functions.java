import java.util.ArrayList;

/**
 * Clase Functions 
 * Objetivo: 
 */

public class Functions<T> {
    private String name;
    private ArrayList<ArrayList<String>> code;
    private T par1;
    private T par2;

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

    /**
     * @return
     */
    public T getPar1() {
        return par1;
    }

    /**
     * @param par1
     */
    public void setPar1(T par1) {
        this.par1 = par1;
    }

    /**
     * @return
     */
    public T getPar2() {
        return par2;
    }

    /**
     * @param par2
     */
    public void setPar2(T par2) {
        this.par2 = par2;
    }

}