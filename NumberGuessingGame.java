import java.util.Scanner;
public class NumberGuessingGame{
    public static void main(String[] args){
        guessNumbers();
    }
    public static void guessNumbers(){
        Scanner sc = new Scanner(System.in);
        int num = 1 + (int)(100 * Math.random());
        int attempts = 5;
        System.out.println("You have " + attempts + " attempts to guess the number");       
        for(int i = 0; i < attempts; i++){
            System.out.print("Enter the number to guess : ");
            int guess = sc.nextInt();
            if(guess == num){
                System.out.println("You have entered the correct number!!");
                sc.close();
                return;
            }
            else if(guess > num){
                System.out.println("You have entered greater than the number...");
            }
            else if(guess < num){
                System.out.println("You have entered lesser than the number...");
            }
            System.out.println("Remaining attempts are : " + (attempts-i-1));
        }
        System.out.println("You lose all the attempts...The correct number was " + num);
        sc.close();
    }
}