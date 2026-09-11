package luvx.ftype;

import luvx.Text_I;

/**
 * Type discriminator for text nodes. Terminal.
 */
public final class Text_T<I extends Text_I<I>> implements StringNodeType_I<I> {
    final I obj;
    
    public Text_T(I text) {
        this.obj = text;
    }
    
    public I text() {
        return obj;
    }
    
    public I obj() { return obj;}
}
