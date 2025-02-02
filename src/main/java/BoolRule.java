import java.util.function.Function;

public class BoolRule {
    public static double booleRule(Function<Double, Double> f, double a, double b, int n) {
        if (n % 4 != 0) {
            throw new IllegalArgumentException("The number of subintervals (n) must be a multiple of 4.");
        }
        double h = (b - a) / n;
        double integral = 0;

        for (int i = 0; i < n; i += 4) {
            integral += (2 * h / 45) * (
                    7 * f.apply(a + i * h) + 32 * f.apply(a + (i + 1) * h) + 12 * f.apply(a + (i + 2) * h) +
                            32 * f.apply(a + (i + 3) * h) + 7 * f.apply(a + (i + 4) * h)
            );
        }

        return integral;
    }

    public static void main(String[] args) {
        Function<Double, Double> f = x -> 1 / (1 + x * x);

        double a = 0;
        double b = 1;

        int nBoole = (int) ((b - a) / (1.0 / 4));
        double resultBoole = booleRule(f, a, b, nBoole);
        System.out.println("Boole's Rule Result: " + resultBoole);
    }
}
