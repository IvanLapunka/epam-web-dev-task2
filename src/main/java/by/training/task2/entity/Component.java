package by.training.task2.entity;

import java.util.Collections;
import java.util.List;

public interface Component {
    default void add(Component component){}
    default void remove(Component component){}
    default List<Component> getParts(){ return Collections.emptyList();}
    CompositeLevelInfo getInfo();
}
