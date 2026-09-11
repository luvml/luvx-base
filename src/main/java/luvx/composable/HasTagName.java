package luvx.composable;

/**
 *
 * @author User
 */
public interface HasTagName<I extends HasTagName<I>> {
    String tagName();
}
