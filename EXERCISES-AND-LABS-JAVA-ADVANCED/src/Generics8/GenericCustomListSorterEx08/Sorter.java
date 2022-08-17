package Generics8.GenericCustomListSorterEx08;

public class Sorter {


    public static void sort(CustomList customList) {
        for (int i = 0; i < customList.getValues().size(); i++) {
            String currentElement = (String) customList.getValues().get(i);
            for (int j = i + 1; j < customList.getValues().size(); j++) {
                String nextElement = (String) customList.getValues().get(j);
                if (currentElement.compareTo(nextElement) > 0) {
                    customList.swap(i, j);
                }
            }
        }
    }
}
