import java.util.Arrays;

public class Checker {

    static int[][] tickets = { {12, 26, 29, 59, 68, 24},
            {1, 2, 18, 59, 66, 3},
            {5, 32, 56, 63, 69, 7},
            {6, 11, 45, 48, 50, 25},
            {3, 31, 32, 34, 56, 17},
            {6, 24, 35, 36, 66, 24},
            {16, 18, 47, 59, 63, 14},
            {9, 13, 17, 24, 26, 18},
            {2, 13, 31, 34, 38, 22},
            {6, 24, 49, 50, 67, 6},
            {1, 7, 38, 49, 70, 22},
            {29, 35, 39, 63, 68, 6},
            {8, 25, 26, 41, 66, 19},
            {12, 19, 38, 52, 68, 2},
            {2, 12, 20, 30, 70, 15},
            {6, 11, 19, 52, 60, 13},
            {16, 24, 37, 43, 68, 8},
            {17, 51, 52, 64, 68, 8},
            {1, 25, 34, 59, 66, 7},
            {7, 11, 22, 45, 51, 6}
    };

    static int winners[] = { 7, 11, 22, 45, 51, 24 };

    static int winningSet[] = new int[6];
    static boolean mega = false;

    public static void main( String[] args ) {
        if(count(5))
            if( mega )
                System.out.println("\nYou won the jackpot!");
            else
                System.out.println("\nYou won a $1,000,000!");
        else if(count(4)) {
            if( mega ) //4 and mega
                System.out.println("\nYou won $10,000!");
            else //just 4
                System.out.println("\nYou won $500!");
        }
        else if(count(3)) {
            if (mega)
                System.out.println("\nYou won $200!");
            else
                System.out.println("\nYou won $10!");
        }
        else if(count(2) && mega )
            System.out.println("\nYou won $10!");
        oneEach();

    }

    public static boolean count(int target) {
        int count = 0;
        for( int i = 0; i < tickets.length; i++ ){
            count = 0;
            for( int j = 0; j < tickets[0].length - 1; j++ ){
                if(tickets[i][j] == winners[j])
                    count++;
            }
            if( count == target ) {
                winningSet = tickets[i];
                for(int a = 0; a < tickets[0].length; a++ )
                    System.out.print(winningSet[a] + " ");
                break;
            }
        }
        if(winningSet[5] == winners[5])
            mega = true;
        return count == target;
    }

    public static void oneEach(){
        for( int i = 0; i < tickets.length; i++ ){
            for( int j = 0; j < tickets[0].length - 1; j++ ){
                if( tickets[i][j] != winningSet[j] ) {
                    if( tickets[i][j] == winners[j] && tickets[i][5] == winners[5] ) {
                        for(int a = 0; a < tickets[0].length; a++ )
                            System.out.print(tickets[i][a] + " ");
                        System.out.println("\nYou won $4!");
                        break;
                    }
                    else if( tickets[i][5] == winners[5] ) {
                        for(int a = 0; a < tickets[0].length; a++ )
                            System.out.print(tickets[i][a] + " ");
                        System.out.println("\nYou won $2!");
                        break;
                    }
                }
            }
        }
    }
}
