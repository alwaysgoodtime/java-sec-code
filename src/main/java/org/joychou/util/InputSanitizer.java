package org.joychou.util;

public final class InputSanitizer {

    private InputSanitizer() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String sanitizeForHttpHeader(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\r", "").replaceAll("\n", "");
    }
}
