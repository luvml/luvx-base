package luvx;

import luvx.composable.HasChildNodes;
import luvx.ftype.ContainerElement_T;
import luvx.composable.TextExtractionProvider;

/**
 * Interface for elements that can contain child nodes.
 * Examples: div, p, section, article, span
 */
public interface ContainerElement_I<I extends ContainerElement_I<I>> extends Element_I<I>, HasChildNodes<I>, TextExtractionProvider<I> {
    
    @Override
    default ContainerElement_T<I> elementType() {
        return new ContainerElement_T(self());
    }
}