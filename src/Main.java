import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int length = 10;
        int[] A = enterIntArray(length);
        System.out.println("Masyvas:");
        printArray(A);
        if (countEven(A) > 0) System.out.println("Masyvo lyginių elementų vidurkis: " + averageEven(A));
        else System.out.println("Masyve lyginių elementų nėra");
        swap(A, getIndexMin(A), getIndexMax(A));
        System.out.println("Masyvas po didžiausio ir mažiausio elementų sukeitimo:");
        printArray(A);

        int maxOddPositive = getMaxOddPositive(A);
        if(maxOddPositive == -1) System.out.println("Masyve teigiamų nelyginių skaičių nėra");
        else System.out.println("Didžiausias teigiamas, nelyginis masyvo elementas: " + maxOddPositive);
    }

    /**
     * Asks the user to enter a series of numbers and returns them as an array
     * @param length the length of the array
     * @return an array filled with user entered values
     */
    private static int [] enterIntArray(int length) {
        int [] array = new int[length];

        System.out.println("Įveskite " + length + " svaikų skaičių.");
        for (int i = 0; i < length; i++) {
            while (true) {
                Scanner s = new Scanner(System.in);
                try {
                    System.out.print("Įveskite " + (i + 1) + " skaičių: ");
                    array[i] = s.nextInt();
                    break;
                }
                catch (Exception e) {
                    System.out.println("Įvestas ne sveikas skaičius! Pakartokite įvedimą.");
                }
            }
        }
        return array;
    }

    /**
     * Prints the values of an array in a line
     * @param array the array to print
     */
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Adds the even values in an array and returns the result
     * @param array whose even values will be added
     * @return the sum of even values
     */
    private static int addEven(int[] array) {
        int sum = 0;
        for (int value : array) {
            if (value % 2 == 0) sum += value;
        }
        return sum;
    }

    /**
     * Returns the number of even values in an array
     * @param array the array whose even values will be counted
     * @return the number of even values
     */
    private static int countEven(int[] array) {
        int count = 0;
        for (int value : array) {
            if (value != 0 && value % 2 == 0) count++;
        }
        return count;
    }

    /**
     * Returns the average of even values in an array
     * @param array the array whose even values will be averaged
     * @return the average of even values
     */
    private static double averageEven(int[] array) {
        return (double) addEven(array) / countEven(array);
    }

    /**
     * Returns the index of the highest value in an array
     * @param array the array whose highest value's index will be returned
     * @return the index of the highest value, or -1 if the array is empty
     */
    private static int getIndexMax(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[index]) index = i;
        }
        return index;
    }

    /**
     * Returns the index of the lowest value in an array
     * @param array the array whose lowest value's index will be returned
     * @return the index of the lowest value, or -1 if the array is empty
     */
    private static int getIndexMin(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[index]) index = i;
        }
        return index;
    }

    /**
     * Swaps two values in an array
     * @param array the array whose values will be swapped
     * @param index1 index of the first value
     * @param index2 index of the second value
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * finds the largest positive, odd value in an array
     * @param array the array to be searched
     * @return max odd positive value or -1 if no positive odd values found
     */
    private static int getMaxOddPositive(int[] array) {
        int max = -1;
        for (int value : array) {
            if ((value % 2 == 1) && (value > max))
                max = value;
        }
        return max;
    }
}
