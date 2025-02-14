import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class SelectionSort {
    // List implementation
    public static <T extends Comparable<T>> void selectionSort(final List<T> input, final Comparator<T> comparator) {
        for (int i = 0; i < input.size() - 1; i++) { // Initial pass of the list
            int small = i;

            for (int j = i + 1; j < input.size(); j++) {
                if (comparator.compare(input.get(small), input.get(j)) > 0) { // If the smallest number is bigger than the one at j, save j as smallest
                    small = j;
                }
            }

            T temp = input.get(small);
            input.set(small, input.get(i));
            input.set(i, temp);
        }
    }

    // Array implementation
    public static <T extends Comparable<T>> void selectionSort(final T[] input, final Comparator<T> comparator) {
        for (int i = 0; i < input.length - 1; i++) { // Initial pass of the list
            int small = i;

            for (int j = i + 1; j < input.length; j++) {
                if (comparator.compare(input[small], input[j]) > 0) { // If the smallest number is bigger than the one at j
                    small = j; // Save j as smallest
                }
            }

            T temp = input[small];
            input[small] = input[i];
            input[i] = temp;
        }
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
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5);
        
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, random.nextInt(100)); 
        }

        System.out.println("Unsorted List: " + numbers);
        selectionSort(numbers, comparator);
        System.out.println("Sorted List: " + numbers);

        // Array test
        Integer[] arr = new Integer[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.print("Unsorted Array: ");
        printArray(arr);

        selectionSort(arr, comparator);

        System.out.print("Sorted Array: ");
        printArray(arr);
        
    }
}