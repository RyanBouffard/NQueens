package nQueens;

public class Square {
	//properties
	private int threats;
	private int placedQueen;
	
	public Square(int t, int pq) {
		this.threats = t;
		this.placedQueen = pq;
	}
	
	
	public void setThreats(int threats) {
		this.threats = threats;				
	}
	
	public int getThreats() {
		return this.threats;			
	}
	
	
	public void setPlacedQueen(int placedQueen) {
		this.placedQueen = placedQueen;				
	}
	
	public int getPlacedQueen() {
		return this.placedQueen;			
	}
	
	public String toString() {				// string representation of square, 0 or 1
		return (Integer.toString(this.placedQueen));
	}

	
}
