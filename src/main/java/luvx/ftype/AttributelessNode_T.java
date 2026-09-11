package luvx.ftype;

import luvx.AttributelessNode_I;

/**
 * Type discriminator for attributeless nodes.
 */
public final class AttributelessNode_T<I extends AttributelessNode_I<I>> implements NodeType_I<I> {
    final I obj;
    
    public AttributelessNode_T(I obj) {
        this.obj = obj;
    }
    
    public AttributelessNodeType_I<I> attributelessNodeType() {
        return obj.attributelessNodeType();
    }
    
    public I attributelessNode() {
        return obj;
    }

    @Override
    public I obj() {
        return obj;
    }
   
}