package common;

@FunctionalInterface
public interface Effect<T> {
  void apply(T t);
}