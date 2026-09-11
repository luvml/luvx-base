package luvx;

import luvx.ftype.FragType_I;

/**
 * Root interface for all document fragments (attributes and nodes).
 * 
 * FRAG_I ARCHITECTURE SUMMARY:
 * 
 * Historical Context:
 * • Frag concept originates from luvml (https://github.com/xyz-jphil/xyz-jphil-luvml/) as "Flow ___F"
 * • ScalaTags library by Li Haoyi uses "Frag" for similar SSR (Server-Side Rendering) purposes
 * • This implementation extends beyond SSR to support multiple render targets under iterative development
 * 
 * Design Philosophy (DoNotStopDancing Principle): Keep development flowing without stopping for perfect architecture.
 * Solutions emerge while actively working. This integrates practical minimal start (Tulach) with deep module design (Ousterhout)
 * while maintaining continuous flow, resulting in continuous evolution on a need-based basis by actively solving real problems.
 * 
 * Hierarchy Structure:
 * Frag_I<I> // this is our derrived super-type beyond the html/xml standards to accomodate Attributes
 * ├── Attr_I<I> (terminal) // these are not part of the heirarchy in typical html dom api/documentation
 * ├── Node_I<I> // as per Html/xml standards
 * │   ├── AttributelessNode_I<I> // nodes without attributes
 * │   │   ├── StringNode_I<I>
 * │   │   │   ├── Text_I<I> (terminal)
 * │   │   │   ├── Comment_I<I> (terminal)
 * │   │   │   └── CData_I<I> (terminal)
 * │   │   └── DocumentType_I<I> (terminal)
 * │   └── Element_I<I> // have attributes
 * │       ├── SelfClosingElement_I<I> // do not have children 
 * │       │   ├── VoidElement_I<I> (terminal)
 * │       │   └── ProcessingInstruction_I<I> (terminal)
 * │       ├── ContainerElement_I<I> (terminal) // have children
 * │       ├── RawTextElement_I<I> (terminal) // have text only children, no escaping
 * │       └── EscapableRawTextElement_I<I> (terminal) // have text only children, need escaping
 * └── Frags_I<I> // a collection of fragments in the same level (not nested in a child)
 * 
 * Design Decisions:
 * 
 * 1. BEHAVIORAL GROUPING OVER SYNTAX: Group by capabilities (attributes, children) not XML syntax
 *    Why: <!DOCTYPE> and <?xml?> are structured but behaviorally different from <elements>
 *    Result: AttributelessNode_I vs Element_I reflects programming patterns
 * 
 * 2. HIERARCHICAL TYPE DISCRIMINATION PATTERN:
 *    Decision: Unsealed interfaces + final class wrappers + self() pattern from htmlflow
 *    Purpose: Combines compile-time type safety with runtime extensibility for LuvML composition
 *    Implementation: Final classes wrap interface instances enabling safe pattern matching with extensibility
 *    Result: Nested switching with self-documenting variable names (Attr_T a, Node_T n, Element_T e), 
 *    creating algebraic data type behavior with runtime extensibility.
 * 
 * 3. SELF-BOUNDED GENERICS WITH HTMLFLOW SELF() PATTERN:
 *    Implementation: <I extends Frag_I<I>> + I self() method for accessing interface 'this'
 *    Purpose: Enables type-safe builder patterns and proper method delegation
 *    Result: Clean interface implementation with new WrapperClass(self()) pattern
 * 
 * 4. COMPOSABLE CAPABILITIES:
 *    Implementation: Single-method interfaces (HasAttributes, HasChildNodes)
 *    Purpose: Mix-and-match capabilities without complex inheritance
 *    Result: Type-safe compile-time capability checking
 * 
 * 5. MULTIPLE RENDER TARGETS:
 *    Implementation: Design for multiple render targets (SSR String, DOM manipulation, Java POJOs)
 *    Purpose: Support DOM tree operations (unlike htmlflow's function-only approach) for client-side web js/html,
 *    JSoup dom objects for manipulation, inspection etc.
 *    Result: Unified API for diverse output formats under iterative evolution
 */
public interface Frag_I<I extends Frag_I<I>> extends Self_I<I>{
    
    /**
     * Returns the fragment type for type discrimination and prevents incompatible multiple inheritance.
     * Prevents illegal implementations like: {@code class Wrong implements Element_I, Attr_I}
     * @return type of fragment as a sealed set of choices
     */
    FragType_I<I> fragType();
}
