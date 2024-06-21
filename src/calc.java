import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = scanner.nextLine();

        try {
            int result = calculate(expression);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int calculate(String expression) throws Exception {
        String[] parts = expression.split(" ");

        if (parts.length != 3) {
            throw new Exception("Некорректный формат ввода. Ожидается 'a <операция> b'.");
        }

        int a;
        int b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Некорректный формат чисел. Числа должны быть целыми числами от 1 до 10 включительно.");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно.");
        }

        String operator = parts[1];
        int result;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль невозможно.");
                }
                result = a / b;
                break;
            default:
                throw new Exception("Некорректная операция. Допустимые операции: +, -, *, /.");
        }

        return result;
    }
}

