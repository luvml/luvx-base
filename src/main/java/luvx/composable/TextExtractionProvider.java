package luvx.composable;

import luvx.ContainerElement_I;
import luvx.Node_I;
import luvx.ftype.AttributelessNode_T;
import luvx.ftype.CData_T;
import luvx.ftype.Comment_T;
import luvx.ftype.ContainerElement_T;
import luvx.ftype.Doctype_T;
import luvx.ftype.Element_T;
import luvx.ftype.EscapableRawTextElement_T;
import luvx.ftype.ProcessingInstruction_T;
import luvx.ftype.RawTextElement_T;
import luvx.ftype.SelfClosingElement_T;
import luvx.ftype.StringNode_T;
import luvx.ftype.Text_T;
import luvx.ftype.VoidElement_T;

/**
 * Provides W3C DOM standard textContent extraction.
 *
 * Returns ALL text content including:
 * - Text nodes
 * - Comments (as per W3C spec)
 * - CDATA sections
 * - All raw text elements (style, script, title, textarea)
 *
 * This matches browser DOM textContent behavior (includes everything).
 * For visible text only, use {@link InnerTextProvider}.
 */
public interface TextExtractionProvider<I extends ContainerElement_I<I>> extends TextContentProvider<I>, InnerTextProvider<I>{
    
    /**
     * Shared implementation for text extraction.
     * Behavior controlled by mode parameter.
     */
    static void extractText(Node_I n, StringBuilder sb, TextExtractionMode mode) {
        switch (n.nodeType()) {
            case AttributelessNode_T a -> {
                switch (a.attributelessNodeType()) {
                    case StringNode_T s -> {
                        switch (s.stringNodeType()) {
                            case Text_T t ->
                                sb.append(t.text().text());
                            case Comment_T c -> {
                                if (mode == TextExtractionMode.TEXT_CONTENT) {
                                    // W3C spec includes comment text
                                    sb.append(c.comment().comment());
                                }
                                // innerText skips comments
                            }
                            case CData_T cd -> {
                                if (mode == TextExtractionMode.TEXT_CONTENT) {
                                    // W3C spec includes CDATA text
                                    sb.append(cd.cdata().cdata());
                                }
                                // innerText skips CDATA
                            }
                        }
                    }
                    case Doctype_T d -> {}
                }
            }
            case Element_T a -> {
                switch (a.elementType()) {
                    case ContainerElement_T c -> {
                        for (var childNodes : c.containerElement().childNodes()) {
                            extractText((Node_I)childNodes, sb, mode);
                        }
                    }
                    case SelfClosingElement_T s -> {
                        switch (s.selfClosingElementType()) {
                            case ProcessingInstruction_T p -> {}
                            case VoidElement_T v -> {}
                        }
                    }
                    case EscapableRawTextElement_T e -> {
                        // ESCAPABLE_RAW_TEXT: title, textarea
                        if (mode == TextExtractionMode.TEXT_CONTENT) {
                            // W3C spec includes all text
                            sb.append(e.escapableRawTextElement().escapableTextContent());
                        }
                        // innerText skips: title (not visible), textarea (form control)
                    }
                    case RawTextElement_T rt -> {
                        // RAW_TEXT: style, script
                        if (mode == TextExtractionMode.TEXT_CONTENT) {
                            // W3C spec includes CSS/JS code
                            sb.append(rt.rawTextElement().rawTextContent());
                        }
                        // innerText skips style/script (not visible content)
                    }
                }
            }
        }
    }

    /**
     * Controls text extraction behavior.
     */
    enum TextExtractionMode {
        /** W3C DOM textContent - includes everything (comments, style, script, etc.) */
        TEXT_CONTENT,
        /** Browser innerText - visible text only (skips style, script, comments, etc.) */
        INNER_TEXT
    }
}
