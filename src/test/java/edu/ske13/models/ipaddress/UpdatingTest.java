package edu.ske13.models.ipaddress;

import edu.ske13.exception.IPException;
import edu.ske13.exception.NotImplementedException;
import edu.ske13.objects.IPAddress;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 14/Nov/2017 - 22:58
 */
@RunWith(JUnitParamsRunner.class)
public class UpdatingTest {
    private enum Type {
        STRING,
        STRING_ARRAY,
        INT_ARRAY;
    }
    
    private Object[][] dataString() {
        return new Object[][][]{
            // case string
            {
                
                {
                    Type.STRING,
                    "100.1.0.0"
                }, {
                    Type.STRING,
                    "100.1.0.1"
                }
            },
            {
                {
                    Type.STRING,
                    "10.1.1.0"
                }, {
                    Type.STRING,
                    "100.100.100.100"
                }
            },
            {
                {
                    Type.STRING,
                    "321.132.213.221"
                }, {
                    Type.STRING,
                    "112.312.231.132"
                }
            },
            {
                {
                    Type.STRING,
                    "245.255.0.1"
                }, {
                    Type.STRING,
                    "255.255.255.255"
                }
            },
            {
                {
                    Type.STRING,
                    "155.0.001.0004"
                }, {
                    Type.STRING,
                    "156.1.002.0005"
                }
            },
        };
    }
    
    private Object[][] dataStringArray() {
        return new Object[][][]{
            // case string[]
            {
                {
                    Type.STRING_ARRAY,
                    "100","1","0","0"
                }, {
                    Type.STRING_ARRAY,
                    "100","1","0","1"
                }
            },
            {
                {
                    Type.STRING_ARRAY,
                    "10","1","1","0"
                }, {
                    Type.STRING_ARRAY,
                    "100","100","100","100"
                }
            },
            {
                {
                    Type.STRING_ARRAY,
                    "321","132","213","221"
                }, {
                    Type.STRING_ARRAY,
                    "112","312","231","132"
                }
            },
            {
                {
                    Type.STRING_ARRAY,
                    "245","255","0","1"
                }, {
                    Type.STRING_ARRAY,
                    "255","255","255","255"
                }
            },
            {
                {
                    Type.STRING_ARRAY,
                    "155","0","001","0004"
                }, {
                    Type.STRING_ARRAY,
                    "156","1","002","0005"
                }
            },
        };
    }
    
    private Object[][] dataIntArray() {
        return new Object[][][]{
            // case int[]
            {
                {
                    Type.INT_ARRAY,
                    100,1,0,0
                }, {
                    Type.INT_ARRAY,
                    100,1,0,1
                }
            },
            {
                {
                    Type.INT_ARRAY,
                    10,1,1,0
                }, {
                    Type.INT_ARRAY,
                    100,100,100,100
                }
            },
            {
                {
                    Type.INT_ARRAY,
                    321,132,213,221
                }, {
                    Type.INT_ARRAY,
                    112,312,231,132
                }
            },
            {
                {
                    Type.INT_ARRAY,
                    245,255,0,1
                }, {
                    Type.INT_ARRAY,
                    255,255,255,255
                }
            },
            {
                {
                    Type.INT_ARRAY,
                    155,0,001,0004
                }, {
                    Type.INT_ARRAY,
                    156,1,002,0005
                }
            },
        };
    }
    
    private Object[][] dataMix() {
        return new Object[][][]{
            // case int[]
            {
                {
                    Type.STRING_ARRAY,
                    "155","0","001","0004"
                }, {
                    Type.INT_ARRAY,
                    100,1,0,1
                }
            },
            {
                {
                    Type.STRING,
                    "100.100.100.100"
                }, {
                    Type.INT_ARRAY,
                    100,100,100,100
                }
            },
            {
                {
                    Type.STRING_ARRAY,
                    "155","0","001","0004"
                }, {
                    Type.STRING,
                    "100.123.0.0"
                }
            },
            {
                {
                    Type.INT_ARRAY,
                    245,255,0,1
                }, {
                    Type.STRING_ARRAY,
                    "155","0","001","0004"
                }
            },
            {
                {
                    Type.INT_ARRAY,
                    155,123,112,1
                }, {
                    Type.STRING,
                    "155.123.111.0"
                }
            },
            {
                {
                    Type.STRING,
                    "234.211.000.00"
                }, {
                    Type.STRING_ARRAY,
                    "234","231","1","10"
                }
            },
        };
    }
    
