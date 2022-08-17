package IteratorsAndComparators9.IteratorsAndComparatorsFroggyEx04;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    public int[] stoneNumbers;

    public Lake(int[] stoneNumbers) {
        this.stoneNumbers = stoneNumbers;
    }

    //        private int cursor = elements.size() == 0 ? 0 : -2;
//
//        private boolean isEvenCursor() {
//            return cursor % 2 == 0;
//        }
//
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;
            private int lastEvenIndex = stoneNumbers.length % 2 == 0 ? stoneNumbers.length - 2 : stoneNumbers.length - 1;

            @Override
            public boolean hasNext() {
                return this.index < stoneNumbers.length;
            }

            @Override
            public Integer next() {
                if (this.index == lastEvenIndex) {
                    int element = stoneNumbers[lastEvenIndex];
                    this.index = 1;
                    return element;
                }
                int element = stoneNumbers[index];
                this.index += 2;
                return element;
            }
        };
    }
}

