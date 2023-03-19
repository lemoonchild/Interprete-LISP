
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

public class OperationTest {
    ArrayList<String> lispCode;
    Operations arithOp = new Operations();

    public HashMap<String, Double> addToHasMap() {

        HashMap<String, Double> variables = new HashMap<>();

        variables.put("variable", 2.0);
        variables.put("variable2", 4.0);

        return variables;

    }

    @Test
    public void opTesting() {

        assertEquals(7.0, arithOp.evaluateOnlyNumbers(("( + 3 4 )")));

    }

    @Test
    public void opTestingVariable() {

        assertEquals(6.0, arithOp.evaluateWithVar(("( + variable 4 )"), addToHasMap()));

    }

    @Test
    public void opTesting_2Variable() {

        assertEquals(6.0, arithOp.evaluateWithVar(("( + variable variable2 )"), addToHasMap()));

    }
}
