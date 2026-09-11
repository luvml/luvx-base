package luvx;

import luvx.ftype.CData_T;

/**
 * Interface for CDATA sections.
 * The content of a CDATA section is not parsed by the XML parser and is not escaped.
 * Protected by &lt;![CDATA[ ]]&gt; wrapper.
 */
public interface CData_I<I extends CData_I<I>> extends StringNode_I<I> {

    /**
     * Returns the CDATA content.
     * This content is rendered inside &lt;![CDATA[ ]]&gt; and is not escaped.
     */
    String cdata();

    @Override
    default CData_T<I> stringNodeType() {
        return new CData_T<>(self());
    }
}
