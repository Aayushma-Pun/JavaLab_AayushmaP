import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator stub = (Calculator) registry.lookup("CalcService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("Addition: " + stub.add(a, b));
            System.out.println("Subtraction: " + stub.sub(a, b));
            System.out.println("Multiplication: " + stub.mul(a, b));
            System.out.println("Division: " + stub.div(a, b));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}