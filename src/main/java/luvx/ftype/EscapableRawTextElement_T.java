package luvx.ftype;

import luvx.EscapableRawTextElement_I;

/**
 * Type discriminator for escapable raw text elements.
 * Used by elements that contain text with character reference escaping: &lt;textarea&gt;, &lt;title&gt;
 */
public final class EscapableRawTextElement_T<I extends EscapableRawTextElement_I<I>>
    implements ElementType_I<I> {

    private final I obj;

    public EscapableRawTextElement_T(I obj) {
        this.obj = obj;
    }

    public I escapableRawTextElement() {
        return obj;
    }

    @Override
    public I obj() {
        return obj;
    }
}
