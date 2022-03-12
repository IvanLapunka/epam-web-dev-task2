package by.training.task2.entity;

public interface Component {
    default void add(Component component){}
    default void remove(Component component){}
}
