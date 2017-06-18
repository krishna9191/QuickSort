import java.util.Comparator;
import java.util.Random;

public class QuickSorter<T> {
	
	T[] mainArray;
	Comparator<T> comp;
	
	QuickSorter(T[] array, Comparator<T> c){
		mainArray = array;
		comp = c;
	}
	
	//base function performing SinglePivot Quick Sort
	//Inputs: 1st and last element indices
	public void SinglePivotQS(int p, int r){
		int q;
		
		if(p < r){
			
			q = partition(p, r);
			SinglePivotQS(p, q - 1);
			SinglePivotQS(q+1, r);
		}
	}
	
	//partition function for SinglePivot Quick Sort
	public int partition(int p, int r){
		
		//randomly select one of the elements in the array as the pivot
		Random rand = new Random();
		int index = rand.nextInt((r - p) + 1) + p;
		
		swap(index, r);
		
		T pivot = mainArray[r];
		int pIndex = p;
		
		//iterate over the unsorted elements. Check if they are less then the pivot.
		for(int i=p; i<r; i++){
			if(comp.compare(mainArray[i], pivot) <= 0){
				swap(i, pIndex);
				pIndex= pIndex + 1;
			}
		}
		
		swap(pIndex, r);
		
		return pIndex;
	}
	
	
	//function to swap two numbers located at index1 and index2
	//INPUT: index1 and index2
	public void swap(int index1, int index2){
		
		T temp;
		
		temp = mainArray[index1];
		mainArray[index1] = mainArray[index2];
		mainArray[index2] = temp;
	}

	//function to print the array of elements
	public void display(){
		
		for(T val : mainArray){
			System.out.print(val.toString() + "\t");
		}
	}
	
	//main function performing Dual Pivot Quick sort
	public void DualPivotPartition(int p, int r){

		if(p > r)
			return;
		
		T pivot1 = mainArray[p];
		T pivot2 = mainArray[r];

		if(comp.compare(pivot1, pivot2) > 0)
			swap(p, r);
		
		int i = p + 1;
		int l = p + 1;
		int j = r - 1;
		
		while(i <= j){
			if(comp.compare(mainArray[i], mainArray[p]) < 0)
				swap(l++, i++);
			
			else if(comp.compare(mainArray[r], mainArray[i]) < 0)
				swap(i, j--);
			else
				i++;
		}
		
		swap(p, --l);
		swap(++j, r);
		
		DualPivotPartition(p, l-1);
		if(comp.compare(mainArray[l], mainArray[j]) < 0){
			DualPivotPartition(l+1, j-1);
		}
		DualPivotPartition(j+1, r);
	}
}
