package luvx.rendering_behavior;

import luvx.composable.HasRenderingBehavior;

public interface Block extends HasRenderingBehavior{
    @Override
    default BlockMarkupRendering markupRenderingBehavior(){
        return BlockMarkupRendering.I;
    }
}
