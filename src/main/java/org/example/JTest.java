package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JTest {
    @Test
    void testNull(){
        String nullStr = null;
        assertThrows(
                NullPointerException.class,
                () -> Integer.decode(nullStr)
        );
    }

    @Test
    void testZeroLength(){
        String emptyString = "";
        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(emptyString)
        );
    }

    @Test
    void testOnlyNegativeSign(){
        String negative = "-";
        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(negative)
        );
    }

    @Test
    void testNotANumber()
    {
        String nan = "asd";
        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(nan)
        );
    }

    @Test
    void testChar()
    {
        String nan = "1234c123";
        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(nan)
        );
    }

    @Test
    void testOverflow()
    {
        String lMax = String.valueOf((long)Integer.MAX_VALUE + 1);
        String lMin = String.valueOf((long)Integer.MIN_VALUE - 1);

        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(lMax)
        );

        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(lMin)
        );
    }

    @Test
    void testPositiveNumber()
    {
        String number = "123";
        int res = Integer.decode(number);

        assertEquals(123, res);
    }

    @Test
    void testNegativeNumber()
    {
        String number = "-123";
        int res = Integer.decode(number);

        assertEquals(-123, res);
    }
}
