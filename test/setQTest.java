import org.junit.Test; 

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;


public class setQTest {

    Variables setQ = new Variables<>();

    
    HashMap<String,Double> hashMap = new HashMap<>(); 
    
    public HashMap<String,Double> addToHashMap(){

        hashMap.put("x", 5.0); 
        setQ.setVariables(hashMap);

        return hashMap; 
    }

    @Test
    public void setQTest() {
        
        assertEquals(5.0, addToHashMap().get("x"));

    }


}