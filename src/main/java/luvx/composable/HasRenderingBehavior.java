package luvx.composable;

import luvx.rendering_behavior.MarkupRenderingBehavior_I;

public interface HasRenderingBehavior {
    /**
     * Returns the markup rendering behavior for AI-optimized output.
     * NO DEFAULT IMPLEMENTATION - implementation classes decide behavior.
     * Type signatures prevents elements from inheriting both inline and block
     */
    MarkupRenderingBehavior_I markupRenderingBehavior();
}
