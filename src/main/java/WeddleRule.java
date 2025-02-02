import java.util.function.Function;
public class WeddleRule {
    public static double weddleRule(Function<Double, Double> f, double a, double b, int n) {
        if (n % 6 != 0) {
            throw new IllegalArgumentException("The number of subintervals (n) must be a multiple of 6.");
        }
        double h = (b - a) / n;
        double integral = 0;

        for (int i = 0; i < n; i += 6) {
            integral += (3 * h / 10) * (
                    f.apply(a + i * h) + 5 * f.apply(a + (i + 1) * h) + f.apply(a + (i + 2) * h) +
                            6 * f.apply(a + (i + 3) * h) + f.apply(a + (i + 4) * h) + 5 * f.apply(a + (i + 5) * h) +
                            f.apply(a + (i + 6) * h)
            );
        }

        return integral;
    }

    public static void main(String[] args) {
        Function<Double, Double> f = x -> 1 / (1 + x * x);

        double a = 0;
        double b = 1;

        int nWeddle = (int) ((b - a) / (1.0 / 6));
        if (nWeddle % 6 != 0) {
            nWeddle += 6 - (nWeddle % 6);
        }
        double resultWeddle = WeddleRule.weddleRule(f, a, b, nWeddle);
        System.out.println("Weddle's rule (h = 1/6): " + resultWeddle);
    }
}
