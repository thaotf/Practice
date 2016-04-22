package bubblesort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            for (int k = 0; k < i; k++) {
                if (array[k] == array[i]) {
                    i--;
                    ++counter;
                }
            }
        }
        System.out.println("Before bubble sort");

        for (int a : array) {
            System.out.print(a + " ");
        }

        boolean swap = true;
        while (swap == true) {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
        }

        System.out.println("\n\nAfter bubble sort");
        for (int a : array) {
            System.out.print(a + " ");
        }

        if (counter == 0) {
            System.out.println("\n\nThere are no duplicates");
        }

        if (counter == 1) {
            System.out.println("\n\n" + counter + " duplicate corrected");
        }

        if (counter > 1) {
            System.out.println("\n\n" + counter + " duplicates corrected");
        }
    }
}
