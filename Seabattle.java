import java.util.Scanner;
public class Seabattle {
	public static void main(String[] args) {
		int SIZE_OF_FIELD = 10;
		Scanner sc = new Scanner(System.in);
		int [][] coords1 = fill_coords(SIZE_OF_FIELD, sc);
		int [][] coords2 = fill_coords(SIZE_OF_FIELD, sc);
		/*System.out.println(coords1.length);
		System.out.println(coords2.length);
		for (int i = 0; i < 11; i ++) {
			for (int j = 0; j <11; j ++) {
				System.out.print(coords2[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}*/
		// теперь нужно написать сам ход игры, попадание/не попадание, передача хода и вывод поля
		int c = 1;
		while (true) {
			if (end(coords1)) {
				System.out.println("игрок 2 победил!");
				break;
			}
			if (end(coords2)) {
				System.out.println("игрок 1 победил!");
				break;
			}
			if (c == 1) {
				System.out.println("игрок 1, ваш ход: ");
				String coord = sc.nextLine();
				int column = symbol(coord.charAt(0));
				int row = 10;
				if (coord.length() != 3) {
					row = Integer.parseInt(String.valueOf(coord.charAt(1)));
				}
				System.out.println(column);
				System.out.println(row);
				if (coords2[row][column] == 2) { // попадание
					c = 1;
					coords2[row][column] = 1;
					Functions.field(coords2, "X", 1);
				}
				else {
					c = 0;
					coords2[row][column] = -1;
					Functions.field(coords2, "O", -1);
				}
				
				
			}
			else if (c == 0) {
				System.out.println("игрок 2, ваш ход: ");
				String coord = sc.nextLine();
				int column = symbol(coord.charAt(0));
				int row = 10;
				if (coord.length() != 3) {
					row = symbol(coord.charAt(1));
				}
				if (coords1[row][column] == 2) { // попадание
					c = 0;
					coords1[row][column] = 1;
					Functions.field(coords1, "X", 1);
				}
				else {
					c = 1;
					coords1[row][column] = -1;
					Functions.field(coords1, "O", -1);
				}
			}
		}
		
	}
}