package luvx;

import luvx.composable.HasTextOnlyChildren_I;
import luvx.ftype.RawTextElement_T;

/**
 * Elements with raw text content only (no HTML parsing, no escaping).
 * According to HTML5 spec, these are elements where:
 * - Text content is not parsed for HTML markup
 * - Character references (like &amp;) are NOT escaped
 * - Content is treated as literal raw text
 *
 * Examples: &lt;style&gt;, &lt;script&gt;
 *
 * Usage:
 * <pre>
 * RawTextElement style = new RawTextElement("style");
 * style.addContent("body { color: red; }");
 * style.addContent(cssRule1, cssRule2);  // CharSequence implementations
 * </pre>
 *
 * @param <I> Self-bounded type for fluent API
 */
public interface RawTextElement_I<I extends RawTextElement_I<I>>
    extends Element_I<I>, HasTextOnlyChildren_I<I> {

    /**
     * Returns the raw text content without any escaping.
     * Used for CSS rules in &lt;style&gt; or JavaScript in &lt;script&gt;.
     *
     * The content is rendered as-is, with no HTML character escaping.
     * Example: "body { content: '<div>'; }" stays exactly as written.
     */
    String rawTextContent();

    @Override
    default RawTextElement_T<I> elementType() {
        return new RawTextElement_T<>(self());
    }
}
