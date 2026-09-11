package luvx.ftype;

import luvx.Element_I;

/**
 * Type discriminator for elements (have attributes).
 */
public final class Element_T<I extends Element_I<I>> implements NodeType_I<I> {
    final I obj;
    
    public Element_T(I obj) {
        this.obj = obj;
    }
    
    public ElementType_I<I> elementType() {
        return obj.elementType();
    }
    
    public I element() {
        return obj;
    }

    @Override
    public I obj() {
        return obj;
    }
    
}