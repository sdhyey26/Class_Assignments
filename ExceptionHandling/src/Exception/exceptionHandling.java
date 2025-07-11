package Exception;

public class exceptionHandling {

	public static void main(String[] args) {

		int number1 = Integer.parseInt(args[0]);
		int number2 = Integer.parseInt(args[1]);

		try {

			float result = number1 / number2;

			System.out.println("Division is: " + result);
		} catch (ArithmeticException exception) {

			System.out.println("Divisor can not be zero: Enter some other value");

			System.out.println("Exiting");
		}
	}
}
