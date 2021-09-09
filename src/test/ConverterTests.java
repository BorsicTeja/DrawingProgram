package test;

import main.converters.ParameterConverter;
import main.enums.Command;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTests {

        ParameterConverter parameterConverter;

    @Before
    public void init() {
        parameterConverter = new ParameterConverter();
    }

    @Test
    public void testParameterConverter() {
        char a = 'a';
        int aAscii = 97;
        int aAsciiFalse = 12;
        String commandB = "B";
        String[] parameters = new String[]{commandB, "10","3", String.valueOf(a)};

        assertTrue(aAscii == parameterConverter.convertParameters(commandB, parameters)[2]);
        assertFalse(aAsciiFalse == parameterConverter.convertParameters(commandB, parameters)[2]);
    }
}
