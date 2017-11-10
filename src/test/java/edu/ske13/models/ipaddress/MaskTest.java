package edu.ske13.models.ipaddress;

import edu.ske13.exception.IPException;
import edu.ske13.exception.NotImplementedException;
import edu.ske13.objects.IPAddress;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 21:08
 */
@RunWith(JUnitParamsRunner.class)
public class MaskTest {
    private String[][] testdata() {
        return new String[][]{
                {"2.1.0.0", "255.0.0.0"},
                {"13.0.0.1", "255.0.0.0"},
                {"111.123.32.2", "255.0.0.0"},
                {"130.23.1.0", "255.255.0.0"},
                {"190.255.255.255", "255.255.0.0"},
                {"192.0.0.0", "255.255.255.0"},
                {"201.210.0.0", "255.255.255.0"},
                {"225.0.0.0", null},
                {"245.1.0.0", null},
                
                {"10.1.2.3", "255.0.0.0"},
                {"10.245.255.0", "255.0.0.0"},
                {"172.16.0.0", "255.240.0.0"},
                {"172.30.255.0", "255.240.0.0"},
                {"192.168.0.0", "255.255.0.0"},
                {"192.168.200.0", "255.255.0.0"},
        };
    }
    
    @Test()
    @Parameters(method = "testdata")
    @TestCaseName("{method}({index}): ip {0} mask should equals {1}")
    public void test_getting_mask(String... args) throws IPException {
        try {
            IPAddress a = new IPAddress(args[0]);
            assertEquals(args[1], a.getDefaultSubnetMask().toString());
        } catch (ClassCastException | NotImplementedException e) {
            fail(e.getMessage());
        }
    }
}
