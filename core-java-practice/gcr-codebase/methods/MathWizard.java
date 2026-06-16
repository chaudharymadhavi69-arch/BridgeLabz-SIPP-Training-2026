public class MathWizard {
    // instance variable
    int number = 10;

    public static void main(String[] args) {
        MathWizard obj = new MathWizard();

        System.out.println("isPrime(17) = " + obj.isPrime(17));
        System.out.println("factorial(5) = " + obj.factorial(5));
        System.out.println("factorial(5.5) = " + obj.factorial(5.5));
        System.out.println("fibonacci(7) = " + obj.fibonacci(7));
        System.out.println("gcd(48, 18) = " + obj.gcd(48, 18));
        System.out.println("lcm(48, 18) = " + obj.lcm(48, 18));
        System.out.println("power(2, 8) = " + obj.power(2, 8));

        int value = 7; // local variable
        obj.showScope(value);
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public double factorial(double n) {
        double result = 1.0;
        for (double i = 2.0; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int first = 0;
        int second = 1;
        int next = 0;

        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return second;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public double power(double base, int exp) {
        double result = 1;
        for (int i = 1; i <= exp; i++) {
            result = result * base;
        }
        return result;
    }

    public void showScope(int value) {
        int total = value + 5; // local variable

        System.out.println("Local value = " + total);
        System.out.println("Instance value = " + number);
        System.out.println("Local variable is used only inside this method.");
    }
}
