package life;

public class LifeMaker {
	
	public static void addLine(boolean[][] cells, int x1, int y1, int x2, int y2){
		int xs, xe, ys, ye;
		if (x1 == x2){
			if (y1 < y2) {
				ys = y1;
				ye = y2;
			} else {
				ys = y2;
				ye = y1;
			}
			for (int i = ys; i < ye + 1; i++){
				cells[x1][i] = !cells[x1][i];
			}
		} else if (y1 == y2){
			if (x1 < x2){
				xs = x1;
				xe = x2;
			} else {
				xs = x2;
				xe = x1;
			}
			for (int i = xs; i < xe + 1; i++){
				cells[i][y1] = !cells[i][y1];
			}
		}
	}
	
	public static void addBlock(boolean[][] cells, int x, int y){
		int[] xa = {x, x, x + 1, x + 1};
		int[] ya = {y, y + 1, y, y + 1};
		switchCells(cells, xa, ya);
	}
	
	public static void addHorizontalToad(boolean[][] cells, int x, int y){
		addLine(cells, x + 1, y, x + 3, y);
		addLine(cells, x, y + 1, x + 2, y + 1);
	}
	
	public static void addVerticalToad(boolean[][] cells, int x, int y){
		addLine(cells, x, y, x, y + 2);
		addLine(cells, x + 1, y + 1, x + 1, y + 3);
	}
	
	public static void addBlinker(boolean[][] cells, int x, int y){
		addLine(cells, x + 1, y, x + 1, y + 2);
	}
	
	public static void addDRGlider(boolean[][] cells, int x, int y){
		int[] xa = {x, x, x + 1, x + 1, x + 2};
		int[] ya = {y, y + 2, y + 1, y + 2, y + 1};
		switchCells(cells, xa, ya);
	}
	
	public static void addULGlider(boolean[][] cells, int x, int y){
		int[] xa = {x, x + 1, x + 2, x, x + 1};
		int[] ya = {y, y, y, y + 1, y + 2};
		switchCells(cells, xa, ya);
	}
	
	public static void addBeacon(boolean[][] cells, int x, int y){
		int[] xa = {x, x, x + 1, x + 2, x + 3, x + 3};
		int[] ya = {y, y + 1, y, y + 3, y + 2, y + 3};
		switchCells(cells, xa, ya);
	}
	
	public static void addLightweightSpaceShip(boolean[][] cells, int x, int y){
		int[] xa = {x, x, x + 1, x + 2, x + 3, x + 3, x + 4, x + 4, x + 4};
		int[] ya = {y, y + 2, y + 3, y + 3, y, y + 3, y + 1, y + 2, y + 3};
		switchCells(cells, xa, ya);
	}
	
	public static void addHorizontalPentadecathlon(boolean[][] cells, int x, int y){
		addLine(cells, x, y + 1, x + 9, y + 1);
		addLine(cells, x + 2, y, x + 2, y + 2);
		addLine(cells, x + 7, y, x + 7, y + 2);
	}
	
	public static void addVerticalPentadecathlon(boolean[][] cells, int x, int y){
		addLine(cells, x + 1, y, x + 1, y + 9);
		addLine(cells, x, y + 2, x + 2, y + 2);
		addLine(cells, x, y + 7, x + 2, y + 7);
	}
	
	public static void addLoafer(boolean[][] cells, int x, int y){
		int[] xa = {x, x + 1, x + 1, x + 2, x + 2, x + 3, x + 3, x + 5, x + 5, x + 6, x + 6, x + 6, x + 7, x + 7, x + 7, x + 7, x + 8, x + 8, x + 8, x + 8};
		int[] ya = {y + 1, y, y + 2, y, y + 3, y + 1, y + 2, y, y + 6, y + 1, y + 5, y + 7, y, y + 1, y + 5, y + 8, y, y + 4, y + 5, y + 8};
		switchCells(cells, xa, ya);
	}
	
	public static void addTumbler(boolean[][] cells, int x, int y){
		int[] xa = {x, x, x + 1, x + 2, x + 2, x + 2, x + 3, x + 3,
				x + 5, x + 5, x + 6, x + 6, x + 6, x + 7, x + 8, x + 8};
		int[] ya = {y + 1, y + 2, y, y + 1, y + 3, y + 4, y + 2, y + 4,
				y + 2, y + 4, y + 1, y + 3, y + 4, y, y + 1, y + 2};
		switchCells(cells, xa, ya);
	}
	
	public static void addPulsar(boolean[][] cells, int x, int y){
		addLine(cells, x, y + 2, x, y + 4);
		addLine(cells, x, y + 8, x, y + 10);
		addLine(cells, x + 5, y + 2, x + 5, y + 4);
		addLine(cells, x + 5, y + 8, x + 5, y + 10);
		addLine(cells, x + 7, y + 2, x + 7, y + 4);
		addLine(cells, x + 7, y + 8, x + 7, y + 10);
		addLine(cells, x + 12, y + 2, x + 12, y + 4);
		addLine(cells, x + 12, y + 8, x + 12, y + 10);
		
		addLine(cells, x + 2, y, x + 4, y);
		addLine(cells, x + 8, y, x + 10, y);
		addLine(cells, x + 2, y + 5, x + 4, y + 5);
		addLine(cells, x + 8, y + 5, x + 10, y + 5);
		addLine(cells, x + 2, y + 7, x + 4, y + 7);
		addLine(cells, x + 8, y + 7, x + 10, y + 7);
		addLine(cells, x + 2, y + 12, x + 4, y + 12);
		addLine(cells, x + 8, y + 12, x + 10, y + 12);
	}
	
	public static void addGosperGliderGun(boolean[][] cells, int x, int y){
		addBlock(cells, x, y + 4);
		addBlock(cells, x + 34, y + 2);
		int[] xa = {x + 10, x + 10, x + 10,
				x + 11,
				x + 11, x + 12,
				x + 12, x + 13, x + 13,
				x + 14,
				x + 15, x + 15,
				x + 16, x + 16, x + 16,
				x + 17,
				x + 20, x + 20, x + 20,
				x + 21, x + 21, x + 21,
				x + 22, x + 22,
				x + 24, x + 24, x + 24, x + 24};
		int[] ya = {y + 4, y + 5, y + 6,
				y + 3,
				y + 7, y + 2,
				y + 8, y + 2, y + 8,
				y + 5,
				y + 3, y + 7,
				y + 4, y + 5, y + 6,
				y + 5,
				y + 2, y + 3, y + 4,
				y + 2, y + 3, y + 4,
				y + 1, y + 5,
				y, y + 1, y + 5, y + 6};
		switchCells(cells, xa, ya);
	}
	
	public static void addTheRpentomino(boolean[][] cells, int x, int y){
		int[] xa = {x, x + 1, x + 1, x + 1, x + 2};
		int[] ya = {y + 1, y, y + 1, y + 2, y};
		switchCells(cells, xa, ya);
	}
	
	private static void switchCells(boolean[][] cells, int[] x, int[] y){
		if (x.length != y.length) return;
		for (int i = 0; i < x.length; i++){
			cells[x[i]][y[i]] = !cells[x[i]][y[i]];
		}
	}

}
