package luvx.composable;

import luvx.Element_I;
import luvx.Node_I;

import java.util.List;

/**
 * Composable interface for nodes that can have child nodes
 */
public interface HasChildNodes<I extends HasChildNodes<I>> {
    
    List<? extends Node_I> childNodes();
    
    default List<? extends Element_I<?>> children() {
        return childNodes().stream()
                .filter(node -> node instanceof Element_I<?>)
                .map(node -> (Element_I<?>) node)
                .toList();
    }
    
    default Node_I<?> firstChild() {
        var nodes = childNodes();
        return nodes.isEmpty() ? null : nodes.get(0);
    }
    
    default Node_I<?> lastChild() {
        var nodes = childNodes();
        return nodes.isEmpty() ? null : nodes.get(nodes.size() - 1);
    }
    
    default boolean hasChildNodes() {
        return !childNodes().isEmpty();
    }
}