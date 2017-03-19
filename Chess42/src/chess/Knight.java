package chess;

public class Knight extends ChessPiece{
	
	public Knight(String color, int x, int y) {
		
		this.type = "Knight";
		this.x = x;
		this.y = y;
		this.color = color;
				
		this.name = color.equalsIgnoreCase("White")? "wN" : "bN";
		this.location = column[y]+rows[Math.abs((rows.length-1)-x)];
	}
	
	
	public boolean check(ChessPiece[][] board) {
		boolean passDown = false, passUp = false, rightSide = false, leftSide = false;
		
		int downJump = this.x +2;
		passDown = downJump <=7 ? true :false;
		
		int upJump = this.x -2;
		passUp = upJump >= 0 ? true : false;
		
		
		int rightJump = this.y +2 ;
		rightSide = rightJump <= 7 ? true : false;
		
		int leftJump = this.y -2;
		leftSide = leftJump >=0 ? true : false;
		
		
		if (passDown){ // checking down moves for king
			
			
			
			if (this.y < 7) { // down right side check
				
					
				
				if (checkJumps(board,downJump, y+1, 0)){
					
					return true;
			}
				
			}
			if (this.y >0 ){ // checked down left side
				
				
				if (checkJumps(board,downJump, y-1, 0)){
					
						return true;
				}
			}
			
		} //chcked all possible down moves
		
		if (passUp){ //checking all possible up moves
			
			
			if (this.y <7){ //checking upper right move 
				
				

				if (checkJumps(board,upJump, y+1, 0)){
					
					return true;
			}
				
			}
			
			if (this.y > 0){
				

				if (checkJumps(board,upJump, y-1, 0)){
					
					return true;
				}
				
			}
			
			
		}
		
		if (rightSide){ //checks both ride sides move for king
			
			if (this.x >0){ // right side up
				
				
				
					if (checkJumps(board,rightJump, x-1, 1)){
					
						return true;
					}
				
			}
			if (this.x<7){ // right side down
				
				
				if (checkJumps(board,rightJump, x+1, 1)){
					
					return true;
				}
			}
		}
		
		if (leftSide){
			
			
			if (this.x >0){ // left side up
				
				
				
				if (checkJumps(board,leftJump, x-1, 1)){
					
					return true;
				}
			}
			if (this.x<7){ // left side down
				
				
				
				if (checkJumps(board,leftJump, x+1, 1)){
					
					return true;
				}
			
			
		}
			
		}
		
		
		
		
		return false;
	}
	
	
	public boolean move(ChessPiece[][] board, int x, int y) {
		
		boolean moveVertical = false, moveHorizontal = false;
		
		int differenceX = Math.abs(this.x - x); // the differnce in new cordinate of x and current cordinate of x
		int differenceY = Math.abs(this.y - y); // the difference in new cordinte of y and current cordinate of y
		
		if (differenceX ==1 && differenceY == 2){ // if the differnce is (1,2) of the current and the new cordinate. means move horizontally
			
			moveHorizontal = true;
		}
		else if (differenceX == 2 && differenceY == 1){ // if the differnce is (2,1) of the current and the new cordinates. means move vertically
			
			moveVertical = true;
		}
		
		//have the direction at this point
		
		boolean output = false;
		
		if (moveHorizontal || moveVertical){ // if no possible move was found
			
			/**
			 * two possiblility for legal moves are
			 * the new position is empty
			 * or the new position contains piece of opposite colo
			 */
			output = (board[x][y] == null )
					||((board[x][y]!= null) && !( board[x][y].color.equalsIgnoreCase(this.color)));
		}
		
		if (!output){
			
			System.out.println("Illegal move, try again");
		}
		
		return output;
	}
	
	
	
	public boolean checkJumps(ChessPiece[][] board,int jump , int cordinate, int decisionVariable ){
		
		
		if (decisionVariable == 0){
			
			
			if (board[jump][cordinate] != null 
					&& board[jump][cordinate].type.equalsIgnoreCase("King")
					&& !(board[jump][cordinate].color.equalsIgnoreCase(this.color))){
					
					return true;
				}
			
		}
		
		else{
			
			
			if (board[cordinate][jump]!=null
					&& board[cordinate][jump].type.equalsIgnoreCase("King")
					&& (!board[cordinate][jump].color.equalsIgnoreCase(this.color))){
					
					return true;
				}		
			
			
		}
		
		return false;
	}
	
	
	

}