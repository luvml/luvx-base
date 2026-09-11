package luvx.ftype;

import luvx.Comment_I;

/**
 * Type discriminator for comment nodes. Terminal.
 */
public final class Comment_T<I extends Comment_I<I>> implements StringNodeType_I<I> {
    final I obj;
    
    public Comment_T(I obj) {
        this.obj = obj;
    }
    
    public I comment() {
        return obj;
    }
    
    public I obj() { return obj;}
}