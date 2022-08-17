package Generics8.Generics8_JarOfTLab01;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(T element) {
        this.elements.push(element);
    }
    public T remove (){
        return this.elements.pop();
    }
}

