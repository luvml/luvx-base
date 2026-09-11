package luvx;

import java.util.List;
import java.util.stream.Stream;
import luvx.ftype.*;

/**
 * Base interface for all collection of fragments, helps in composing components
 */
public interface Frags_I<I extends Frags_I<I>> extends Frag_I<I> {

    @Override
    default Frags_T<I> fragType() {
        return new Frags_T(self());
    }
    
    List<Frag_I> fragments(); // Core capability
    
    // Derived capabilities built on fragments()
    default Stream<Frag_I> stream() { return fragments().stream(); }
    default int size() { return fragments().size(); }
    default boolean isEmpty() { return fragments().isEmpty(); }
    default Frag_I[] __(){
        return fragments().toArray(Frag_I[]::new);
    }
}

