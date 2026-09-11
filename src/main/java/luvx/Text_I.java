package luvx;

import luvx.composable.HasEscapableTextContent;
import luvx.ftype.Text_T;

/**
 * Interface for plain text nodes.
 * Text nodes contain plain text that needs HTML character escaping during rendering.
 */
public interface Text_I<I extends Text_I<I>>
    extends StringNode_I<I>, HasEscapableTextContent<I> {

    /**
     * Returns the whole text content with all whitespace preserved.
     * Includes all newlines, tabs, multiple spaces as-is.
     * Mimics JSoup's TextNode.getWholeText() behavior.
     * Implementations must override this to provide the raw text.
     */
    String wholeText();

    /**
     * Returns the normalized text content (whitespace collapsed).
     * Multiple spaces/newlines/tabs become single space.
     * This text will be escaped during rendering (< becomes &amp;lt;, etc.).
     * Mimics JSoup's TextNode.text() behavior.
     * Default implementation normalizes wholeText(). Override if needed.
     */
    default String text() {
        return normalizeWhitespace(wholeText());
    }

    /**
     * Generic accessor for escapable text content.
     * Delegates to text() for consistency with HasEscapableTextContent interface.
     */
    @Override
    default String escapableTextContent() {
        return text();
    }

    @Override
    default Text_T<I> stringNodeType() {
        return new Text_T(self());
    }

    /**
     * Static helper to normalize whitespace (collapse multiple spaces/newlines to single space).
     * Mimics JSoup's StringUtil.normaliseWhitespace() behavior.
     *
     * @param text input text with potentially multiple whitespace characters
     * @return text with normalized whitespace
     */
    static String normalizeWhitespace(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        var sb = new StringBuilder(text.length());
        boolean lastWasWhite = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (isActuallyWhitespace(c)) {
                if (!lastWasWhite) {
                    sb.append(' ');
                    lastWasWhite = true;
                }
            } else if (!isInvisibleChar(c)) {
                sb.append(c);
                lastWasWhite = false;
            }
        }
        return sb.toString();
    }

    /**
     * Tests if a character is whitespace (matching JSoup's definition).
     */
    static boolean isActuallyWhitespace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == 160;
        // 160 is &nbsp; (non-breaking space)
    }

    /**
     * Tests if a character is invisible (zero-width space, soft hyphen).
     */
    static boolean isInvisibleChar(char c) {
        return c == 8203 || c == 173; // zero width space, soft hyphen
    }
}
