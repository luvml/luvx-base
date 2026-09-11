package luvx.ftype;

import luvx.Doctype_I;

/**
 * Type discriminator for document type declarations. Terminal.
 */
public final class Doctype_T<I extends Doctype_I<I>> implements AttributelessNodeType_I<I> {
    final I obj;
    
    public Doctype_T(I obj) {
        this.obj = obj;
    }
    
    public I doctype() {
        return obj;
    }
    
    public I obj() { return obj;}
}