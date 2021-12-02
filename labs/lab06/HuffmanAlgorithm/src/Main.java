import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	static int comparisons;
	static int SENTINEL = -1; //no elements will be < 0
	
	static int[] A, L, R;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int maxSize = 500000; //total integers cannot pass 500000
		
		File file = new File("C:\\Users\\jbluk\\OneDrive\\Documents\\IU\\Fall 2021\\C343 Data Structures\\File.txt");
		
		Scanner scanner = new Scanner(file);
		
		int n = scanner.nextInt();

		A = new int[maxSize];
		L = new int[maxSize/2 + 1]; //left half array
		R = new int[maxSize/2 + 1]; //right half array

		for(int i = 0; i < n; i++) {

			A[i] = scanner.nextInt();
			System.out.print(A[i] + " ");

		}

		mergeSort(A, 0, n);

//		for(int i = 0; i < n; i++) {
//
//			System.out.print(A[i] + " ");
//
//		}
//
//		System.out.println();
//		System.out.print(n);
		
	}
	
	public static void mergeSort(int[] A, int l, int r) {
		
		if(l + 1 < r) {
			
			int mid = (l + r) / 2;
			
			mergeSort(A, l, mid);
			mergeSort(A, mid, r);
			merge(A, mid, l, r);
			
		}
		
	}
	
	public static void merge(int[] A, int mid, int l, int r) {
		
		int n1 = mid - l;
		int n2 = r - mid;
		
		for(int i = 0; i < n1 ;i++) {
			
			L[i] = A[l + i];
		}
		
		for(int i = 0; i < n2; i++) {
			
			R[i] = A[mid + i];
			
		}
		
		L[n1] = SENTINEL;
		R[n2] = SENTINEL;
		
		int i = 0;
		int j = 0;
		
		for(int c = l; c < r; c++) {
			
			
			if(L[i] <= R[j]) {
				
				A[c] = L[i++];
				
			} else {
				
				A[c] = R[j++];
				
			}
			
			comparisons++;
			
		}
		
	}
	
}