package luvx.ftype;

import luvx.Attr_I;
import luvx.Node_I;

/**
 * Type discriminator for attributes. Terminal in discrimination hierarchy.
 */
public final class Attr_T<I extends Attr_I<I>> implements FragType_I<I>{
    final I obj;

    public Attr_T(I obj) {
        this.obj = obj;
    }
    
    // there is no Attr type, because that concept doesn't exist as per xml standards
    
    public I attr(){
        return obj;
    }
    
    public I obj(){
        return obj;
    }
    

}
