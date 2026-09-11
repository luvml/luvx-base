package luvx.ftype;

import luvx.Node_I;

public sealed interface NodeType_I<I extends Node_I<I>> 
        extends TypeDiscriminator_I<I>
        permits AttributelessNode_T, Element_T {
    
    
}