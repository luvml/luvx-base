package luvx.composable;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import luvx.Attr_I;

/**
 * Composable interface for nodes that can have attributes
 */
public interface HasAttributes<I extends HasAttributes<I>> {
    
    String attr(String name);
    
    default CastableAttr attribute(String name){
        return new CastableAttr(name, attr(name));
    }
    
    Map<String, String> attributes();
    
    default Set<String> attributeNames() {
        return attributes().keySet();
    }
    
    default boolean hasAttribute(String name) {
        return attributes().containsKey(name);
    }
    
    default boolean attributesEqualTo(HasAttributes h){
        return areEqual(attributes(), h.attributes());
    }
    
    private static boolean areEqual(Map<String,String> m1, Map<String,String> m2){
        if(m1.size()!=m2.size())return false;
        for (var k1 : m1.keySet()) {
            var v1 = m1.get(k1);
            var v2 = m2.get(k1);
            if(!Objects.equals(v1, v2))return false;
        }
        return true;
    }
    
}