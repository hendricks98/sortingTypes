import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

// sortTest class is a class used to run tests on different sorting algorithms
// and return metrics on said algorithms

public class sortTest extends SortTools {

	static int[] unsortedNumbers;

	//objects used to sort with corresponding algorithms
	static BubbleSort bubble = new BubbleSort();
	static SelectionSort selection = new SelectionSort();

	public static void main(String[] args) throws IOException {

		System.out.println("\n");
		System.out.println("Enter size of array to be sorted: ");

		// Scanner object to retrieve how many numbers the user wants to sort
		Scanner keyIn = new Scanner(System.in);
		int sampleSize = keyIn.nextInt();

		// Init objects that will be used throughout the program
		SortTools toolkit = new SortTools();
		rawOut = new File("output.txt");
		printer = new PrintWriter(rawOut);

		// generate an array to be sorted by
		// each sorting algorithm
		int[] unsortedNumbers = toolkit.preRun(sampleSize);
		int[] bubbleSet = new int[sampleSize];
		int[] selectionSet = new int[sampleSize];

		// create arrays specific for each sort
		// to avoid changing the original
		// unsorted array
		for (int i = 0; i < sampleSize; i++){

			bubbleSet[i] = unsortedNumbers[i];
			selectionSet[i] = unsortedNumbers[i];

		}

		// Sort and print stats to STDOUT as well as output file
		printer.println("(BUBBLE SORT STATS)");
		int[] sorted = bubble(bubbleSet);


		printer.print("\n\n");
		System.out.print("\n");
		System.out.print("\n");

		// Sort and print stats to STDOUT as well as output file
		printer.println("(SELECTION SORT STATS)");
		selection(selectionSet);

		printer.print("\n\n");

		// print unsorted and sorted array to raw output File
		printer.println("UNSORTED ARRAY:\n");
		for (int i = 0; i < unsortedNumbers.length; i++) {
			printer.print(unsortedNumbers[i] + " ");
		}
		printer.print("\n\n");
		toolkit.printArrayOut(sorted);
		printer.close();
	}

	/***********************************************
	METHOD: bubble(int[] set)
		Use: Alerts the user that the sort is running,
			then creates a bubble sort object to run
			the sort
		Parameters:
			set: an array of unosrted numbers
	***********************************************/

	public static int[] bubble(int[] set){
		System.out.println("(RUNNING BUBBLE SORT)\n");
		bubble.sort(set);

		return set;
	}

	/***********************************************
	METHOD: selection(int[] set)
		Use: Alerts the user that the sort is running,
			then creates a selection sort object to
			run the sort
		Parameters:
			set: an array of unosrted numbers
	***********************************************/

	public static int[] selection(int[] set){
		System.out.println("(RUNNING SELECTION SORT)\n");
		selection.sort(set);

		return set;
	}

}
