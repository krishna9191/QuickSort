import java.util.Comparator;
import java.util.Random;

public class Driver {
	
	public static void main(String[] args){
		
		Random rand = new Random();
		int arraySize = Integer.parseInt(args[0]);
		
		Integer[] tempArray = new Integer[arraySize];
		for(int i=0; i< arraySize; i++){
			tempArray[i] = rand.nextInt((10000 - 0) + 0);
		}
		
		QuickSorter<Integer> qs = new QuickSorter<Integer>(tempArray, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
					return arg0.compareTo(arg1);
			}
		});
		
		long start = System.currentTimeMillis();
		
		if(args[1].compareTo("1") == 0)
			qs.SinglePivotQS(0, tempArray.length-1);
		
		else
			qs.DualPivotPartition(0, tempArray.length - 1);
		
		long end = System.currentTimeMillis();
		
		System.out.println("Running time = " + (end - start));
	}

}
