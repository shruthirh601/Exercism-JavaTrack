import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class ListOps {

    private ListOps() {

    }

    static <T> List<T> append(List<T> list1, List<T> list2) {
        final List<T> result = new ArrayList<>();
        for(T item : list1) {
            result.add(item);
        }
        for(T item : list2) {
            result.add(item);
        }
        return result;
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {
        final List<T> result = new ArrayList<>();
        for(List<T> list : listOfLists)
            for(T item : list)
                result.add(item);
        return result;
    }

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    static <T> int size(List<T> list) {
        int count = 0;
        for(T item : list)
            count++;
        return count;
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        final List<U> result = new ArrayList<>();
        for(T item : list)
            result.add(transform.apply(item));
        return result;
    }

    static <T> List<T> reverse(List<T> list) {
        final List<T> result = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        U result = initial;
        for(T item : list) {
            result = f.apply(result, item);
        }
        return result;
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
        U result = initial;
        for(int i = list.size() - 1; i >= 0; i--) {
            result = f.apply(list.get(i), result);
        }
        return result;
    }

}
