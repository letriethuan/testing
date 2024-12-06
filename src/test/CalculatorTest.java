package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.Calculator;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testDivideValidInputs() {
        // Test normal division
        assertEquals(2, calculator.divide(10, 5));
        assertEquals(0, calculator.divide(1, 2));
        assertEquals(-3, calculator.divide(-9, 3));
    }

    @Test
    public void testDivideByZero() {
        // Test division by zero
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testAdd() {
        assertEquals(10, calculator.add(7, 3));
        assertEquals(-2, calculator.add(-5, 3));
        assertEquals(-20, calculator.add(-5, -15));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(7, 5));
        assertEquals(-7, calculator.subtract(-5, 2));
        assertEquals(-20, calculator.subtract(-5, 15));
    }

    @Test
    public void testMultiply() {
        assertEquals(12, calculator.multiply(4, 3));
        assertEquals(-6, calculator.multiply(-3, 2));
        assertEquals(24, calculator.multiply(-6, -4));
    }
}

//     @Test
//     public void testModulo() {
//         assertEquals(1, calculator.modulo(4, 3));
//         assertEquals(2, calculator.modulo(-5, 3));
//         assertEquals(7, calculator.modulo(-63, -8));
//         assertEquals(0, calculator.modulo(-64, -8));
//     }

//     @Test
//     public void testModuloByZero() {
//         // Test division by zero
//         Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//             calculator.divide(10, 0);
//         });
//         assertEquals("Division by zero is not allowed.", exception.getMessage());

//     }
// }
