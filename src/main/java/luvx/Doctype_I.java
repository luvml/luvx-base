package luvx;

import luvx.rendering_behavior.BlockMarkupRendering;
import luvx.composable.DocumentLevelNode;
import luvx.ftype.Doctype_T;

/**
 * Interface for DOCTYPE declarations.
 * Only allowed at document level.
 */
public interface Doctype_I<I extends Doctype_I<I>> extends AttributelessNode_I<I>, DocumentLevelNode<I> {
    
    @Override
    default Doctype_T<I> attributelessNodeType() {
        return new Doctype_T(self());
    }
    
    String name();
    
    String publicId();
    
    String systemId();
    
    @Override
    default BlockMarkupRendering markupRenderingBehavior() {
        return BlockMarkupRendering.I;
    }
}