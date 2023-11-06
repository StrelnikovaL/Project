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
}