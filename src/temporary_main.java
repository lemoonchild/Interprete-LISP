import java.util.ArrayList;
import java.util.HashMap;

public class temporary_main<T> {
    public static Variables v = new Variables();

    public static void main(String[] args) {
        v.getVariables().put("x", 5);

        ArrayList<String> lispCode;
        Conditions cond = new Conditions();

        lispCode = new ArrayList<>();
        lispCode.add("(cond");
        lispCode.add("((> x 10) 'x es mayor que 10')");
        lispCode.add("((= x 5) 'x es igual a 5')");
        lispCode.add("((< x 0) 'x es menor que 0')");
        lispCode.add("(t 'x es mayor o igual a 0, pero menor o igual que 10'))");
        cond.COND(lispCode);
    }
}
