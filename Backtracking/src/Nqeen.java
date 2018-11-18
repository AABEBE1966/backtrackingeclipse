
public class Nqeen {

	final int N=4;

	boolean isSafe(int[][]mat, int row, int col) {
		
		if(row>N || col>N) return true;
		
		for(int i=0; i<col;i++) {
			if(mat[row][i]==1) return false;	
		}
		
		for(int i=row,j=col;i>=0 && j>=0; i--,j--) {
			if(mat[i][j]==1) return false;	
		}
		 
		for(int i=row,j=col; i>=0 && i<N && j >=0; i++,j--) {
			if(mat[i][j]==1) return false;
		}
		return true;
	}
	
	boolean solver(int[][] in,int col ) {
		
		if(col>=N) return true;
		
		for(int i=0; i<N; i++) {
			
			if(isSafe(in,i,col)) {
			in[i][col]=1;	
			
			if(solver(in,col+1)==true) {
				return true;
			}
			in[i][col]=0;
			}	
		}
		
		return false;
	}
	
	public void printSolution(int[][] mat) {
		// TODO Auto-generated method stub
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
					System.out.print(" " + mat[i][j]+ " ");	
			}
			System.out.println();
		}
	}
	
	boolean solve() {
		int[][] mat= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		if (solver(mat,0) == false){
			System.out.println("NO solution exist");
			return false;
		}
		else  {
			printSolution(mat);
			return true;
		}
		//return false;
	}
	 public static void main(String args[]) 
	    { 
	        Nqeen Queen = new Nqeen(); 
	        Queen.solve(); 
	    } 	
	
}
