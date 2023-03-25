package IteratorsAndComparators9.Ex.IteratorsAndComparatorsListyIteratorEx01;

import java.util.List;

public class ListyIterator {

    private List<String> data; //списък с данни за обхождане
    private int index; // текущ индекс

    public ListyIterator(List<String> data) {
        this.data = data;
        if (this.data.size() != 0) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    //•	Move - should move an internal index position to the next index in the list,
// the method should return true if it successfully moved and false if there is no next index.
    public boolean move() {
        if (this.index < this.data.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }
//should return true if there is a next index and false if the
// index is already at the last element of the list.
    public boolean HasNext() {
        return this.index < this.data.size() - 1;
    }
    public void print() throws Exception{
        if (!this.data.isEmpty()){
            System.out.println(this.data.get(this.index));
        }else{
            System.out.println("Invalid Operation!");
        }
    }
}
