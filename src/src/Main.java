import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Calculator");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение формата a + b, принимаются целые числа от 1 до 10, римские от I до X, операции +, -, *, /");
        String input = scan.nextLine();
        input = input.toUpperCase();
        String[] inputs = input.split(" ");
        if (Pattern.matches("^(\\d{1,3})\\s[-+/*]\\s(\\d{1,3})$", input))  {
            calc(input);
        } else if (Pattern.matches("^([I, V, X]{0,3})\\s[-+/*]\\s([I, V, X]{0,3})$", input)) {
            calcR(input);
        } else throw new Exception("Неверный формат ввода либо недопустимое римское число");

    }
        public static String calc(String input) throws Exception {
            getArabResult(input);
            return input;
        }
        public static String calcR(String input) throws Exception {
            getRomanResult(input);
            return input;
        }
        public static void getArabResult(String input) throws Exception {
                String[] opers = input.split(" ");
                int a, b;
                a = Integer.parseInt(opers[0]);
                b = Integer.parseInt(opers[2]);
                if (a < 1 || a > 10 || b < 1 || b > 10) {
                    throw new Exception("Одно из чисел меньше 1 или больше 10, повторите ввод");
                }

                switch (opers[1]) {
                    case ("+"):
                        System.out.println("Результат операции: " + (a + b));
                        break;
                    case ("-"):
                        System.out.println("Результат операции: " + (a - b));
                        break;
                    case ("*"):
                        System.out.println("Результат операции: " + (a * b));
                        break;
                    case ("/"):
                        System.out.println("Результат операции: " + (a / b));
                        break;
                    default:
                        throw new Exception("Некорректный оператор, повторите ввод");
                }
            }

        public static String getRomanResult(String input) throws Exception {
            String[] opers = input.split(" ");
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            int a = 0, b = 0, result = 0;
            String c, d;
            c = opers[0];
            d = opers[2];
            switch (opers[0]) {
                case ("I"): a = 1;break;
                case ("II"): a = 2;break;
                case ("III"): a = 3;break;
                case ("IV"): a = 4;break;
                case ("V"): a = 5;break;
                case ("VI"): a = 6;break;
                case ("VII"): a = 7;break;
                case ("VIII"): a = 8;break;
                case ("IX"): a = 9;break;
                case ("X"): a = 10;break;
            }
            switch (opers[2]) {
                case ("I"): b = 1;break;
                case ("II"): b = 2;break;
                case ("III"): b = 3;break;
                case ("IV"): b = 4;break;
                case ("V"): b = 5;break;
                case ("VI"): b = 6;break;
                case ("VII"): b = 7;break;
                case ("VIII"): b = 8;break;
                case ("IX"): b = 9;break;
                case ("X"): b = 10;break;
            }
            switch (opers[1]) {
                case ("+"):
                    result = a + b;
                    break;
                case ("-"):
                    result = a - b;
                    break;
                case ("*"):
                    result = a * b;
                    break;
                case ("/"):
                    result = a / b;
                    break;
                default:                    throw new Exception("Некорректный оператор, повторите ввод");
            }
            if (result <= 0) throw new Exception("Результат операции меньше либо равен 0");
            String romnum = roman[result];
            System.out.println("Результат операции: " + romnum);
            return romnum;
        }
    }


