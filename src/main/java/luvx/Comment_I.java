package luvx;

import luvx.ftype.Comment_T;

/**
 * Interface for HTML/XML comment nodes.
 */
public interface Comment_I<I extends Comment_I<I>> extends StringNode_I<I> {
    
    @Override
    default Comment_T<I> stringNodeType() {
        return new Comment_T(self());
    }
    
    String comment();
    
}
