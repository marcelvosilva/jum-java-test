package com.exercise;

import com.exercise.utils.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaApplicationTests {

    @Test
    public void testNumberValidation() {
        assertEquals(true, ValidateNumber.validateNumber("(237) 697151594"));
        assertEquals(false, ValidateNumber.validateNumber("(237) 6A0311634"));
        assertEquals(true, ValidateNumber.validateNumber("(251) 914701723"));
        assertEquals(false, ValidateNumber.validateNumber("(251) 9773199405"));
        assertEquals(true, ValidateNumber.validateNumber("(212) 698054317"));
        assertEquals(false, ValidateNumber.validateNumber("(212) 6007989253"));
        assertEquals(true, ValidateNumber.validateNumber("(258) 847651504"));
        assertEquals(false, ValidateNumber.validateNumber("(258) 042423566"));
        assertEquals(true, ValidateNumber.validateNumber("(256) 775069443"));
        assertEquals(false, ValidateNumber.validateNumber("(256) 7503O6263"));
    }
}