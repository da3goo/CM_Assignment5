import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Double, Double> f = x -> 1 / (1 + x * x);

        double a = 0;
        double b = 1;
        int n = (int) ((b - a) / (1.0 / 4));

        double resultTrapezoidal = TrapezoidalRule.integrate(f, a, b, n);
        System.out.println("Trapezoidal rule (h = 1/4): " + resultTrapezoidal);

        int nSimpson13 = (int) ((b - a) / (1.0 / 4));
        if (nSimpson13 % 2 != 0) {
            nSimpson13 += 1;
        }
        double resultSimpson13 = SimpsonsRule.simpsonsOneThirdRule(f, a, b, nSimpson13);
        System.out.println("Simpson's 1/3rd rule (h = 1/4): " + resultSimpson13);

        int nSimpson38 = (int) ((b - a) / (1.0 / 6));
        if (nSimpson38 % 3 != 0) {
            nSimpson38 += 3 - (nSimpson38 % 3);
        }
        double resultSimpson38 = SimpsonsRule.simpsonsThreeEighthRule(f, a, b, nSimpson38);
        System.out.println("Simpson's 3/8th rule (h = 1/6): " + resultSimpson38);

        int nWeddle = (int) ((b - a) / (1.0 / 6));
        if (nWeddle % 6 != 0) {
            nWeddle += 6 - (nWeddle % 6);
        }
        double resultWeddle = WeddleRule.weddleRule(f, a, b, nWeddle);
        System.out.println("Weddle's rule (h = 1/6): " + resultWeddle);

        int nBoole = (int) ((b - a) / (1.0 / 4));
        double resultBoole = BoolRule.booleRule(f, a, b, nBoole);
        System.out.println("Boole's Rule Result: " + resultBoole);
    }

}
