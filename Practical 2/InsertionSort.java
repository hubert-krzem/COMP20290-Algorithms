import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class InsertionSort {
    // List implementation
    public static <T extends Comparable<T>> void insertionSort(final List<T> input, final Comparator<T> comparator) {
        for (int i = 1; i < input.size(); i++) { // Initial pass of the list
            T currentValue = input.get(i); // Set value at i as current value

            int j = i - 1; // Set j to one less than i
            while (j >= 0 && (comparator.compare(input.get(j), currentValue) > 0)) { // While j is greater than 0 or the values before i are greater than i
                input.set(j + 1, input.get(j)); // Shift j item at j up one position
                j--; // Decrease j
            }
            input.set(j + 1, currentValue); // While loop ends, set the current value at j + 1
        }
    }

    // Array implementation
    public static <T extends Comparable<T>> void insertionSort(final T[] input, final Comparator<T> comparator) {
        for (int i = 1; i < input.length; i++) { // Initial pass of the list
            T currentValue = input[i]; // Set value at i as current value

            int j = i - 1; // Set j to one less than i
            while (j >= 0 && (comparator.compare(input[j], currentValue) > 0)) { // While j is greater than 0 or the values before i are greater than i
                input[j+1] = input[j]; // Shift j item at j up one position
                j--; // Decrease j
            }
            input[j+1] = currentValue; // While loop ends, set the current value at j + 1
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
        insertionSort(numbers, comparator);
        System.out.println("Sorted List: " + numbers);

        // Array test
        Integer[] arr = new Integer[10];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.print("Unsorted Array: ");
        printArray(arr);

        insertionSort(numbers, comparator);

        System.out.print("Sorted Array: ");
        printArray(arr);
    }
 }