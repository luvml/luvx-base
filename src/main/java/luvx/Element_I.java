package luvx;

import luvx.composable.HasAttributes;
import luvx.composable.HasTagName;
import luvx.ftype.ElementType_I;
import luvx.ftype.Element_T;

/**
 * Base interface for all element types (containers, void elements, processing instructions).
 * All elements can have attributes.
 * Unsealed to enable extensibility while maintaining type discrimination.
 */
public interface Element_I<I extends Element_I<I>> extends Node_I<I>, HasAttributes<I>, HasTagName<I>{
    
    ElementType_I<I> elementType();
    
    @Override
    default Element_T<I> nodeType() {
        return new Element_T(self());
    }
    
    default boolean tagAndAttributesEqualTo(Element_I e){
        if(e==null)return false;
        if(!tagName().equals(e.tagName()))return false;
        if(!attributesEqualTo(e))return false;
        return true;
    }
    
    default boolean isSameTypeAs(Element_I e){
        if(e==null)return false;
        if(!e.getClass().isInstance(self() ))return false; // classes don't match
        return e.tagName().equals(self().tagName());
    }
    
}