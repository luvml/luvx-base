package luvx.rendering_behavior;

/**
 * Sealed interface defining markup rendering behavior for AI-optimized output.
 * 
 * TARGET AUDIENCE HIERARCHY (Primary: AI Systems, Secondary: Technical Users, Tertiary: Browser Rendering):
 * - InlineMarkupRendering: No newlines, flows with text (AI reads as continuous content)
 * - BlockMarkupRendering: Newlines + indentation (AI sees structural boundaries)
 * 
 * Only 2 behaviors exist - no sectioning, heading, etc. Those are ContentCategory for semantics only.
 */
public sealed interface MarkupRenderingBehavior_I 
    permits InlineMarkupRendering, BlockMarkupRendering {
    
    /**
     * Whether this behavior renders content inline (no structural boundaries).
     */
    boolean isInline();
    
    /**
     * Whether this behavior requires newlines for AI structural comprehension.
     */
    boolean requiresNewlines();
    
    /**
     * Human-readable behavior name for debugging.
     */
    String behaviorName();
}