import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Условие:
 * Написать на Java программу распаковывания строки. На вход поступает строка вида число[строка],
 * на выход - строка, содержащая повторяющиеся подстроки.
 *
 * Пример:
 * Вход: 3[xyz]4[xy]z
 * Выход: xyzxyzxyzxyxyxyxyz
 *
 * Ограничения:
 * - одно повторение может содержать другое. Например: 2[3[x]y]  = xxxyxxxy
 * - допустимые символы на вход: латинские буквы, числа и скобки []
 * - числа означают только число повторений
 * - скобки только для обозначения повторяющихся подстрок
 * - входная строка всегда валидна.
 *
 * Дополнительное задание:
 * Проверить входную строку на валидность.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "\\d\\[[a-z]+\\]";
        String str = "";
        int n = 0;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (input.matches("[" + regex + "]+")) {
            while (matcher.find()) {
                n = Character.getNumericValue(input.charAt(matcher.start()));
                str = matcher.group().repeat(n);
                str = str.replaceAll("[\\d\\[\\]]", "");
                input = input.replaceFirst(regex, str);
                matcher.reset(input);
            }
            System.out.println(input);
        } else {
            System.out.println("INVALID INPUT");
        }
    }
}
