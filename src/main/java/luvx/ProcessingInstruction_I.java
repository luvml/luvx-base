package luvx;

import luvx.rendering_behavior.BlockMarkupRendering;
import luvx.composable.DocumentLevelNode;
import luvx.composable.HasTagName;
import luvx.ftype.ProcessingInstruction_T;

/**
 * Interface for XML processing instructions.
 * Examples: <?xml version="1.0"?>, <?xml-stylesheet href="style.xsl"?>
 * Only allowed at document level.
 */
public interface ProcessingInstruction_I<I extends ProcessingInstruction_I<I>> extends SelfClosingElement_I<I>, DocumentLevelNode<I>, HasTagName<I>{
    
    @Override
    default ProcessingInstruction_T<I> selfClosingElementType() {
        return new ProcessingInstruction_T(self());
    }
    
    String target();
    
    String data();
    
    default String tagName() {
        return target();
    }
    
    @Override
    default BlockMarkupRendering markupRenderingBehavior() {
        return BlockMarkupRendering.I;
    }
}