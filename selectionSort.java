import java.text.DecimalFormat;

public class SelectionSort extends SortTools {

	private static long totalCount;

	public static void sort(int[] testSet) {

		SortTools selectionKit = new SortTools();

		totalCount = 0;
		double go = selectionKit.startTime();
		selectionSort(testSet);
		double stop = selectionKit.stopTime();

		selectionKit.postRun(go, stop, testSet, totalCount);


	}

	/***********************************************
	METHOD: selectionSort(int[] numbers)
		Use: Selection sort algorithm, sorts an array 
			of integers, swapping the smalles number
			in the array with the first element, one
			swap each iteration
		Parameters: 
			numbers: array with random integers
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