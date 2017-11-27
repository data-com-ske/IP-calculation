package edu.ske13.models.numberbase;

import edu.ske13.constants.Base;
import edu.ske13.exception.IPException;
import edu.ske13.objects.NumberBase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 05/Nov/2017 - 21:59
 */
@RunWith(JUnitParamsRunner.class)
public class OperationTest {
    
    private static Object[] binaryData(String... expected) {
        if (expected.length != 4) throw new RuntimeException("wrong initial test");
        return new Object[]{
                new Object[]{"1001", "0110", expected[0]},
                new Object[]{"11", "11", expected[1]},
                new Object[]{"00110011", "11000111", expected[2]},
                new Object[]{"111100010101", "101111011010", expected[3]},
        };
    }
    
    private static Object[] decimalData(String... expected) {
        if (expected.length != 4) throw new RuntimeException("wrong initial test");
        return new Object[]{
                new Object[]{"24", "31", expected[0]},
                new Object[]{"5", "1", expected[1]},
                new Object[]{"166", "231", expected[2]},
                new Object[]{"412", "550", expected[3]},
        };
    }
    
    private static Object[] b2bAndTestCase() {
        return binaryData("0", "11", "11", "101100010000");
    }
    
    private static Object[] b2bOrTestCase() {
        return binaryData("1111", "11", "11110111", "111111011111");
    }
    
    private static Object[] b2bXorTestCase() {
        return binaryData("1111", "0", "11110100", "10011001111");
    }
    
    private static Object[] b2dAndTestCase() {
        return binaryData("0", "3", "3", "2832");
    }
    
    private static Object[] b2dOrTestCase() {
        return binaryData("15", "3", "247", "4063");
    }
    
    private static Object[] b2dXorTestCase() {
        return binaryData("15", "0", "244", "1231");
    }
    
    private static Object[] d2dAndTestCase() {
        return decimalData("24", "1", "166", "4");
    }
    
    private static Object[] d2dOrTestCase() {
        return decimalData("31", "5", "231", "958");
    }
    
    private static Object[] d2dXorTestCase() {
        return decimalData("7", "4", "65", "954");
    }
    
    private static Object[] d2bAndTestCase() {
        return decimalData("11000", "1", "10100110", "100");
    }
    
    private static Object[] d2bOrTestCase() {
        return decimalData("11111", "101", "11100111", "1110111110");
    }
    
    private static Object[] d2bXorTestCase() {
        return decimalData("111", "100", "1000001", "1110111010");
    }
    
    @Test()
    @Parameters(method = "b2bAndTestCase")
    @TestCaseName("{method} ({index}): {0} and {1} => {2}")
    public void andB2BTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Binary, number2, Base.Binary, expected, (t1, t2) -> t1.and(t2, Base.Binary));
    }
    
    @Test()
    @Parameters(method = "b2bOrTestCase")
    @TestCaseName("{method} ({index}): {0} or {1} => {2}")
    public void orB2BTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Binary, number2, Base.Binary, expected, (t1, t2) -> t1.or(t2, Base.Binary));
    }
    
    @Test()
    @Parameters(method = "b2bXorTestCase")
    @TestCaseName("{method} ({index}): {0} xor {1} => {2}")
    public void xorB2BTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Binary, number2, Base.Binary, expected, (t1, t2) -> t1.xor(t2, Base.Binary));
    }
    
    @Test()
    @Parameters(method = "b2dAndTestCase")
    @TestCaseName("{method} ({index}): {0} and {1} => {2}")
    public void andB2DTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Binary, number2, Base.Binary, expected, (t1, t2) -> t1.and(t2, Base.Decimal));
    }
    
    @Test()
    @Parameters(method = "b2dOrTestCase")
    @TestCaseName("{method} ({index}): {0} or {1} => {2}")
    public void orB2DTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Binary, number2, Base.Binary, expected, (t1, t2) -> t1.or(t2, Base.Decimal));
    }
    
    @Test()
    @Parameters(method = "b2dXorTestCase")
    @TestCaseName("{method} ({index}): {0} xor {1} => {2}")
    public void xorB2DTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Binary, number2, Base.Binary, expected, (t1, t2) -> t1.xor(t2, Base.Decimal));
    }
    
    @Test()
    @Parameters(method = "d2dAndTestCase")
    @TestCaseName("{method} ({index}): {0} and {1} => {2}")
    public void andD2DTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Decimal, number2, Base.Decimal, expected, (t1, t2) -> t1.and(t2, Base.Decimal));
    }
    
    @Test()
    @Parameters(method = "d2dOrTestCase")
    @TestCaseName("{method} ({index}): {0} or {1} => {2}")
    public void orD2DTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Decimal, number2, Base.Decimal, expected, (t1, t2) -> t1.or(t2, Base.Decimal));
    }
    
    @Test()
    @Parameters(method = "d2dXorTestCase")
    @TestCaseName("{method} ({index}): {0} xor {1} => {2}")
    public void xorD2DTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Decimal, number2, Base.Decimal, expected, (t1, t2) -> t1.xor(t2, Base.Decimal));
    }
    
    @Test()
    @Parameters(method = "d2bAndTestCase")
    @TestCaseName("{method} ({index}): {0} and {1} => {2}")
    public void andD2BTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Decimal, number2, Base.Decimal, expected, (t1, t2) -> t1.and(t2, Base.Binary));
    }
    
    @Test()
    @Parameters(method = "d2bOrTestCase")
    @TestCaseName("{method} ({index}): {0} or {1} => {2}")
    public void orD2BTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Decimal, number2, Base.Decimal, expected, (t1, t2) -> t1.or(t2, Base.Binary));
    }
    
    @Test()
    @Parameters(method = "d2bXorTestCase")
    @TestCaseName("{method} ({index}): {0} xor {1} => {2}")
    public void xorD2BTest(String number1, String number2, String expected) throws IPException {
        test(number1, Base.Decimal, number2, Base.Decimal, expected, (t1, t2) -> t1.xor(t2, Base.Binary));
    }
    
    /**
     * test utils
     *
     * @param number1
     * @param base1
     * @param number2
     * @param base2
     * @param result
     * @param op
     */
    public static void test(String number1, Base base1, String number2, Base base2, String result, Operation<NumberBase> op) {
        NumberBase b1 = new NumberBase(number1, base1);
        NumberBase b2 = new NumberBase(number2, base2);
        
        assertEquals(result, op.calculate(b1, b2).getValue());
    }
    
    private interface Operation<T> {
        T calculate(T t1, T t2);
    }
}
