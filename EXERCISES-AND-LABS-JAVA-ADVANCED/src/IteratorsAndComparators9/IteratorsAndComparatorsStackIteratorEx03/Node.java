package IteratorsAndComparators9.IteratorsAndComparatorsStackIteratorEx03;

public class Node<Integer> { //всеки елемент на стека
    public int element;
    public Node<Integer> prev;

    public Node(int element) {
        this.element = element;
        this.prev = null;
    }
}
