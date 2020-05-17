package lesson1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {



    public static void main(String[] args) {
        Integer[] arrInt = {2, 3, 4, 5, 6};

        change(arrInt, 0, 4);
        arrToArrList(arrInt);

        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();

        box1.addFruit(new Apple(), 22);
        box2.addFruit(new Orange(), 33);

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());

        System.out.println(box1.compare(box2));

    }

    public static <T> ArrayList<T> arrToArrList(T[] arr){
        ArrayList<T> al = new ArrayList<>();
        Collections.addAll(al, arr);
        return al;
    }


    public static <T> void change(T[] ob, int a, int b){
        T value = ob[a];
        ob[a] = ob[b];
        ob[b] = value;

    }

}
