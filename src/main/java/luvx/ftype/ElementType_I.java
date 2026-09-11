package luvx.ftype;

import luvx.Element_I;

public sealed interface ElementType_I<I extends Element_I<I>>
        extends TypeDiscriminator_I<I>
        permits
            SelfClosingElement_T,
            RawTextElement_T,
            EscapableRawTextElement_T,
            ContainerElement_T {

}