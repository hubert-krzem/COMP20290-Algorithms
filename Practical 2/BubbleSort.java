import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class BubbleSort {
    // List implementation
    public static <T extends Comparable<T>> void bubbleSort(final List<T> input, final Comparator<T> comparator) {
        while (!isSorted(input, comparator)) { // Run while not sorted
            for (int i = 0; i < input.size() - 1; i++) { // Iterate through list
                if (comparator.compare(input.get(i), input.get(i+1)) > 0) { // If i is greater than i + 1, swap positions
                    T temp = input.get(i + 1);
                    input.set(i+1, input.get(i));
                    input.set(i, temp);
                }
            }
            /* System.out.println(input); */
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
    public static <T extends Comparable<T>> void bubbleSort(final T[] input, final Comparator<T> comparator) {
        while (!isSorted(input, comparator)) {
            for (int i = 0; i < input.length - 1; i++) {
                if (comparator.compare(input[i], input[i + 1]) > 0) {
                    T temp = input[i + 1];
                    input[i+1] = input[i];
                    input[i] = temp;
                }
            }
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

    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Random random = new Random();
        Comparator<Integer> comparator = Integer::compareTo;

        // List test
        List<Integer> numbers = Arrays.asList(1, 1, 1, 1, 1);
    
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, random.nextInt(100)); 
        }
        
        System.out.println("Unsorted List: " + numbers);
        bubbleSort(numbers, comparator);
        System.out.println("Sorted List: " + numbers);

        // Array test
        Integer[] arr = new Integer[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.print("Unsorted Array: ");
        printArray(arr);

        bubbleSort(arr, comparator);

        System.out.print("Sorted Array: ");
        printArray(arr);
    }
}