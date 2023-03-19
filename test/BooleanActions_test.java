
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class BooleanActions_test {
    ArrayList<String> lispCode = new ArrayList<>();
    Conditions cond = new Conditions();
    Predicados pred = new Predicados<>();

    @Test
    public void Conditions_testing() {
        readFile read = new readFile();
        Interpreter.variables.getVariables().put("number", 5);

        lispCode.add("(cond ");
        lispCode.add("((< number 0) \"Negativo\"");
        lispCode.add("((= number 0) \"Cero\")");
        lispCode.add("(t \"Más de un dígito\"))");

        cond.COND(lispCode);

    }

    @Test
    public void list() {
        String l1 = pred.listCreation("(list 1 2 3 4 5 6 7 8 9 10)");
        assertEquals("(1 2 3 4 5 6 7 8 9 10)", l1);
    }

    @Test
    public void Atom_test() {
        assertFalse(pred.Atom("(atom (2 4 5))"));
        assertTrue(pred.Atom("(atom 6)"));
        assertTrue(pred.start(5, "(atom 6)", null));
    }

    @Test
    public void MoreThan() {
        assertFalse(pred.MoreThan(10.0, 20.0));
        assertTrue(pred.MoreThan(15.0, 10.0));
        assertTrue(pred.start(8, "(> 9 7)", null));
    }

    @Test
    public void LessThan() {
        assertFalse(pred.LessThan(15.0, 6.0));
        assertTrue(pred.LessThan(30.0, 100.0));
        assertTrue(pred.start(7, "(< 7 8)", null));
    }

    @Test
    public void equals() {
        assertFalse(pred.Equal("a", "y"));
        assertTrue(pred.Equal("10", "10"));
        assertTrue(pred.start(6, "(equal 7 7)", null));
    }
}
