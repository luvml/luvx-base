package luvx.ftype;

import luvx.StringNode_I;

public sealed interface StringNodeType_I<I extends StringNode_I<I>> 
        extends TypeDiscriminator_I<I>
        permits Text_T, Comment_T, CData_T {
    
}