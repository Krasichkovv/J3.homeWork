package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    ArrayList<T> al;

    Box(T... fruits) {
        this.al = new ArrayList<T>();
    }

    void addFruit(T fruit, int number) {
        for (int i = 0; i < number; i++) {
            al.add(fruit);
        }
    }

    public void add(Box<T> fruitsBox) {
        if (this.al.equals(fruitsBox.al)) {
            return;
        }
        this.al.addAll(fruitsBox.al);
        fruitsBox.al.clear();
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit : al) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    boolean compare(Box<?> anotherbox){
        return (this.getWeight() == anotherbox.getWeight());
    }
}
