package luvx.ftype;

import luvx.Node_I;


/**
 * Type discriminator for all obj types.
 */
public final class Node_T<I extends Node_I<I>> implements FragType_I<I> {
    final I obj;
    
    public Node_T(I node) {
        this.obj = node;
    }
    
    public NodeType_I<I> nodeType(){
        return obj.nodeType();
    }
    
    public I node(){
        return obj;
    }

    @Override
    public I obj() {
        return obj;
    }
    
    
}