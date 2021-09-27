import java.util.ArrayList;
import java.util.List;

public class Array2DInt implements Array2DIntADT {
	
	int[][] array2D;
	
	public boolean isEmpty() {
		
		for (int i = 0; i < array2D.length; i++) {
			
			for (int j = 0; j < array2D[0].length; j++) {
				
				if (array2D[i][j] != 0)
					return false;
				
			}
			
		}
		
		return true;
		
	}
	
	public void init(int xSize,int ySize) {
		
		array2D = new int[xSize][ySize];
	
	}
	
	public int size() {
		
		int count = 0;
		
		for (int i = 0; i < array2D.length; i++) {
			
			for (int j = 0; j < array2D[0].length; j++) {
				
					count++;
					
			}
			
		}
		
		return count;
		
	}
	
	public int get(int xPos, int yPos) {
		
		return array2D[xPos][yPos];
		
	}
	
	public void delete(int xPos, int yPos) {
		
		array2D[xPos][yPos] = 0;
	
	}
	
	public void set(int xPos, int yPos, int element) {
		
		array2D[xPos][yPos] = element;
		
	}
	
	public void setElementsToZero() {
		
		for (int i = 0; i < array2D.length; i++) {
			
			for (int j = 0; j < array2D[0].length; j++) {
				
				set(i,j,0);
				
			}
			
		}
		
	}
	
	public Array2DInt() {
		
		init(0,0);
		
	}
	
	public Array2DInt(int xSize, int ySize) {
		
		init(xSize, ySize);
		
	}
	
	public int[] columnGet(int columnIndex) {
		
		int[] column = new int[array2D.length];

		for(int i = 0; i < array2D.length; i++) {
			
			column[i] = array2D[i][columnIndex];
			
		}
		
		return column;
		
	}
	
	public void columnSet(int columnIndex, int[] elements) {
		
		for(int i = 0; i < array2D.length; i++) {
			
			array2D[i][columnIndex] = elements[i];
			
		}
		
	}
	
	public int[] rowGet(int rowIndex) {
		
		int[] row = new int[array2D.length];
		
		for(int i = 0; i < array2D[0].length; i++) {
			
			row[i] = array2D[rowIndex][i];
			
		}
		
		return row;
		
	}
	
	public void rowSet(int rowIndex, int[] elements) {
		
		for(int i = 0; i < array2D[0].length; i++) {
			
			array2D[rowIndex][i] = elements[i];
			
		}
		
	}
	
	public void print() {
		
		for (int i = 0; i < array2D.length; i++) {
			
			for (int j = 0; j < array2D[0].length; j++) {
				
				System.out.print(array2D[i][j]);
				
			}
			
			System.out.println();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Array2DInt myArray2D = new Array2DInt();
		
		myArray2D.init(5,5);
		
		myArray2D.setElementsToZero();
		
		myArray2D.print();
		
		System.out.println();
		
		myArray2D.set(1,1, 8);
		
		myArray2D.print();
		
		System.out.println();
		
		myArray2D.set(2,4, 5);
		
		myArray2D.print();
		
		System.out.println();
		
		myArray2D.set(0,3, 9);
		
		myArray2D.print();
		
		System.out.println();
		
		int[] row = {2,3,4,5,6};
		
		myArray2D.rowSet(4, row);
		
		myArray2D.print();
		
		System.out.println();
		
		int[] row2 = {5,4,3,2,1};
		
		myArray2D.rowSet(3, row2);
		
		myArray2D.print();
		
		System.out.println();
		
		int[] rowGet = myArray2D.rowGet(3);
		
		System.out.print("rowGet(3): ");
		
		for (int i: rowGet) {
			System.out.print(i);
		}
		
		System.out.println();
		
		rowGet =  myArray2D.rowGet(0);
		
		System.out.print("rowGet(0): ");
		
		for (int i: rowGet) {
			System.out.print(i);
		}
		
		System.out.println();
		System.out.println();
		
		int[] column = {2,3,9,1,8};
		
		myArray2D.columnSet(0, column);
		
		myArray2D.print();
		
		System.out.println();
		
		int[] column2 = {4,3,6,7,7};
		
		myArray2D.columnSet(2, column2);
		
		myArray2D.print();
		
		System.out.println();
		
		int[] columnGet = myArray2D.columnGet(3);
		
		System.out.print("columnGet(3): ");
		
		for (int i: columnGet) {
			System.out.print(i);
		}
		
		System.out.println();
		
		columnGet =  myArray2D.columnGet(0);
		
		System.out.print("columnGet(0): ");
		
		for (int i: columnGet) {
			System.out.print(i);
		}
		
		
		
		
	}
	
}