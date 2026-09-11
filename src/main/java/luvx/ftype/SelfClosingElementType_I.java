package luvx.ftype;

import luvx.SelfClosingElement_I;

public sealed interface SelfClosingElementType_I<I extends SelfClosingElement_I<I>> 
        extends TypeDiscriminator_I<I>
        permits VoidElement_T, ProcessingInstruction_T {
    
}