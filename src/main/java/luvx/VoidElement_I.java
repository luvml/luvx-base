package luvx;

import luvx.ftype.VoidElement_T;

/**
 * Interface for HTML5 void elements that cannot contain children.
 * Examples: img, br, hr, input, meta, link
 */
public interface VoidElement_I<I extends VoidElement_I<I>> extends SelfClosingElement_I<I> {
    
    @Override
    default VoidElement_T<I> selfClosingElementType() {
        return new VoidElement_T(self());
    }
}