public class RunTimesCalculator {

    static int sum2;
    static int sum5;

    public static void instrCount(int n) {

        //EXAMPLE 1
        sum2 = 0;
        for(int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j++) {
                sum2++;
            }
        }

        //EXAMPLE 4

        sum5 = 0;
        for(int k = 1; k <= n; k *= 2) {
            for (int j = 1; j <= n; j++) {
                sum5++;
            }
        }

        System.out.println("Example 1 total Count for " + n + ": "  + sum2 + "; Runtime Ratio: " + (sum2/n));
        System.out.println("Example 4 total Count for " + n + ": " + sum5 + "; Runtime Ratio: " + (sum5/n));

    }



}

