import java.lang.Math;
import java.text.DecimalFormat;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class SortTools {

	public static double start;
	public static double finish;
	public static double timeFormat;
	public static DecimalFormat twoDec;
	public static DecimalFormat scientific;
	public static File rawOut;
	public static PrintWriter printer;

	/***********************************************
	METHOD: printArray(int[] list)
		Use: Prints each element of an integer array
		Parameters:
			list: Takes in integer array
	***********************************************/

	public static void printArray(int[] list) {

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}

		System.out.println("");
	}

	/***********************************************
	METHOD: printArrayOut(int[] list)
		Use: Prints each element of an array to the
			output file
		Parameters:
			list: Takes in integer array
	***********************************************/

	public static void printArrayOut(int[] list){

		printer.println("SORTED ARRAY: \n");
		for (int i = 0; i < list.length; i++) {
			printer.print(list[i] + " ");
		}

		printer.println("");
		printer.flush();
	}

	/***********************************************
	METHOD: fillArray(int n)
		Use: Creates a sample test array and fills
			with random numbers, in a random order
		Parameters:
			n: # of numbers to fill the array with
	***********************************************/

	public static int[] fillArray(int n) {

		int[] numbers;
		numbers = new int[n];

		// fill array with random numbers between 1-1000
		for (int i = 0; i < numbers.length; i++){

			numbers[i] = (int) (Math.random() * 100 ) + 1;
		}

		return numbers;
	}

	/***********************************************
	METHOD: preRun(int n)
		Use: Calls fillArray() and alerts the user
			before running sorts
		Parameters: n numbers to fill the array with
	***********************************************/


	public static int[] preRun(int n) {

		System.out.println("Generating an unsorted array...");

		int[] testNums = fillArray(n);
		System.out.println("");

		System.out.println("Running sort algorithms...\n");

		return testNums;
	}

	/***********************************************
	METHOD: postRun(double start, finish, totalCount
		int[] testSet)
		Use: After running sorts, print out analytics
			of each sort including total time, sample
			size, number of swaps, and swaps/second
		Parameters:
			start: start time of sort
			finish: finish time of sort
			testSet: array of unsorted numbers
			totalCount: total count of swaps made by
				the sort algorithm
	***********************************************/

	public static void postRun(double start, double finish, int[] testSet, double totalCount) {
		double totalTime = (finish - start);

		scientific = new DecimalFormat("0.00E00");
		twoDec = new DecimalFormat("#.00");
		timeFormat = Double.parseDouble(scientific.format(totalTime));

		System.out.println("Approximate processing time: " + timeFormat + " seconds");
		double swapRatio = Double.parseDouble(twoDec.format(totalCount / totalTime ));
		System.out.println("Number of numbers: " + testSet.length);
		System.out.println("Number of swaps: " + scientific.format(totalCount));
		System.out.print("Swaps per second: " + scientific.format(swapRatio));
	}

	/***********************************************
	METHOD: postRunOut(double start, finish,
		totalCount, int[] testSet)
		Use: After running sorts, print out analytics
			of each sort including total time, sample
			size, number of swaps, and swaps/second
			to an output file instead of cmd-line
		Parameters:
			start: start time of sort
			finish: finish time of sort
			testSet: array of unsorted numbers
			totalCount: total count of swaps made by
				the sort algorithm
	***********************************************/

	public static void postRunOut(double start, double finish, int[] testSet, double totalCount) throws IOException {
		double totalTime = (finish - start);

		scientific = new DecimalFormat("0.00E00");
		twoDec = new DecimalFormat("#.00");
		timeFormat = Double.parseDouble(scientific.format(totalTime));

		printer.println("Approximate processing time: " + timeFormat + " seconds");
		double swapRatio = Double.parseDouble(twoDec.format(totalCount / totalTime ));
		printer.println("Number of numbers: " + testSet.length);
		printer.println("Number of swaps: " + scientific.format(totalCount));
		printer.append("Swaps per second: " + scientific.format(swapRatio));
		printer.flush();

		// note: printer is not closed here because it will be used again in sortTest.java

	}

	/***********************************************
	METHOD: startTime()
		Use: Capture the current start time
		Parameters: None
	***********************************************/

	public static double startTime(){
		double start = System.nanoTime() / 1000000000.0;

		return start;
	}

	/***********************************************
	METHOD: stopTime()
		Use: Capture the current stop time
		Parameters: None
	***********************************************/

	public static double stopTime(){
		double finish = System.nanoTime() / 1000000000.0;

		return finish;
	}


}
