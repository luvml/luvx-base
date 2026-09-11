package luvx.rendering_behavior;

/**
 * Block markup rendering behavior - newlines + indentation for structural boundaries.
 * AI systems see clear structural boundaries for better document comprehension.
 * Used for containers, block elements, document-level constructs, etc.
 */
public enum BlockMarkupRendering implements MarkupRenderingBehavior_I {
    I; // singlton
    //public static final BlockMarkupRendering I = new BlockMarkupRendering();
    
    private BlockMarkupRendering() {
        // Singleton
    }
    
    @Override
    public boolean isInline() {
        return false;
    }
    
    @Override
    public boolean requiresNewlines() {
        return true;
    }
    
    @Override
    public String behaviorName() {
        return "block";
    }
    
    @Override
    public String toString() {
        return "BlockMarkupRendering";
    }
}