package luvx.ftype;

import luvx.SelfClosingElement_I;

/**
 * Type discriminator for self-closing elements.
 */
public final class SelfClosingElement_T<I extends SelfClosingElement_I<I>> implements ElementType_I<I> {
    final I obj;
    
    public SelfClosingElement_T(I obj) {
        this.obj = obj;
    }
    
    public SelfClosingElementType_I<I> selfClosingElementType() {
        return obj.selfClosingElementType();
    }
    
    public I selfClosingElement() {
        return obj;
    }
    
    public I obj() {return obj;}
}