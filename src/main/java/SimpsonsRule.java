import java.util.function.Function;

public class SimpsonsRule {

    public static double simpsonsOneThirdRule(Function<Double, Double> f, double a, double b, int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("Number of subintervals (n) must be even.");
        }
        double h = (b - a) / n;
        double sum = f.apply(a) + f.apply(b);

        for (int i = 1; i < n; i += 2) {
            sum += 4 * f.apply(a + i * h);
        }
        for (int i = 2; i < n - 1; i += 2) {
            sum += 2 * f.apply(a + i * h);
        }

        return (h / 3) * sum;
    }


    public static double simpsonsThreeEighthRule(Function<Double, Double> f, double a, double b, int n) {
        if (n % 3 != 0) {
            throw new IllegalArgumentException("Number of subintervals (n) must be a multiple of 3.");
        }
        double h = (b - a) / n;
        double sum = f.apply(a) + f.apply(b);

        for (int i = 1; i < n; i += 3) {
            sum += 3 * f.apply(a + i * h);
        }
        for (int i = 2; i < n; i += 3) {
            sum += 3 * f.apply(a + i * h);
        }
        for (int i = 3; i < n - 1; i += 3) {
            sum += 2 * f.apply(a + i * h);
        }

        return (3 * h / 8) * sum;
    }

    public static void main(String[] args) {
        Function<Double, Double> f = x -> 1 / (1 + x * x);

        double a = 0;
        double b = 1;

        int nSimpson13 = (int) ((b - a) / (1.0 / 4));
        if (nSimpson13 % 2 != 0) {
            nSimpson13 += 1;
        }
        double resultSimpson13 = simpsonsOneThirdRule(f, a, b, nSimpson13);
        System.out.println("Simpson's 1/3rd rule (h = 1/4): " + resultSimpson13);

        int nSimpson38 = (int) ((b - a) / (1.0 / 6));
        if (nSimpson38 % 3 != 0) {
            nSimpson38 += 3 - (nSimpson38 % 3);
        }
        double resultSimpson38 = simpsonsThreeEighthRule(f, a, b, nSimpson38);
        System.out.println("Simpson's 3/8th rule (h = 1/6): " + resultSimpson38);
    }
}
