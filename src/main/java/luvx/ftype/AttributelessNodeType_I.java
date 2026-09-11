package luvx.ftype;

import luvx.AttributelessNode_I;

public sealed interface AttributelessNodeType_I<I extends AttributelessNode_I<I>> 
        extends TypeDiscriminator_I<I>
        permits StringNode_T, Doctype_T {
    
}