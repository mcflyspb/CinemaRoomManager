package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows:");

        int rows = input.nextInt();
        System.out.println("Enter the number of seats in each row:");

        int seats = input.nextInt();
        int[][] zal = new int[rows][seats];

        for (;;) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int options = input.nextInt();
            if (options == 1) {
                printZal (zal,rows,seats);
            } else if (options == 2) {
                int[] p = new int[2];
                p = buyTickets (input, zal,rows, seats);

                if (p[0] > 0 && p[1] > 0 ) {
                    zal[p[0] - 1][p[1] - 1] = 1;
                }
            } else if (options == 3) {
                printStats(zal,rows,seats);
            } else if (options == 0) {
                break;
            }
        }
    }

    private static void printStats(int[][] zal, int rows, int seats) {
        System.out.println();
        int countPurchasedTickets = 0;
        int firstHalfZal = rows / 2;
        int curentIncome = 0;
        int totalIncome = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j<= seats; j++) {
        if (rows * seats <= 60) {
                    totalIncome = totalIncome + 10;
                } else if (i <= firstHalfZal) {
                    totalIncome = totalIncome + 10;
                } else {
                    totalIncome = totalIncome + 8;
                }

                if (zal[i - 1][j - 1] == 1) {
                    countPurchasedTickets++;
                    if (rows * seats <= 60) {
                        curentIncome = curentIncome + 10;
                    } else if (i <= firstHalfZal) {
                        curentIncome = curentIncome + 10;
                    } else {
                        curentIncome = curentIncome + 8;
                    }
                }
            }
        }
        float percentOfSoldTickets = (float)(100 * countPurchasedTickets) / (rows * seats);
        System.out.println("Number of purchased tickets: " + countPurchasedTickets);
        System.out.printf("Percentage: %.2f%%",percentOfSoldTickets);
        System.out.println();
        System.out.println("Current income: $" + curentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    private static int[] buyTickets(Scanner input, int[][] zal, int rows, int seats) {
        System.out.println();
        System.out.println("Enter a row number:");
        int customerRow = input.nextInt();
        System.out.println("Enter a seat number in that row:");
        int customerSeats = input.nextInt();
        int firstHalfRow = rows / 2;
        int price = 8;

        if (customerRow > rows || customerSeats > seats) {
            System.out.println();
            System.out.println("Wrong input!");
            return new int[] {-1,-1};
        }



        while (zal[customerRow - 1][customerSeats - 1] == 1) {
            System.out.println();
            System.out.println("That ticket has already been purchased!");
            System.out.println();
            System.out.println("Enter a row number:");
            customerRow = input.nextInt();
            System.out.println("Enter a seat number in that row:");
            customerSeats = input.nextInt();
            firstHalfRow = rows / 2;

        }

        //System.out.println("r: " + rows + " f: " + firstHalfRow);

        if (rows * seats <= 60) {
            price = 10;
        } else if  (customerRow <= firstHalfRow) {
            price = 10;
        }
            System.out.println("Ticket price: $" + price);


        //System.out.println("Ticket price: $10");
        return new int[] {customerRow,customerSeats};
    }

    public static void printZal (int[][] zal, int rows, int seats) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int j = 1; j <= rows; j++) {
            System.out.print(j + " ");
            for (int i = 1; i <= seats; i++) {
                if (zal[j-1][i-1] == 0) {
                    System.out.print("S ");
                } else {
                    System.out.print("B ");
                }
            }
            System.out.println();
        }

    }
}


