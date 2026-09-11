package luvx.mutable;

import luvx.*;

public interface MutableElement_I<I extends MutableElement_I<I>> extends Element_I<I>{    
    I addAttributes(Attr_I<?>... attrs);
    I addAttributes(Iterable<Attr_I<?>> attrs);
    I addAttribute(String name, String value);
}
