import java.util.Scanner;
public class Seabattle {
	public static void main(String[] args) {
		int SIZE_OF_FIELD = 10;
		Scanner sc = new Scanner(System.in);
		Functions.hello();
		System.out.println("Чтобы начать игру, введите enter");
		String line = sc.nextLine();
		String name1 = "";
		String name2 = "";
		if (line.equals("")) {
			System.out.println("игрок 1, введите своё имя "); // тут должно быть имя игрока
			name1 = sc.nextLine();
			System.out.println("игрок 2, введите своё имя ");
			name2 = sc.nextLine();
		}
		else {
			// тут должен быть какой-то текст, что имя введено неверно
		}
		int [][] coords1 = Functions.fill_coords(SIZE_OF_FIELD, sc); // игрок 1 введите координаты - текст
		int [][] coords2 = Functions.fill_coords(SIZE_OF_FIELD, sc);
		
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
			if (Functions.end(coords1)) {
				System.out.println("игрок 2 победил!");
				break;
			}
			if (Functions.end(coords2)) {
				System.out.println("игрок 1 победил!");
				break;
			}
			if (c == 1) {
				System.out.println("игрок 1, ваш ход: ");
				String coord = sc.nextLine();
				int column = Functions.symbol(coord.charAt(0));
				int row = 10;
				if (coord.length() != 3) {
					row = Integer.parseInt(String.valueOf(coord.charAt(1)));
				}
				//System.out.println(column);
				//System.out.println(row);
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
				int column = Functions.symbol(coord.charAt(0));
				int row = 10;
				if (coord.length() != 3) {
					row = Functions.symbol(coord.charAt(1));
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