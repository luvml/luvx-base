package luvx.rendering_behavior;

import luvx.composable.HasRenderingBehavior;

public interface Inline extends HasRenderingBehavior{
    @Override
    default InlineMarkupRendering markupRenderingBehavior(){
        return InlineMarkupRendering.I;
    }
}
