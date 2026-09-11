package luvx.mutable;

import luvx.ContainerElement_I;
import luvx.Frag_I;

public interface MutableContainerElement_I<I extends MutableContainerElement_I<I>> extends  MutableElement_I<I>, ContainerElement_I<I>{
    default I ____(Iterable<Frag_I<?>> fragments){
        return addContent(fragments);
    }
    default I ____(Frag_I<?>... fragments){
        return addContent(fragments);
    }
    default I ____(String ... fragments){
        return addContent(fragments);
    }
    
    I addContent(Iterable<Frag_I<?>> fragments);
    I addContent(Frag_I<?>... fragments);
    I addContent(String ... fragments);
}
