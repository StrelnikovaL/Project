import java.util.Scanner;
public class Seabattle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Functions.hello();
		System.out.println("Чтобы начать игру, введите Go");
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
		System.out.println ();
		System.out.println ("Начинается расстановка флота");
		System.out.println ();
		System.out.println(name1 + " сейчас расставляет корабли");
		int [][] coords1 = Functions.fill_coords(sc); // игрок 1 введите координаты - текст
		System.out.println (name1 + " расставил флот");
		System.out.println ();
		System.out.println(name2 + " сейчас расставляет корабли");
		int [][] coords2 = Functions.fill_coords(sc);
		System.out.println (name2 + "расставил флот");
		System.out.println ();
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
				while (!Functions.rightCoordinate(coord)) {
					System.out.println("Введённые данные не являются координатами. Введите координаты в формате \"Буква+цифра через пробелы\"");
					coord = sc.nextLine();
				}
				int column = Functions.symbol(coord.charAt(0));
				int row = 10;
				if (coord.length() != 3) {
					row = Integer.parseInt(String.valueOf(coord.charAt(1)));
				}
				if (coords2[row][column] == 2) { // попадание
					c = 1;
					coords2[row][column] = 1;
					Functions.fieldPlay(coords2);
				}
				else {
					c = 0;
					coords2[row][column] = -1;
					Functions.fieldPlay(coords2);
				}
				
				
			}
			else if (c == 0) {
				System.out.println("игрок 2, ваш ход: ");
				String coord = sc.nextLine();
				while (!Functions.rightCoordinate(coord)) {
					System.out.println("Введённые данные не являются координатами. Введите координаты в формате \"Буква+цифра через пробелы\"");
					coord = sc.nextLine();
				}
				int column = Functions.symbol(coord.charAt(0));
				int row = 10;
				if (coord.length() != 3) {
					row = Integer.parseInt(String.valueOf(coord.charAt(1)));
				}
				if (coords1[row][column] == 2) { // попадание
					c = 0;
					coords1[row][column] = 1;
					Functions.fieldPlay(coords1);
				}
				else {
					c = 1;
					coords1[row][column] = -1;
					Functions.fieldPlay(coords1);
				}
			}
		}
		
	}
}