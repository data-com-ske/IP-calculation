package edu.ske13.models.ipaddress;

import edu.ske13.exception.IPException;
import edu.ske13.objects.IPAddress;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 21:19
 */
@RunWith(JUnitParamsRunner.class)
public class IPTypeTest {
    @Test()
    @Parameters({
                        "127.0.0.1, true",
                        "127.25.255.255, true",
                        "127.123.111.9, true",
                        "127.0.0.2, true",
                        "128.0.0.0, false",
                        "126.255.255.255, false",
                        "123.123.123.123, false",
                        "255.255.255.255, false",
    })
    @TestCaseName("ip {0} is loop back, in't it? -- ans: {1} ({index})")
    public void test_ip_loopback(String raw, boolean isLoopBack) throws IPException {
        test_ip_type(new IPAddress(raw)::isLoopback, isLoopBack);
    }
    
    @Test()
    @Parameters({
                        "10.0.0.0, true",
                        "10.255.255.254, true",
                        "10.255.255.255, true",
                        "9.0.0.0, false",
                        "11.255.255.254, false",
                        "11.255.255.255, false",
                        "172.16.0.0, true",
                        "172.16.0.1, true",
                        "172.30.255.255, true",
                        "172.31.0.0, true",
                        "172.31.0.1, true",
                        "172.31.255.255, true",
                        "172.15.255.255, false",
                        "172.14.255.254, false",
                        "172.32.0.0, false",
                        "172.32.255.255, false",
                        "192.168.0.0, true",
                        "192.168.0.1, true",
                        "192.168.255.255, true",
                        "192.168.255.254, true",
                        "192.168.254.254, true",
                        "191.255.255.255, false",
                        "191.255.255.254, false",
                        "193.0.0.0, false",
                        "193.0.0.1, false",
                        "193.255.255.254, false",
                        "193.255.255.255, false",
    })
    @TestCaseName("ip {0} is private, in't it? -- ans: {1} ({index})")
    public void test_ip_private(String raw, boolean isPrivate) throws IPException {
        test_ip_type(new IPAddress(raw)::isPrivate, isPrivate);
    }
    
    @Test()
    @Parameters({
                        "255.255.255.255, true",
                        "255.0.0.0, true",
                        "255.125.0.0, true",
                        "255.240.0.0, true",
                        "255.255.160.0, true",
                        "126.255.255.255, false",
                        "55.123.123.123, false",
                        "25.255.255.0, false",
                        "1.255.255.0, false",
    })
    @TestCaseName("ip {0} is subnet mask, in't it? -- ans: {1} ({index})")
    public void test_ip_mask(String raw, boolean isMask) throws IPException {
        test_ip_type(new IPAddress(raw)::isSubnetMask, isMask);
    }
    
    private static void test_ip_type(Action act, boolean expected) {
        assertEquals(expected, act.test());
    }
    
    private interface Action {
        boolean test();
    }
}
