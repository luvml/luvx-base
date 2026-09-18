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
     * UNSAFE escape hatch: true means a renderer must emit {@link #wholeText()} verbatim --
     * no HTML escaping, no whitespace normalization. False (the default) is the safe,
     * normal case. Only a text node the caller has deliberately marked raw (see luvml's
     * {@code T.raw(...)}) should ever return true; never derive this from content.
     */
    default boolean isRaw() {
        return false;
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

        // Fast path: most authored text is already normalized (single spaces, no tabs/
        // newlines/nbsp, no invisible chars) -- detect that in one pass and return the
        // original String untouched, with zero allocation, instead of always rebuilding
        // it character-by-character through a StringBuilder.
        var len = text.length();
        var lastWasWhite = false;
        var needsChange = false;
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (isActuallyWhitespace(c)) {
                if (c != ' ' || lastWasWhite) {
                    needsChange = true;
                    break;
                }
                lastWasWhite = true;
            } else if (isInvisibleChar(c)) {
                needsChange = true;
                break;
            } else {
                lastWasWhite = false;
            }
        }
        if (!needsChange) {
            return text;
        }

        // Bulk-copy runs of ordinary characters with sb.append(text, from, to) instead of
        // appending one char at a time -- most text is not whitespace, so this is the
        // dominant path even when *some* normalization is needed somewhere in the string.
        var sb = new StringBuilder(len);
        lastWasWhite = false;
        var runStart = 0;
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (isActuallyWhitespace(c)) {
                if (i > runStart) sb.append(text, runStart, i);
                if (!lastWasWhite) {
                    sb.append(' ');
                    lastWasWhite = true;
                }
                runStart = i + 1;
            } else if (isInvisibleChar(c)) {
                if (i > runStart) sb.append(text, runStart, i);
                runStart = i + 1;
            } else {
                lastWasWhite = false;
            }
        }
        if (len > runStart) sb.append(text, runStart, len);
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
