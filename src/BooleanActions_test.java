
import org.junit.Test;
import org.junit.jupiter.engine.execution.ConditionEvaluator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;

public class BooleanActions_test {
    ArrayList<String> lispCode;
    Conditions cond = new Conditions();
    Predicados pred = new Predicados<>();

    public BooleanActions_test() {
        lispCode = new ArrayList<>();
        lispCode.add("(cond");
        lispCode.add("((> 3 10) 'x es mayor que 10')");
        lispCode.add("((= 8 5) 'x es igual a 5')");
        lispCode.add("((< 1 0) 'x es menor que 0')");
        lispCode.add("(t 'x es mayor o igual a 0, pero menor o igual que 10'))");
    }

    @Test
    public void Conditions_testing() {
        cond.COND(lispCode);
    }

    @Test
    public void name() {
        readFile read = new readFile();
        Interpreter.variables.getVariables().put("x", 5);
        for (ArrayList<String> lispCode : read
                ._readfile("C:\\Users\\Fabi\\Documents\\GitHub\\Proyecto-LISP\\src\\Prueba.txt")) {
            cond.COND(lispCode);
        }

    }

    @Test
    public void list() {
        LinkedList<String> l1 = pred.listCreation(lispCode);
        System.out.println(l1);
    }

    @Test
    public void Atom_test() {
        assertTrue(pred.Atom("6"));
        assertFalse(pred.Atom("(2, 3, 5)"));
    }
}
