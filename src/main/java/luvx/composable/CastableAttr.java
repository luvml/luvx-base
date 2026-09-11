package luvx.composable;

import luvx.Attr_I;
import luvx.Self_I;
import java.util.Optional;

public class CastableAttr implements Attr_I {
    private final String name,value;

    public CastableAttr(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public Self_I self() {
        return this;
    }
    
    public int i(){
        return Integer.parseInt(value);
    }
    
    public int i(int defaultVal){
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
        }
        return defaultVal;
    }

    public long l(){
        return Long.parseLong(value);
    }

    public long l(long defaultVal){
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
        }
        return defaultVal;
    }

    public double d(){
        return Double.parseDouble(value);
    }

    public double d(double defaultVal){
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
        }
        return defaultVal;
    }

    public float f(){
        return Float.parseFloat(value);
    }

    public float f(float defaultVal){
        try {
            return Float.parseFloat(value);
        } catch (Exception e) {
        }
        return defaultVal;
    }

    public char c(){
        return value.charAt(0);
    }

    public char c(char defaultVal){
        return value.length() > 0 ? value.charAt(0) : defaultVal;
    }

    public boolean bool(){
        return Boolean.parseBoolean(value);
    }

    public boolean bool(boolean defaultVal){
        try {
            return Boolean.parseBoolean(value);
        } catch (Exception e) {
        }
        return defaultVal;
    }

    public byte b(){
        return Byte.parseByte(value);
    }

    public byte b(byte defaultVal){
        try {
            return Byte.parseByte(value);
        } catch (Exception e) {
        }
        return defaultVal;
    }

    public Optional<Integer> optInteger(){
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Long> optLong(){
        try {
            return Optional.of(Long.parseLong(value));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Double> optDouble(){
        try {
            return Optional.of(Double.parseDouble(value));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Float> optFloat(){
        try {
            return Optional.of(Float.parseFloat(value));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Character> optChar(){
        return value.length() > 0 ? Optional.of(value.charAt(0)) : Optional.empty();
    }

    public Optional<Boolean> optBoolean(){
        try {
            return Optional.of(Boolean.parseBoolean(value));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Byte> optByte(){
        try {
            return Optional.of(Byte.parseByte(value));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    
    public Optional<String> optString(){
        try {
            return Optional.of(value);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
