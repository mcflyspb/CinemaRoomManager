import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][]ar = new int[n][n];

        for (int i = 0; i < n; i++) {
            ar[i][0] = -i;
            //System.out.print(ar [i][0]+"X");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                ar[i][j] = ar[i][j - 1] + 1;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ar[i][j] < 0) {
                    ar[i][j] = -ar[i][j];
                }
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }



    }
}