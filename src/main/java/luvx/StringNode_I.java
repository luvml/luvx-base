package luvx;

import luvx.composable.HasTextContent;
import luvx.ftype.StringNodeType_I;
import luvx.ftype.StringNode_T;

/**
 * Interface for nodes containing text content (text nodes, comments).
 * Unsealed to enable extensibility while maintaining type discrimination.
 */
public interface StringNode_I<I extends StringNode_I<I>> extends AttributelessNode_I<I>, HasTextContent<I> {
    
    StringNodeType_I<I> stringNodeType();
    
    @Override
    default StringNode_T<I> attributelessNodeType() {
        return new StringNode_T(self());
    }
}
