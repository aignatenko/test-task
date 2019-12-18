package assertions;

import org.testng.Assert;

public class Assertion {
    public static void isTrue(boolean actual, String description) {
        Assert.assertTrue(actual, description);
    }

    public static void areEqual(Object actual, Object expected, String description) {
        Assert.assertEquals(actual, expected, description);
    }
}
