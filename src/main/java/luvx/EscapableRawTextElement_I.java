package luvx;

import luvx.composable.HasEscapableTextContent;
import luvx.composable.HasTextOnlyChildren_I;
import luvx.ftype.EscapableRawTextElement_T;

/**
 * Elements with escapable raw text content (no HTML parsing, but character references are escaped).
 * According to HTML5 spec, these are elements where:
 * - Text content is not parsed for HTML markup
 * - Character references (like &amp;amp;) ARE escaped (converted to their actual characters)
 * - Must not contain ambiguous ampersands
 *
 * Examples: &lt;textarea&gt;, &lt;title&gt;
 *
 * Difference from RawTextElement:
 * - RawTextElement: "body { content: \"&amp;lt;\" }" → stays as "&amp;lt;"
 * - EscapableRawTextElement: "Page &amp;lt;Title&amp;gt;" → becomes "Page &lt;Title&gt;"
 *
 * Usage:
 * <pre>
 * EscapableRawTextElement title = new EscapableRawTextElement("title");
 * title.addContent("My Page &amp;copy; 2025");  // Renders as "My Page © 2025"
 * </pre>
 *
 * @param <I> Self-bounded type for fluent API
 */
public interface EscapableRawTextElement_I<I extends EscapableRawTextElement_I<I>>
    extends Element_I<I>, HasTextOnlyChildren_I<I>, HasEscapableTextContent<I> {

    /**
     * Returns the escapable text content.
     * This text will be escaped during rendering (< becomes &amp;lt;, etc.).
     *
     * Shares the same escaping behavior as Text nodes, but unlike Text nodes,
     * this element has a tag wrapper (&lt;textarea&gt;, &lt;title&gt;).
     */
    @Override
    String escapableTextContent();

    @Override
    default EscapableRawTextElement_T<I> elementType() {
        return new EscapableRawTextElement_T<>(self());
    }
}
