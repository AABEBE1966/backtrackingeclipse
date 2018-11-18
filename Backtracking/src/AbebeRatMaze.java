
public class AbebeRatMaze {

	final int N=4;// defining the size of the square matrix
	boolean isSafe(int maze[][], int x, int y) {//check if the current 
		//point in the matrix is valid along with its indices
	
		return (x<N &&x>=0 && y>=0 && y<N && maze[x][y]==1); 	
	}
	
	void printSolution(int sol[][]) //a method to print the anwer
	{ 
		for (int i = 0; i < N; i++) 
		{ 
			for (int j = 0; j < N; j++) {
				System.out.print(" " + sol[i][j] + //prints the rows with columns
								" "); 
			}
			System.out.println(); 
		} 
	} 
	
	public boolean answer(int[][]maze) {
		
		int[][] ans= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		if(solveProb(maze,0,0,ans)==true) {//it begins with 0 ,0 and check if there is a possible solution in the maze
			// and print the values in the ans-an empty matrix;
			printSolution(ans);
			return true;
		}
		
		else {
			System.out.println("NO solution exist");
			return false;
		}	
	}
	/**
	 * 
	 * @param maze is the input matrix that we are looking any possible path in it.
	 * @param x row index
	 * @param y column index
	 * @param ans is the answer matrix with values 1 and 0 based on the the possibility of the path. will have
	 *  one if the path is possible and 0 if the path is not possible.
	 * @return
	 */
	public boolean solveProb(int[][]maze,int x,int y,int ans[][]){
		//int[][] ans= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		if(x==N-1 && y==N-1) {//If the index of x and y are at the end of the matrix, we reach at the exit location
			ans[x][y]=1;
			return true;
		}
			
		if(isSafe(maze, x,y)) {//if the value sof the amze at the speacific x and y are 1, we assign the values//
			//at the maze index with 1 and continue with the recursive call
			
			ans[x][y]=1;
			
			if(solveProb(maze,x+1,y,ans)) return true;
			if(solveProb(maze,x,y+1,ans)) return true;
			ans[x][y]=0;
			return false;//if it's safe but the recursive call does not reach at the N-1 index, it will give the ans
			//  values 0
		}
		return false;	//return false if the matrix isnot safe 
	}
	
public static void main(String[] args)	{
	
	int[][] inPut= {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
	AbebeRatMaze abebe=new AbebeRatMaze();
	abebe.answer(inPut);
	
}
	
	
}
