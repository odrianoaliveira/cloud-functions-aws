package tech.adriano.cloudfunctions.fn;

import org.junit.Test;
import tech.adriano.cloudfunctions.fn.FactorialFn;

import static org.junit.Assert.assertEquals;

public class FactorialFnTest {

    @Test
    public void whenZeroThenOne() {
        assertEquals(Integer.valueOf(1), FactorialFn.factorial().apply(0));
    }

    @Test
    public void whenFiveThenHundredTwenty() {
        assertEquals(Integer.valueOf(120), FactorialFn.factorial().apply(5));
    }
}