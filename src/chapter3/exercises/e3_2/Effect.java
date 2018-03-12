package chapter3.exercises.e3_2;

public interface Effect<T> { //java Consumer is equivalent
    void apply(T t);
}
