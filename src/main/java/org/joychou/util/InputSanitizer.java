package org.joychou.util;

public class InputSanitizer {

    public static String sanitizeForHttpHeader(String input) {
        if (input == null) {
            return null;
        }
        return input.replace("\r", "").replace("\n", "");
    }
}
