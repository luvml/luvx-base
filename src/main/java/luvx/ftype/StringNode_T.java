package luvx.ftype;

import luvx.StringNode_I;

/**
 * Type discriminator for string nodes.
 */
public final class StringNode_T<I extends StringNode_I<I>> implements AttributelessNodeType_I<I> {
    final I obj;
    
    public StringNode_T(I obj) {
        this.obj = obj;
    }
    
    public StringNodeType_I<I> stringNodeType() {
        return obj.stringNodeType();
    }
    
    public I stringNode() {
        return obj;
    }
    
    public I obj() { return obj;}
}