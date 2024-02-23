package org.joychou.util;

public class InputSanitizer {

    public static String sanitizeForCRLF(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\r", "").replaceAll("\n", "");
    }
}
