package utils;

import java.security.SecureRandom;

public final class DataGenerator {
    private static final String letters = "abcdefghijklmnopqrstuvwxyz";
    private static final String digits = "0123456789";
    private static SecureRandom rnd = new SecureRandom();

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(letters.charAt(rnd.nextInt(letters.length())));
        return sb.toString();
    }

    public static String randomEmail() {
        return randomString(8) + "@" + randomString(5) + ".nl";
    }
}
