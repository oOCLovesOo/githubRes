package leetCodeProj.normal;

public class SurroundedRegions130 {

	public void solve(char[][] board) {
		if(board.length<1) {
			return;
		}
		int boardHigh = board.length;
		int boardWid = board[0].length;
		char[][] resMap = new char[boardHigh][boardWid];

		for (int j = 0; j < boardHigh; j++) {
			for (int i = 0; i < boardWid; i++) {
				resMap[j][i] = 'X';

			}
		}
		
		for (int j = 0; j < boardHigh; j++) {
			for (int i = 0; i < boardWid; i++) {
				if ( 	board[j][i]=='O'
						&&(i == 0 || j == 0 || j == boardHigh - 1 || i == boardWid - 1)) {
					DropIn(i, j, resMap, board);
				}
			}
		}

		
		board = resMap;
		for (int j = 0; j < boardHigh; j++) {
			for (int i = 0; i < boardWid; i++) {
				System.out.print(board[j][i]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * 以一个节点开始，往上下左右四个方向开始下探
	 * 
	 */
	public static void DropIn(int x, int y, char map[][], char[][] board) {
		if (map[y][x] == 'O' || board[y][x] == 'X') {
			return;
		}

		map[y][x] = 'O';

		// 上，右，下，左
		if (y - 1 >= 0) {
			DropIn(x, y - 1, map, board);
		}
		if (x + 1 < board[0].length) {
			DropIn(x + 1, y, map, board);
		}
		if (y + 1 < board.length) {
			DropIn(x, y + 1, map, board);
		}
		if (x - 1 >= 0) {
			DropIn(x - 1, y, map, board);
		}

	}

	public static void main(String[] args) {
		char[][] board = { 
						   { 'X','X','X','X'}, 
						   { 'X','O','O','X'},
						   { 'X','X','O','X'},
						   { 'X','O','X','X'}
						 };
		new SurroundedRegions130().solve(board);
		
	}

}
