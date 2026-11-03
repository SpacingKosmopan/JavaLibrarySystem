package Classes;

import java.util.Map;

public class ConsoleFormatter {
    // Reset
    public static final String RESET = "\u001B[0m";

    // Style
    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String BLINK = "\u001B[5m";
    public static final String REVERSE = "\u001B[7m";
    public static final String HIDDEN = "\u001B[8m";

    // Standard text colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String ORANGE = "\u001B[38;2;255;165;0m";

    // Bright text colors
    public static final String BRIGHT_BLACK = "\u001B[90m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_PURPLE = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";

    // Background colors
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    public static final String ORANGE_BACKGROUND = "\u001B[48;2;255;165;0m";

    // Bright background colors
    public static final String BRIGHT_BLACK_BACKGROUND = "\u001B[100m";
    public static final String BRIGHT_RED_BACKGROUND = "\u001B[101m";
    public static final String BRIGHT_GREEN_BACKGROUND = "\u001B[102m";
    public static final String BRIGHT_YELLOW_BACKGROUND = "\u001B[103m";
    public static final String BRIGHT_BLUE_BACKGROUND = "\u001B[104m";
    public static final String BRIGHT_PURPLE_BACKGROUND = "\u001B[105m";
    public static final String BRIGHT_CYAN_BACKGROUND = "\u001B[106m";
    public static final String BRIGHT_WHITE_BACKGROUND = "\u001B[107m";

    public static void flush() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /*public static final Map<Character, String> TOKENS = Map.of(
            '/', "/",
            'r', RED,
            'g', GREEN,
            'b', BLUE,
            'y', YELLOW,
            'f', RED_BCKG,
            'n', BLACK_BCKG,
            '0', RESET,
            'B', BOLD
    );*/

    /*public static String deregex(String textToFormat) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < textToFormat.length(); i++) {
            char ch = textToFormat.charAt(i);
            if (ch == '/' && i + 1 < textToFormat.length()) {
                ch = textToFormat.charAt(++i);
                output.append(TOKENS.getOrDefault(ch, ""));
            } else output.append(ch);
        }
        return output.toString();
    }*/

    String text;

    public ConsoleFormatter() {
        text = "";
    }

    public static ConsoleFormatter create() {
        return new ConsoleFormatter();
    }

    public ConsoleFormatter red() {
        this.text += RED;
        return this;
    }

    public ConsoleFormatter reset() {
        this.text += RESET;
        return this;
    }

    public ConsoleFormatter text(String text) {
        this.text += text;
        return this;
    }

    @Override
    public String toString() {
        return text;
    }

    public static void space(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(" ");
        }
    }

    public static String getSpace(int amount) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            output.append(" ");
        }
        return output.toString();
    }

    public static void chars(char c, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(c);
        }
    }

    public static String getChars(char c, int amount) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            output.append(c);
        }
        return output.toString();
    }
}