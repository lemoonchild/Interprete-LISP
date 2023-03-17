import org.junit.Test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;


public class QuoteTest {
    ArrayList<String> lispCode;
    Variables quote = new Variables<>();


    @Test
    public void quoteTesting() {
        
        assertEquals("'(prueba de quote)'", quote.Quote("(quote(prueba de quote))"));

    }
}