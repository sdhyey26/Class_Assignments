package Exception;


public class DemoException {

	public static void main(String[] args) throws Exception {

		exception();
	}
	
	public static void exception() throws Exception {
		int number1 = 10;
		int number2 = 0;

		try {

			float result = number1 / number2;

			System.out.println("Division is: " + result);
		} catch (ArithmeticException exception) {

			System.out.println("Divisor can not be zero: Enter some other value");

			System.out.println("Exiting");
		}
		
		finally{
			System.out.println("inside finally block");
		}
	}

}
