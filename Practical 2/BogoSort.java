import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class BogoSort {
    // List implementation
    public static <T extends Comparable<T>> void bogoSort(final List<T> input, final Comparator<T> comparator) {
        Random random = new Random();
        int iterations = 0;

        while (!isSorted(input, comparator)) {
            if(iterations>1000){
                System.out.println("Over Max Iterations");
                break;
            }
            Collections.shuffle(input, random);
            iterations++;
        }
    }

    public static <T> boolean isSorted(List<T> input, Comparator<T> comparator) {
        for (int i = 0; i < input.size() - 1; i++) {
            if (comparator.compare(input.get(i), input.get(i+1)) > 0) {
                return false;
            }
        }
        return true;
    }

    // Array implementation
    public static <T extends Comparable<T>> void bogoSort(final T[] input, final Comparator<T> comparator) {
        Random random = new Random();
        int iterations = 0;

        while (!isSorted(input, comparator)) {
            if(iterations>1000){
                System.out.println("Over Max Iterations");
                break;
            }

            shuffleArray(input, random);
            iterations++;
        }
    }

    public static <T> boolean isSorted(T[] input, Comparator<T> comparator) {
        for (int i = 0; i < input.length - 1; i++) {
            if (comparator.compare(input[i], input[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    private static <T> void shuffleArray(T[] input, Random random) {
        for (int i = 0; i < input.length; i++) {
            swap(input, i, (int)(Math.random() * i));
        }
    }

    private static <T> void swap(T[] input, int i, int j) {
        T temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5);
        Comparator<Integer> comparator = Integer::compareTo;

        System.out.println("Unsorted List: " + numbers);
        bogoSort(numbers, comparator);
        System.out.println("Sorted List: " + numbers);

        Integer[] arr = {3, 1, 4, 1, 5};
        System.out.print("Unsorted Array: ");
        printArray(arr);
        bogoSort(arr, comparator);
        System.out.print("Sorted Array: ");
        printArray(arr);
    }
}