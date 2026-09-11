package luvx;

import luvx.ftype.Attr_T;

/**
 * Interface for document attributes.
 */
public interface Attr_I<I extends Attr_I<I>> extends Frag_I<I> {
    
    @Override
    default Attr_T<I> fragType() { 
        return new Attr_T(self()); 
    }
    
    String name();
    String value();
}
