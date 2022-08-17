package ListUtilitiesLab04;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMax(List<T> elements) {
        ensureNonEmpty(elements.isEmpty());
        return Collections.max(elements);
    }

    public static <T extends Comparable<T>> T getMin(List<T> elements) {

        ensureNonEmpty(elements.isEmpty());
        return Collections.min(elements);
    }

    private static void ensureNonEmpty(boolean empty) {
        if (empty) {
            throw new IllegalArgumentException();
        }
    }
}
