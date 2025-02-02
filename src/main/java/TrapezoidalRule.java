import java.util.function.Function;

public class TrapezoidalRule {


    public static double integrate(Function<Double, Double> f, double a, double b, int n) {
        double h = (b - a) / n; // Step size
        double sum = 0.5 * f.apply(a) + 0.5 * f.apply(b); // Endpoints contribution

        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            sum += f.apply(xi);
        }

        return h * sum;
    }

    public static void main(String[] args) {

        Function<Double, Double> f = x -> 1 / (1 + x * x);


        double a = 0;
        double b = 1;
        int n = (int) ((b - a) / (1.0 / 4));

        double result = integrate(f, a, b, n);
        System.out.println("Trapezoidal rule (h = 1/4): " + result);
    }
}
