package luvx.ftype;

/**
 * A type discriminator is used for allowing safely casting objects as per their actual types and providing it during a switch on class type.
 * @param I the type of actual object whose type is represented by this type discriminator
 */
public interface TypeDiscriminator_I<I> {
    /**
     * @return the actual object whose type is this type discriminator. This is equivalent to (infact equal to) the corresponding Frag_I's self()
     */
    I obj();
}
