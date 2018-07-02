import java.lang.Math;
import java.text.DecimalFormat;

public class selectionSort {

	static long totalCount;

	static double start;
	static double finish;

	public static void main(String[] args) {
		
		System.out.println("Generating unsorted array: ");

		int[] testNums = fillArray();
		printArray(testNums);
		System.out.println("");

		System.out.println("Running selectionSort algorithm: ");

		start = System.nanoTime() / 1000000000.0;
		printArray(selectionSort(testNums));
		finish = System.nanoTime() / 1000000000.0;
		double totalTime = (finish - start);

		System.out.println("");

		DecimalFormat fourDec = new DecimalFormat(".0000");
		DecimalFormat twoDec = new DecimalFormat(".00");
		double time = Double.parseDouble(fourDec.format(totalTime));
		double swapRatio = Double.parseDouble(twoDec.format(totalCount / time));

		System.out.println("Analytics: ");
		System.out.println("Number of numbers: " + testNums.length);
		System.out.println("Number of swaps: " + totalCount);
		System.out.println("Approximate processing time: " + time + " seconds");
		System.out.println("Swaps per second: " + swapRatio );
	}

	/***********************************************
	METHOD: printArray(int[])
		Use: Prints each element of an integer array
		Parameters: Takes in integer array
	***********************************************/

	public static void printArray(int[] list) {

		for (int i = 0; i < list.length; i++) {

			System.out.print(list[i] + " ");

		}

		System.out.println("");
	}

	/***********************************************
	METHOD: fillArray()
		Use: Creates a sample test array and fills
			with random numbers, in a random order
		Parameters: None
	***********************************************/

	public static int[] fillArray() {

		int[] numbers;
		numbers = new int[100];

		// fill array with random numbers between 1-1000
		for (int i = 0; i < numbers.length; i++){

			numbers[i] = (int) (Math.random() * 100 ) + 1;
		}

		return numbers;
	}

	/***********************************************
	METHOD: selectionSort(int[])
		Use: Selection sort algorithm, sorts an array 
			of integers, swapping the smalles number
			in the array with the first element, one
			swap each iteration
		Parameters: Array with random integers
	***********************************************/

	public static int[] selectionSort(int[] numbers) {

		int minimum;
		int minIndex = 0;
		boolean minFound = false;

		// iterate through array
		for (int i = 0; i < numbers.length; i++){
			minimum = numbers[i];

			// starting on i, iterate through array
			// and swap if necessary
			for (int h = i; h < numbers.length; h++){
				if (numbers[h] < minimum){
					minFound = true;	
					minIndex = h;
					minimum = numbers[h];
				}
			}

			// swap minimum with i element, if new
			// minimum is found
			if (minFound){
				int temp;
				temp = numbers[i];
				numbers[i] = minimum;
				numbers[minIndex] = temp;
				totalCount++;
			}
		}

		return numbers;
	}

}