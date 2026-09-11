package luvx.composable;

/**
 * Composable interface for nodes that have text content
 */
public interface HasTextContent<I extends HasTextContent<I>> {
    
    String textContent();
}