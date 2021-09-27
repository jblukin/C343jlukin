public interface Array2DIntADT {

	public boolean isEmpty();
	
	public void init(int xSize, int ySize);
	
	public int size();
	
	public int get(int xPos, int yPos);
	
	public void delete(int xPos, int yPos);

}