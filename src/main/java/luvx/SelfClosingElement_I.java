package luvx;

import luvx.ftype.SelfClosingElementType_I;
import luvx.ftype.SelfClosingElement_T;

/**
 * Base interface for elements that cannot contain children.
 * Includes void elements (img, br, hr) and processing instructions.
 * Unsealed to enable extensibility while maintaining type discrimination.
 */
public interface SelfClosingElement_I<I extends SelfClosingElement_I<I>> extends Element_I<I> {
    
    SelfClosingElementType_I<I> selfClosingElementType();
    
    @Override
    default SelfClosingElement_T<I> elementType() {
        return new SelfClosingElement_T(self());
    }
}