    @Test()
    @Parameters(method = "dataString")
    @TestCaseName("{method}({index}): {0}, change to {1}")
    public void test_updating_string(String[]... args) throws IPException {
        IPAddress a = new IPAddress(String.valueOf(args[0][1]));
        assertEquals(a.toString(), args[0][1]);
        a.updateIP(String.valueOf(args[1][1]));
        assertEquals(a.toString(), args[1][1]);
    }
    
    @Test()
    @Parameters(method = "dataStringArray")
    @TestCaseName("{method}({index}): {0}, change to {1}")
    public void test_updating_string_array(Object[]... args) throws IPException {
        IPAddress a = new IPAddress(
            String.valueOf(args[0][1]),
            String.valueOf(args[0][2]),
            String.valueOf(args[0][3]),
            String.valueOf(args[0][4])
        );
        assertEquals(a.toString(), String.format("%s.%s.%s.%s",args[0][1],args[0][2],args[0][3],args[0][4]));
        a.updateIP(
            String.valueOf(args[1][1]),
            String.valueOf(args[1][2]),
            String.valueOf(args[1][3]),
            String.valueOf(args[1][4])
        );
        assertEquals(a.toString(), String.format("%s.%s.%s.%s",args[1][1],args[1][2],args[1][3],args[1][4]));
    }
    
    @Test()
    @Parameters(method = "dataIntArray")
    @TestCaseName("{method}({index}): {0}, change to {1}")
    public void test_updating_int_array(Object[]... args) throws IPException {
        IPAddress a = new IPAddress(
            Integer.valueOf(String.valueOf(args[0][1])),
            Integer.valueOf(String.valueOf(args[0][2])),
            Integer.valueOf(String.valueOf(args[0][3])),
            Integer.valueOf(String.valueOf(args[0][4]))
        );
        assertEquals(a.toString(), String.format("%s.%s.%s.%s",args[0][1],args[0][2],args[0][3],args[0][4]));
        a.updateIP(
            Integer.valueOf(String.valueOf(args[1][1])),
            Integer.valueOf(String.valueOf(args[1][2])),
            Integer.valueOf(String.valueOf(args[1][3])),
            Integer.valueOf(String.valueOf(args[1][4]))
        );
        assertEquals(a.toString(), String.format("%s.%s.%s.%s",args[1][1],args[1][2],args[1][3],args[1][4]));
    }
    
    @Test()
    @Parameters(method = "dataMix")
    @TestCaseName("{method}({index}): {0}, change to {1}")
    public void test_updating_mix(Object[]... args) throws IPException {
        try {
            IPAddress a = null;
            switch (Type.class.cast(args[0][0])) {
                case STRING:
                    a = new IPAddress(String.valueOf(args[0][1]));
                    assertEquals(a.toString(), args[0][1]);
                    break;
                case STRING_ARRAY:
                    a = new IPAddress(
                            String.valueOf(args[0][1]),
                            String.valueOf(args[0][2]),
                            String.valueOf(args[0][3]),
                            String.valueOf(args[0][4])
                    );
                    assertEquals(a.toString(), String.format("%s.%s.%s.%s",args[0][1],args[0][2],args[0][3],args[0][4]));
                    break;
                case INT_ARRAY:
                    a = new IPAddress(
                            Integer.valueOf(String.valueOf(args[0][1])),
                            Integer.valueOf(String.valueOf(args[0][2])),
                            Integer.valueOf(String.valueOf(args[0][3])),
                            Integer.valueOf(String.valueOf(args[0][4]))
                    );
                    assertEquals(a.toString(), String.format("%s.%s.%s.%s",args[0][1],args[0][2],args[0][3],args[0][4]));
                    break;
            }
            
            switch (Type.class.cast(args[1][0])) {
                case STRING:
                    a.updateIP(String.valueOf(args[1][1]));
                    assertEquals(a.toString(), args[1][1]);
                    break;
                case STRING_ARRAY:
                    a.updateIP(
                            String.valueOf(args[1][1]),
                            String.valueOf(args[1][2]),
                            String.valueOf(args[1][3]),
                            String.valueOf(args[1][4])
                    );
                    assertEquals(a.toString(), String.format("%s.%s.%s.%s",args[1][1],args[1][2],args[1][3],args[1][4]));
                    break;
                case INT_ARRAY:
                    a.updateIP(
                            Integer.valueOf(String.valueOf(args[1][1])),
                            Integer.valueOf(String.valueOf(args[1][2])),
                            Integer.valueOf(String.valueOf(args[1][3])),
                            Integer.valueOf(String.valueOf(args[1][4]))
                    );
                    assertEquals(a.toString(), String.format("%s.%s.%s.%s",args[1][1],args[1][2],args[1][3],args[1][4]));
                    break;
            }
        } catch (ClassCastException | NotImplementedException e) {
            fail(e.getMessage());
        }
    }
}
