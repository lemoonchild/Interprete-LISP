
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Predicados
 * Objetivo: evaluar distintas expresiones y devolver el dato (dado por el
 * usuario) según se obtenga un resultado verdadero o falso
 */

public class Predicados<T> {
    String[] elements;

    /**
     * Metodo que define las acciones que realizara predicados
     * llama a otros métodos dentro de esta clase para evaluarlos
     * 
     * @param action
     * @param toDo
     * @param ifTrue
     * @return
     */
    public boolean start(int action, String toDo, String ifTrue) {
        toDo = toDo.replaceAll("\\(", "").replaceAll("\\)", "");
        elements = toDo.split(" ");
        Boolean ans = false;

        switch (action) {
            case 5: // ¿Lista? - atom
                ans = Atom(toDo);
                break;
            case 6: // ¿iguales? - equal
                isVariable(1, 2);
                ans = Equal(elements[1], elements[2]);
                break;
            case 7: // menor que
                isVariable(1, 2);
                ans = LessThan(Double.valueOf(elements[1]), Double.valueOf(elements[2]));
                break;
            case 8: // mayor que
                isVariable(1, 2);
                ans = MoreThan(Double.valueOf(elements[1]), Double.valueOf(elements[2]));
                break;
            case 9: // crear una lista
                listCreation(toDo);
                break;
            case 0: // default case
                if (toDo.contains("t")) {
                    ans = true;
                }
                break;
            default: // error
                System.out.println("Condición inválida, por favor revisa el código");
                break;
        }

        True(ifTrue, ans);
        return ans; // verdadero o falso
    }

    /**
     * Revisa si el dato dado es una lista o no
     * 
     * @param elemento
     * @return falso si es una lista, verdadero si no lo es
     */
    public boolean Atom(String elemento) {
        HashMap<String, T> temp = Interpreter.variables.getVariables();
        elemento = elemento.replace("\\(atom", "");
        if (elemento.contains("(") & elemento.contains("))")) { // es una lista
            return false;
        } else {
            if (temp.containsKey(elemento.replace("\\)", ""))) { // En caso de que sea una variable
                String variable = (String) temp.get(elemento.replace("\\)", ""));
                if (variable.contains("(") & variable.contains(")")) { // la variable guarda una lista
                    return false;
                } else {
                    return true;
                }
            } else { // simplemente no es una lista
                return true;
            }

        }
    }

    /**
     * Revisa que dos datos sean iguales
     * 
     * @param e1
     * @param e2
     * @return dato verdadero si son iguales
     */
    public boolean Equal(String e1, String e2) {
        if (e1.equalsIgnoreCase(e2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * revisa si dos datos son diferentes
     * 
     * @param e1
     * @param e2
     * @return dato verdadero si e1 es menor que e2
     */
    public boolean LessThan(Double e1, Double e2) {
        if (e1 < e2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * revisa si dos datos son diferentes
     * 
     * @param e1
     * @param e2
     * @return dato verdadero si e1 es mayor que e2
     */
    public boolean MoreThan(Double e1, Double e2) {
        if (e1 > e2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * permite la creacion de una lista a partir de una serie de elementos dados
     * 
     * @param Elements
     * @return string con lista
     */
    public String listCreation(String Elements) {
        String Createdlist = "(";
        String[] temp = Elements.split(" ");
        for (String string : temp) {
            if (string.contains("list")) {
                continue;
            } else {
                Createdlist += string + " ";
            }
        }

        return Createdlist.trim();
    }

    /**
     * Revisa si los parámetros a pasar en el predicado son variables registradas
     * 
     * @param i
     * @param j
     */
    public void isVariable(int i, int j) {
        HashMap<String, T> temp = Interpreter.variables.getVariables();

        if (temp.containsKey(elements[i])) {
            elements[i] = temp.get(elements[i]).toString();
        }
        if (temp.containsKey(elements[j])) {
            elements[j] = temp.get(elements[j]).toString();
        }

    }

    /**
     * Cuando el predicado devuelve un resultado positivo se realiza la acción
     * especificada por el usuario
     * 
     * @param ifTrue - expresión en caso de resultado verdadero
     * @param ans    - resultado de predicado
     */
    public void True(String ifTrue, Boolean ans) {
        HashMap<String, T> temp = Interpreter.variables.getVariables();
        ArrayList<ArrayList<String>> foo = new ArrayList<ArrayList<String>>();

        if (ifTrue != null) {
            if (ans) {
                if (ifTrue.contains("\"")) { // En caso de que sea una cadena con comillas
                    ifTrue = ifTrue.replaceAll("\"", "");
                    System.out.println(ifTrue);
                } else {
                    if (temp.containsKey(ifTrue)) { // En caso de que sea una variable
                        System.out.println(temp.get(ifTrue));
                    } else { // Cualquier otro caso
                        ArrayList<String> trueCode = new ArrayList<String>();
                        trueCode.add("(" + ifTrue + ")");
                        foo.add(trueCode);
                        new Interpreter<>().Interp(foo);
                    }
                }
            }
        }
    }
}