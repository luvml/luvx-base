package luvx.ftype;

import luvx.ContainerElement_I;

/**
 * Type discriminator for container elements. Terminal.
 */
public final class ContainerElement_T<I extends ContainerElement_I<I>>  implements ElementType_I<I> {
    final I obj;
    
    public ContainerElement_T(I obj) {
        this.obj = obj;
    }
    
    public I containerElement() {
        return obj;
    }

    @Override
    public I obj() {
        return obj;
    }
    
    
}