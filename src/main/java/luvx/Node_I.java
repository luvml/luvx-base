package luvx;

import luvx.composable.HasRenderingBehavior;
import luvx.rendering_behavior.MarkupRenderingBehavior_I;
import luvx.ftype.*;

/**
 * Base interface for all document nodes. 
 * Unsealed to enable extensibility while maintaining type discrimination through nodeType().
 */
public interface Node_I<I extends Node_I<I>> extends Frag_I<I>,HasRenderingBehavior {
    
    NodeType_I<I> nodeType();
    
    @Override
    default Node_T<I> fragType() {
        return new Node_T(self());
    }
}
