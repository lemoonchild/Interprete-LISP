
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;


public class BooleanActions_test {
    ArrayList<String> lispCode;
    Conditions cond = new Conditions();
    Predicados pred = new Predicados<>();

    @Test
    public void Conditions_testing() {
        readFile read = new readFile();
        Interpreter.variables.getVariables().put("x", 5);
        for (ArrayList<String> lispCode : read
                ._readfile("C:\\Users\\Fabi\\Documents\\GitHub\\Proyecto-LISP\\src\\Prueba.txt")) {
            cond.COND(lispCode);
        }

    }

    @Test
    public void list() {
        String l1 = pred.listCreation("(list 1 2 3 4 5 6 7 8 9 10)");
        assertEquals("(1 2 3 4 5 6 7 8 9 10)", l1);
    }

    @Test
    public void Atom_test() {
        assertTrue(pred.Atom("6"));
        assertFalse(pred.Atom("(2, 3, 5)"));
    }
}
