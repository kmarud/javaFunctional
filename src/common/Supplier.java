package common;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}
