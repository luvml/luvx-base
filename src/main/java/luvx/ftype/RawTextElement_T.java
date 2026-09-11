package luvx.ftype;

import luvx.RawTextElement_I;

/**
 * Type discriminator for raw text elements.
 * Used by elements that contain raw text without escaping: &lt;style&gt;, &lt;script&gt;
 */
public final class RawTextElement_T<I extends RawTextElement_I<I>>
    implements ElementType_I<I> {

    private final I obj;

    public RawTextElement_T(I obj) {
        this.obj = obj;
    }

    public I rawTextElement() {
        return obj;
    }

    @Override
    public I obj() {
        return obj;
    }
}
