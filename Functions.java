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
		Pattern p = Pattern.compile("[A-Z]([1-9]|10)([ ][A-Z]([1-9]|10)){0,3}");
		Matcher m = p.matcher(s);
		return m.matches();
	}
	public static void field (int[][] array, String symbol) {
		String letter = "ABCDEFGHIJ";
		for (int i = 0; i <= 10; i++){
			for (int j = 0; j <= 10; j++) {
				if (array[j][i] == 1) {
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
}