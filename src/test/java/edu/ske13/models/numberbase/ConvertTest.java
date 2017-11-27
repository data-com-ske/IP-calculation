package edu.ske13.models.numberbase;

import edu.ske13.constants.Base;
import edu.ske13.exception.IPException;
import edu.ske13.objects.NumberBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 03/Nov/2017 - 00:42
 */
@RunWith(Parameterized.class)
public class ConvertTest {
    @Parameterized.Parameters(name = "{index}: {0}({1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Base.Decimal, Base.Binary, "1", "1"},
                {Base.Decimal, Base.Binary, "255", "11111111"},
                {Base.Decimal, Base.Binary, "400", "110010000"},
                {Base.Binary, Base.Decimal, "1", "1"},
                {Base.Binary, Base.Decimal, "11111111", "255"},
                {Base.Binary, Base.Decimal, "110010000", "400"},
        });
    }
    
    @Parameterized.Parameter(0)
    public Base base1;
    
    @Parameterized.Parameter(1)
    public Base base2;
    
    @Parameterized.Parameter(2)
    public String input;
    
    @Parameterized.Parameter(3)
    public String expect;
    
    @Test()
    public void convertNumber() throws IPException {
        NumberBase number = new NumberBase(input, base1);
        assertEquals(base1, number.getBase());
        assertEquals(input, number.getValue());
        
        NumberBase binary = number.createNew(base2);
        assertEquals(base2, binary.getBase());
        assertEquals(expect, binary.getValue());
    }
}