import java.util.ArrayList;

/**
 * Functions
 * 
 * @param <T>
 */
public class Functions<T> {
    private String name;
    private ArrayList<ArrayList<String>> code;
    private T par1;
    private T par2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ArrayList<String>> getCode() {
        return code;
    }

    public void setCode(ArrayList<ArrayList<String>> code) {
        this.code = code;
    }

    public T getPar1() {
        return par1;
    }

    public void setPar1(T par1) {
        this.par1 = par1;
    }

    public T getPar2() {
        return par2;
    }

    public void setPar2(T par2) {
        this.par2 = par2;
    }

}