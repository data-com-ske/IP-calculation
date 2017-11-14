package edu.ske13.models.ipaddress;

import edu.ske13.exception.IPException;
import edu.ske13.exception.NotImplementedException;
import edu.ske13.objects.IPAddress;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 14/Nov/2017 - 22:24
 */
@RunWith(JUnitParamsRunner.class)
public class ValidateTest {
    private Object[][] data() {
        return new Object[][]{
                // case true
                {"2.1.0.0", true},
                {"100.1.0.0", true},
                {"10.1.1.0", true},
                {"103.132.113.312", true},
                {"123.123.123.123", true},
                {"123.123.123.123", true},
                {"245.255.0.1", true},
                {"255.255.255.255", true},
                {"155.0.00.000", true},
                {"155.0.001.000", true},
                {"155.0.001.0004", true},
                {"155.00014.001.000000012", true},
                // case zero ip
                {"0.0.0.0", true},
                {"0.0.0.1", false},
                {"0.1.0.0", false},
                {"0.0.1.0", false},
                {"0.255.255.255", false},
                // case incomplete ip
                {"2.1.0", false},
                {"2.1.0.", false},
                {"2.1..0", false},
                {"2..10.", false},
                {".2.1..0.", false},
                {"2.10.1.1.", false},
                {".12.1.4.0.", false},
                {".120.123.150.0", false},
                {"2", false},
                {".127.1..0", false},
                {".", false},
                {".1.", false},
                {"", false},
                // case invalid character
                {"123,123,123,123", false},
                {"123.123.123.123$", false},
                {"ASDF.f.123.123$", false},
                {"123.123.123.123#", false},
                {"@123.123.123.123#", false},
                {"@123.123.123.123*", false},
                {"-123.-123.123.123", false},
                {"-123.123.123.123", false},
                // case exceed ip number [1]
                {"-1.0.0.0", false},
                {"257.0.0.0", false},
                // case exceed ip number [2]
                {"255.255.255.256", false},
                {"255.255.256.255", false},
                {"255.256.255.255", false},
                {"256.255.255.255", false},
                {"255.255.256.257", false},
                {"258.257.256.255", false},
        };
    }
    
    @Test()
    @Parameters(method = "data")
    @TestCaseName("{method}({index}): ip {0}, correction is {1}")
    public void test_correctness(String ip, Boolean expected) throws IPException {
        try {
            IPAddress a = new IPAddress(String.valueOf(ip));
            if (expected) assertTrue(a.isCorrect());
            else assertFalse(a.isCorrect());
        } catch (ClassCastException | NotImplementedException e) {
            fail(e.getMessage());
        }
    }
}
