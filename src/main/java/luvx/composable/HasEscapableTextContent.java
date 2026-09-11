package luvx.composable;

/**
 * Composable interface for nodes that have escapable text content.
 *
 * Escapable text content is text that needs HTML character escaping:
 * - `<` becomes `&lt;`
 * - `>` becomes `&gt;`
 * - `&` becomes `&amp;`
 * - etc.
 *
 * Used by:
 * - Text nodes (plain text content)
 * - ESCAPABLE_RAW_TEXT elements (&lt;textarea&gt;, &lt;title&gt;)
 *
 * NOT used by:
 * - RAW_TEXT elements (&lt;style&gt;, &lt;script&gt;) - no escaping
 * - Comments (protected by &lt;!-- --&gt; wrapper)
 * - CDATA (protected by &lt;![CDATA[ ]]&gt; wrapper)
 */
public interface HasEscapableTextContent<I extends HasEscapableTextContent<I>> {

    /**
     * Returns the text content that needs HTML character escaping.
     * The actual escaping is performed during rendering.
     */
    String escapableTextContent();
}
