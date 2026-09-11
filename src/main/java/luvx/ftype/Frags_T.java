package luvx.ftype;

import luvx.Frags_I;


/**
 * Type discriminator for all obj types.
 */
public final class Frags_T<I extends Frags_I<I>> implements FragType_I<I> {
    final I obj;
    
    public Frags_T(I node) {
        this.obj = node;
    }
    
    public I frags(){
        return obj;
    }

    @Override
    public I obj() {
        return obj;
    }
    
    
}