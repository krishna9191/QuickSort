This code was implemented in Java JDK 1.8. This folder contains 2 .java files 'Driver.java' (which contains the main method and the instantiation of the generics), and 'QuickSorter.java' which contains the actual implementation for Quick sort.
The folder also contains a 'Report.docx' which gives the details about the comparison of the two algorithms.

To run the code use the commands:
>javac QuickSorter.java Driver.java
>java Driver <length_of_array> <1_or_2>

where:
<length_of_array> is the length of the main array that is to be sorted. The array will be filled with random elements ranging from 0 to 1000
<1_or_2> = enter 1 for Single pivot quicksort, 2 for Dual Pivot Quicksort.

(e.g) java Driver 10000 2

The output of the code is the running time of the respective version of quicksort.

*****The current version of the code is implemented for an Integer datatype. While the QuickSorter.java class, which contains the main logic of Quick sort, is implemented using generics,
	the main class has an instantiated version for running. In order to alter the datatype, replace Integer by any datatype and also override the given compare() method.

