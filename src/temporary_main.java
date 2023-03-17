import java.util.ArrayList;

public class temporary_main<T> {
    public static Variables v = new Variables();

    public static void main(String[] args) {
        v.getVariables().put("x", 5);

        // ArrayList<String> lispCode;
        Conditions cond = new Conditions();

        // lispCode = new ArrayList<>();
        // lispCode.add("(cond");
        // lispCode.add("((> x 10) 'x es mayor que 10')");
        // lispCode.add("((= x 5) 'x es igual a 5')");
        // lispCode.add("((< x 0) 'x es menor que 0')");
        // lispCode.add("(t 'x es mayor o igual a 0, pero menor o igual que 10'))");
        // cond.COND(lispCode);

        readFile read = new readFile();
        Interpreter.variables.getVariables().put("x", 5);
        for (ArrayList<String> lispCode : read
                ._readfile("C:\\Users\\Fabi\\Documents\\GitHub\\Proyecto-LISP\\src\\Prueba.txt")) {
            cond.COND(lispCode);
        }
        System.out.println("fin");
    }

    String p1;// Primer parámetro para la función
    String p2;// Segundo parámetro para la función

    public void añadirAinterprete(ArrayList<String> exprAssignValue) {
        ArrayList<String> tokens = readFile.split(exprAssignValue, " ");
        String newexprVar = tokens.get(2).replace("(", "").replace(")", "").trim();

        p1 = tokens.get(1);
        p2 = newexprVar;
    } // En cada opción de interp, cambiar aquellos que necesitan parametros por p1 y
      // p2
}
