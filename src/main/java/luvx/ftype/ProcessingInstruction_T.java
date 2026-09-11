package luvx.ftype;

import luvx.ProcessingInstruction_I;

/**
 * Type discriminator for processing instructions. Terminal.
 */
public final class ProcessingInstruction_T<I extends ProcessingInstruction_I<I>> implements SelfClosingElementType_I<I> {
    final I obj;
    
    public ProcessingInstruction_T(I obj) {
        this.obj = obj;
    }
    
    public I processingInstruction() {
        return obj;
    }

    @Override
    public I obj() {
        return obj;
    }
    
    
}