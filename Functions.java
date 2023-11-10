import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Functions {
	public static void hello() {
		System.out.println("Добро пожаловать в игру Морской бой!");
		System.out.println("Правила игры: Оба игрока расставляют “флот” на поле 10X10 клеток.\n" +
		"Каждый игрок может поставить 4 однопалубных корабля, 3 двухпалубных, 2 трехпалубных и 1 четырёхпалубный.\n" +
		"Корабли можно располагать только по горизонтали или по вертикали.\n" +
		"игроки не видят расположение кораблей друг друга.");
	}
	public static boolean rightCoordinate(String s) {
		Pattern p = Pattern.compile("[A-J]([1-9]|10)([ ][A-J]([1-9]|10)){0,3}");
		Matcher m = p.matcher(s);
		return m.matches();
	}
	/*public static boolean there 
	else if (coords [row][column] == 1) { //если на этом месте уже поставден корабль, мы это выводим
						System.out.println("Already stand");
						i--;*/
	public static void field (int[][] array, String symbol, int designation) {
		String letter = "ABCDEFGHIJ";
		for (int i = 0; i <= 10; i++){
			for (int j = 0; j <= 10; j++) {
				if (array[i][j] == designation) {
					System.out.print("| " + symbol + " ");
				}
			    else if (j >= 1 && i == 0) {
					System.out.print("| " + letter.charAt(j-1) + " ");
				}
				else if (j == 0 && i >= 1) {
					if (i == 10) {
						System.out.print("| " + i);
					}
					else {
					System.out.print("| " + i + " ");
					}
					
				}
				else {
					System.out.print("|   ");
				}
			}
			System.out.println();
			for (int k = 0; k <= 10; k++) {
				System.out.print(" ---");
			}
			System.out.println();
		}
	}
	public static int symbol(char c) {
		String alf = "ABCDEFGHIJ";
		for (int i = 0; i < alf.length(); i ++) {
			if (alf.charAt(i) == c) {
				return i+1;
			}
		}
		return c;
	}
	public static int[][] fill_coords(int SIZE_OF_FIELD, Scanner sc) {
		int c1 = 4;
		int c2 = 3;
		int c3 = 2;
		int c4 = 1;
		int [][] coords = new int [SIZE_OF_FIELD+1][SIZE_OF_FIELD+1];
		int i = 0;
		while (i < 10) { // кол-во кораблей
			String q = sc.nextLine();
			String[] parts = q.split(" "); // считываем координаты, определяем, сколько палуб у корабля
			// где-то здесь должен быть вывод поля
			if (parts.length == 4) {
				c4 -= 1;
			}
			else if (parts.length == 3) {
				c3 -= 1;
			}
			else if (parts.length == 2) {
				c2 -= 1;
			}
			else if (parts.length == 1) {
				c1 -= 1;
			}
			for (String x: parts) { // пробегаемся по координатам A1 A2 ... 
				int column = symbol(x.charAt(0));
				int row = 10;
				if (x.length() != 3) {
					row = Integer.parseInt(String.valueOf(x.charAt(1))); // преобразовать char в int
				}
				coords[row][column] = 2; // первый столбец и первую строку не трогаем
				// проверка на правильность введения
				// нужно каждую координату (буква + цифра) проверить на расстановку
				// если допустимая - записать в массив координат
			}
			i ++;
		}
		return coords;
		
	}
	public static boolean end(int [][] array) {
		boolean flag = true;
		for (int i = 0; i <array.length; i ++) {
			for (int j = 0; j < array.length; j ++) {
				if (array[i][j] == 2) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	
}