package luvx.ftype;

import luvx.CData_I;

public final class CData_T<I extends CData_I<I>> implements StringNodeType_I<I> {
    private final I obj;

    public CData_T(I cdata) {
        this.obj = cdata;
    }

    public I cdata() {
        return obj;
    }
    
    public I obj() { return obj;}
}
