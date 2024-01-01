package de.krummacker.textblocks;

public class TextBlocks {

    public static String getMultilineTextBlock(String parameter) {
        return """
                This is a text block.
                It has multiple lines.
                They work like HERE documents.
                You can even use parameters: %s
                And this is the last line.""".formatted(parameter);
    }

    public static void main(String[] args) {
        System.out.println(getMultilineTextBlock(args[0]));
    }
}
