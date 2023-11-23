package ex01;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Calculator {
    private static int[][] vectors;

    public static double calculateSimilarity(int[][] matrixVectors) {
        vectors = matrixVectors;
        double numerator = (double) findNumerator();
        double denominator = findDenominator();
        return numerator / denominator;
    }

    private static int findNumerator() {
        int sum = 0;
        for (int i = 0; i < Program.getDictSize(); i++) {
            sum += vectors[0][i] * vectors[1][i];
        }
        return sum;
    }

    private static double findDenominator() {
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < Program.getDictSize(); i++) {
            sum1 += pow(vectors[0][i], 2);
            sum2 += pow(vectors[1][i], 2);
        }
        return sqrt(sum1) * sqrt(sum2);
    }
}
