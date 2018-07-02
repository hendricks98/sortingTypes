import java.lang.Math;
import java.text.DecimalFormat;

public class selectionSort extends sortTools {

	static long totalCount;

	public static void main(String[] args) {

		int[] testSet = preRun();
		printArray(selectionSort(testSet));
		postRun();

		// sort specific stats
		double swapRatio = Double.parseDouble(twoDec.format(totalCount / time));
		System.out.println("Number of numbers: " + testSet.length);
		System.out.println("Number of swaps: " + totalCount);
		System.out.println("Swaps per second: " + swapRatio );
		
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