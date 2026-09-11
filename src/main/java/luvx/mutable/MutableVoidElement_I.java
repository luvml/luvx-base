package luvx.mutable;

import luvx.*;

public interface MutableVoidElement_I<I extends MutableVoidElement_I<I>> extends MutableElement_I<I>, VoidElement_I<I>{
    default I ____(Attr_I<?>... attrs){
        return addAttributes(attrs);
    }
    default I ____(Iterable<Attr_I<?>> attrs){
        return addAttributes(attrs);
    }
}
