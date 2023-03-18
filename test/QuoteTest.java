import org.junit.Test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


public class QuoteTest {
    ArrayList<String> lispCode;
    Variables quote = new Variables<>();


    @Test
    public void quoteTestingwithApostrophe() {
        
        assertEquals("'(prueba de quote)'", quote.Quote("('(prueba de quote))"));

    }
    @Test
    public void quoteTestingwithQuoteText() {
        
        assertEquals("'([1 2 3 4 5])'", quote.Quote("(quote([1 2 3 4 5]))"));

    }
}