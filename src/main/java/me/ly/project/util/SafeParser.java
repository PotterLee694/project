package me.ly.project.util;

public class SafeParser {
    public static Long parseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return 0L;
        } finally {
        }
    }
}
