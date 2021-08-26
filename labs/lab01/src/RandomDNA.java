import java.util.Random;

public class RandomDNA {

    public static void generateDNA(String[] DNA) {

        Random r = new Random();
        int rand = 0;

        for(int i = 0; i < 20; i++) {

            rand = r.nextInt(4);

            if(rand == 1) {

                DNA[i] = "A";

            } else if (rand == 2) {

                DNA[i] = "C";

            } else if (rand == 3) {

                DNA[i] = "T";

            } else {

                DNA[i] = "G";

            }

        }

    }

    public static void print(String[] DNA) {

        for(int i = 0; i < DNA.length; i++) {

            System.out.print(DNA[i]);

        }

    }

    public static void main(String[] args) {

        String[] DNA = new String[20];
        generateDNA(DNA);
        print(DNA);

    }

}