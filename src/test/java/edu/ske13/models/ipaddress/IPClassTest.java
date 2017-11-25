package edu.ske13.models.ipaddress;

import edu.ske13.constants.IPClass;
import edu.ske13.constants.IPClassable;
import edu.ske13.constants.IPPrivateClass;
import edu.ske13.exception.IPException;
import edu.ske13.exception.NotImplementedException;
import edu.ske13.objects.IPAddress;
import edu.ske13.utils.IPUtils;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/**
 * Testing, follow <a href="http://www.vlsm-calc.net/ipclasses.php">ip class</a> rules.
 *
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 19:58
 */
@RunWith(JUnitParamsRunner.class)
public class IPClassTest {
    private IPAddress a;
    private IPClass c;
    
    private Object string_testData() {
        return new Object[][]{
                // default ip
                {"2.1.0.0", IPClass.ClassA},
                {"13.0.0.1", IPClass.ClassA},
                {"111.123.32.2", IPClass.ClassA},
                {"130.23.1.0", IPClass.ClassB},
                {"190.255.255.255", IPClass.ClassB},
                {"192.0.0.0", IPClass.ClassC},
                {"201.210.0.0", IPClass.ClassC},
                {"225.0.0.0", IPClass.ClassD},
                {"245.1.0.0", IPClass.ClassE},
                // private ip
                {"10.1.2.3", IPPrivateClass.PrivateClassA},
                {"10.245.255.0", IPPrivateClass.PrivateClassA},
                {"172.16.0.0", IPPrivateClass.PrivateClassB},
                {"172.30.255.0", IPPrivateClass.PrivateClassB},
                {"192.168.0.0", IPPrivateClass.PrivateClassC},
                {"192.168.200.0", IPPrivateClass.PrivateClassC},
        };
    }
    
    private Object separate_testData() {
        return new Object[][]{
                // separate default ip
                {2, 1, 0, 0, IPClass.ClassA},
                {"13", "0", "0", "1", IPClass.ClassA},
                {111, 123, 32, 2, IPClass.ClassA},
                {"130", "23", "1", "0", IPClass.ClassB},
                {190, 255, 255, 255, IPClass.ClassB},
                {"192", "0", "0", "0", IPClass.ClassC},
                {201, 210, 0, 0, IPClass.ClassC},
                {"225", "0", "0", "0", IPClass.ClassD},
                {245, 1, 0, 0, IPClass.ClassE},
                // separate private ip
                {10, 1, 2, 3, IPPrivateClass.PrivateClassA},
                {"10", "245", "255", "0", IPPrivateClass.PrivateClassA},
                {172, 16, 0, 0, IPPrivateClass.PrivateClassB},
                {"172", "30", "255", "0", IPPrivateClass.PrivateClassB},
                {192, 168, 0, 0, IPPrivateClass.PrivateClassC},
                {"192", "168", "200", "0", IPPrivateClass.PrivateClassC},
        };
    }
    
    @Test()
    @Parameters(method = "string_testData")
    @TestCaseName("{method}({index}): create {0}, Class is {1}")
    public void test_create_ip_default(String ip, IPClassable clazz) throws IPException {
        try {
            a = new IPAddress(ip);
            assertEquals(clazz, a.getIPClass());
        } catch (ClassCastException | NotImplementedException e) {
            fail(e.getMessage());
        }
    }
    
    @Test()
    @Parameters(method = "separate_testData")
    @TestCaseName("{method}({index}): create {0}.{1}.{2}.{3}, Class is {4}")
    public void test_create_ip_separate(Object a1, Object a2, Object a3, Object a4, IPClassable clazz) throws IPException {
        try {
            if (a1 instanceof String) a = new IPAddress((String) a1, (String) a2, (String) a3, (String) a4);
            else a = new IPAddress((Integer) a1, (Integer) a2, (Integer) a3, (Integer) a4);
            assertEquals(clazz, a.getIPClass());
        } catch (ClassCastException | NotImplementedException e) {
            fail(e.getMessage());
        }
    }
    
    @Test()
    @Parameters(method = "string_testData")
    @TestCaseName("{method}({index}): create {0}, Class is {1}")
    public void test_create_ip_utils_default(String ip, IPClassable clazz) throws IPException {
        try {
            a = IPUtils.getIPAddress(ip);
            assertEquals(clazz, a.getIPClass());
        } catch (ClassCastException | NotImplementedException e) {
            fail(e.getMessage());
        }
    }
    
    @Test()
    @Parameters(method = "separate_testData")
    @TestCaseName("{method}({index}): create {0}.{1}.{2}.{3}, Class is {4}")
    public void test_create_ip_utils_separate(Object a1, Object a2, Object a3, Object a4, IPClassable clazz) throws IPException {
        try {
            if (a1 instanceof String) a = IPUtils.getIPAddress((String) a1, (String) a2, (String) a3, (String) a4);
            else a = IPUtils.getIPAddress((Integer) a1, (Integer) a2, (Integer) a3, (Integer) a4);
            assertEquals(clazz, a.getIPClass());
        } catch (ClassCastException | NotImplementedException e) {
            fail(e.getMessage());
        }
    }
}
