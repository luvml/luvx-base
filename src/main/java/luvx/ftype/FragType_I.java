package luvx.ftype;

import luvx.Frag_I;

/**
 * Top-level fragment type discrimination using final class wrappers.
 * Fundamental split: Attr_T vs Node_T (_T suffix denotes type discriminator classes).
 * Further discrimination happens through hierarchical type functions with self-documenting variable names.
 * Pattern enables both compile-time type safety and runtime extensibility.
 */
public sealed interface FragType_I<I extends Frag_I<I>> 
        extends TypeDiscriminator_I<I>
        permits Attr_T, Node_T, Frags_T {
    
}
