package luvx.ftype;

import luvx.VoidElement_I;

/**
 * Type discriminator for void elements. Terminal.
 */
public final class VoidElement_T<I extends VoidElement_I<I>> implements SelfClosingElementType_I<I> {
    final I obj;
    
    public VoidElement_T(I obj) {
        this.obj = obj;
    }
    
    public I voidElement() {
        return obj;
    }
    
    public I obj() { return obj;}
}