import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase DEFUN
 * Objetivo: crear una función en base a los deseos del usuario, hacuendo uso de
 * otras funciones especiales, ya establecidas
 */

public class DEFUN {

    HashMap<String, Functions> savedFunctions = new HashMap<>();
    ArrayList<ArrayList<String>> acciones = new ArrayList<>();
    Interpreter evaluate = new Interpreter<>();
    Functions tempF = new Functions<>();

    /**
     * Permite el registro de una funcion a través de la clase "Function"
     * registra el nombre que se le da y guarda los parametros y codigo que se deben
     * utilizar al llamarla
     * 
     * @param code - todo el contenido que debe ingresarse a la funcion
     */
    public void create(ArrayList<String> code) {
        String[] a = code.get(0).split(" ");

        tempF.setName(a[1].trim());
        partial_function(code);
        tempF.setCode(acciones);
        assignParameters(a);

        savedFunctions.put(tempF.getName(), tempF);

    }

    /**
     * Guarda el código deseado para la funcion creada en el formato adecuado para
     * ser leído
     * 
     * @param code - simplemente el codigo que se evalúa en la función
     */
    public void partial_function(ArrayList<String> code) {
        ArrayList<String> sf = new ArrayList<String>();
        code.remove(0);

        for (String line : code) {
            line = line.replaceAll("\\)\\)", "\\)");
            sf.add(line);
        }

        acciones.add(sf);

    }

    /**
     * Permite el uso de una función crada anteriormente
     * 
     * @param <T>   uso de genericos para un funcionamiento adecuado
     * @param toUse nombre de la función a usar
     * @param par1  valor dado al parametro 1 de la funcion
     * @param par2  valor dado al parametro 2 de la funcion
     */
    public <T> void use_SavedFunction(String toUse, T par1, T par2) {

        if (savedFunctions.containsKey(toUse)) {
            if (par1 != null) {
                savedFunctions.get(toUse).setVPar1(par1);
            }
            if (par2 != null) {
                savedFunctions.get(toUse).setVPar2(par2);
            }
            evaluate.Interp(savedFunctions.get(toUse).getCode());
        } else {
            System.out.println("Esta función no se encuentra registrada en el programa");
        }
    }

    /**
     * asigna el valor especifico a los parametros de una funcion, dependiendo si
     * cuenta con 1 o 2
     * 
     * @param values listado de parametros dados por el usuario
     */
    public void assignParameters(String[] values) {
        if (values.length > 3) {
            String p1 = values[2].replaceAll("\\(", "").replaceAll("\\)", "");
            String p2 = values[3].replaceAll("\\(", "").replaceAll("\\)", "");
            tempF.setPar(p1, p2);
        } else {
            String p1 = values[2].replaceAll("\\(", "").replaceAll("\\)", "");
            tempF.setPar(p1, null);
        }

    }
}
