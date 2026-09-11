package luvx.rendering_behavior;

/**
 * Inline markup rendering behavior - no newlines, flows with text.
 * AI systems read this as continuous content without structural boundaries.
 * Used for phrasing elements, inline text, inline comments, etc.
 */
public enum InlineMarkupRendering implements MarkupRenderingBehavior_I {
    I; // singleton
    //public static final InlineMarkupRendering I = new InlineMarkupRendering();
    
    private InlineMarkupRendering() {
        // Singleton
    }
    
    @Override
    public boolean isInline() {
        return true;
    }
    
    @Override
    public boolean requiresNewlines() {
        return false;
    }
    
    @Override
    public String behaviorName() {
        return "inline";
    }
    
    @Override
    public String toString() {
        return "InlineMarkupRendering";
    }
}