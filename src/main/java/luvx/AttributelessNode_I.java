package luvx;

import luvx.ftype.AttributelessNodeType_I;
import luvx.ftype.AttributelessNode_T;

/**
 * Base interface for nodes that cannot have attributes.
 * Includes text nodes, comments, and document type declarations.
 * Unsealed to enable extensibility while maintaining type discrimination.
 */
public interface AttributelessNode_I<I extends AttributelessNode_I<I>> extends Node_I<I> {
    
    AttributelessNodeType_I<I> attributelessNodeType();
    
    @Override
    default AttributelessNode_T<I> nodeType() {
        return new AttributelessNode_T(self());
    }
}