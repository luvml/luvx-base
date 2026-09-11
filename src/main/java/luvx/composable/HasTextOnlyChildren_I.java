package luvx.composable;

import luvx.Self_I;

/**
 * Composable capability for elements that can only contain text (no child elements).
 * Used by RAW_TEXT elements (style, script) and ESCAPABLE_RAW_TEXT elements (textarea, title).
 *
 * Unlike HasChildNodes which allows any Node_I children, this only allows CharSequence text content.
 *
 * @param <I> Self-bounded type for fluent API
 */
public interface HasTextOnlyChildren_I<I extends HasTextOnlyChildren_I<I>>
    extends Self_I<I> {

    /**
     * Adds text-only content. No child elements allowed.
     * For RAW_TEXT (<style>, <script>) and ESCAPABLE_RAW_TEXT (<textarea>, <title>) elements.
     *
     * @param textContent Text or CharSequence implementations (String, CssRule, Style, etc.)
     * @return self for fluent chaining
     */
    I addContent(CharSequence... textContent);

    /**
     * Fluent alias for addContent() following the ____ pattern.
     *
     * Usage:
     * <pre>
     * style.____(cssRule1, cssRule2)
     * script.____("console.log('hello');")
     * </pre>
     *
     * @param textContent Text content to add
     * @return self for fluent chaining
     */
    default I ____(CharSequence... textContent) {
        return addContent(textContent);
    }
}
