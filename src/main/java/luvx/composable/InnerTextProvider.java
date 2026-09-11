package luvx.composable;

import luvx.ContainerElement_I;

/**
 * Provides browser-like innerText extraction.
 *
 * Returns only visible, rendered text content:
 * - Text nodes (visible text)
 * - Skips: style, script (code, not content)
 * - Skips: title (metadata in head, not body content)
 * - Skips: textarea default values (form controls)
 * - Skips: comments, CDATA
 *
 * This matches browser innerText and JSoup .text() behavior.
 * For W3C spec-compliant extraction (includes everything), use {@link TextExtractionProvider}.
 */
public interface InnerTextProvider<I extends ContainerElement_I<I>> {
    I self();

    /**
     * Returns visible text content only.
     * Skips style/script code, comments, and non-visible elements.
     *
     * Matches browser innerText and JSoup .text() behavior.
     */
    default String innerText() {
        var sb = new StringBuilder();
        TextExtractionProvider.extractText(self(), sb, TextExtractionProvider.TextExtractionMode.INNER_TEXT);
        return sb.toString();
    }
}
