public class Sorting {
    int comparisons = 0;
    int swaps = 0;

    public void resetCount(){
        comparisons = 0;
        swaps = 0;
    }

    public void insertionSort(int []arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j+1] = arr[j];
                    swaps++;
                    j--;
                }else{
                    break;
                }
            }
            arr[j+1] = key;
        }
    }

    public void selectionSort(int []arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;

            for (int j = i+1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                swaps++;
            }
        }
    }

    public void bubbleSort(int []arr) {
        int m = arr.length;
        boolean swapped;

        for (int i = 0; i < m-1; i++) {
            swapped = false;
            for (int j = 0; j < m-i-1; j++) {
                comparisons++;
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public int[] increasingArray(int n) {
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public int[] reverseArray(int m) {
        int []arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = m -i;
        }
        return arr;
    }
    public int[] randomArray(int m) {
        java.util.Random rand = new java.util.Random();
        int []arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = rand.nextInt(m);
        }
        return arr;
    }

    public static void main(String[] args) {
        Sorting sorter = new Sorting();

        int[] sizes = {100, 1000, 10000};
        String[] inputTypes = {"Increasing", "Reverse", "Random"};

        for (int size : sizes) {
            System.out.println("Array Size: " + size);

            for (String input : inputTypes) {
                int[] baseArray;

                if (input.equals("Increasing")) {
                    baseArray = sorter.increasingArray(size);
                } else if (input.equals("Random")) {
                    baseArray = sorter.randomArray(size);
                } else {
                    baseArray = sorter.reverseArray(size);
                }

                System.out.println("\nInput Type: " + input);

                // Insertion Sort
                int[] arr1 = baseArray.clone();
                sorter.resetCount();
                sorter.insertionSort(arr1);
                System.out.println("Insertion Sort  -> Comparisons: " +
                        sorter.comparisons + ", Swaps: " + sorter.swaps);

                // Selection Sort
                int[] arr2 = baseArray.clone();
                sorter.resetCount();
                sorter.selectionSort(arr2);
                System.out.println("Selection Sort  -> Comparisons: " +
                        sorter.comparisons + ", Swaps: " + sorter.swaps);

                // Bubble Sort
                int[] arr3 = baseArray.clone();
                sorter.resetCount();
                sorter.bubbleSort(arr3);
                System.out.println("Bubble Sort     -> Comparisons: " +
                        sorter.comparisons + ", Swaps: " + sorter.swaps);
                System.out.println();
            }
        }
    }

}