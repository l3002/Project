import java.util.Random;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception{
        Random rand = new Random();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Welcome to GuessNum!!!");
	System.out.println("The number guessing game where you have 10 chances to guess a number between 1 and 1000.");
	System.out.println("To make it a bit easy, we will be giving you hints after every chance.");
	System.out.println("Let's see if YOU can guess numbers");
        int flag = 0;
        int userNum = 0;
        int randNum = rand.nextInt(1000) + 1;
        for(int i=1;i<11;i++){
            System.out.print(i+". Enter the number between 1 and 1000: ");
            userNum=Integer.parseInt(br.readLine());
            if(userNum == randNum){
                flag=1;
                break;
            }
            else if(userNum > randNum){
                System.out.println("The number is too high");
            }
            else{
                System.out.println("The number is too low");
            }
        }
        if(flag==0){
            System.out.println("You Lose, you weren't able to guess the number");
	    System.out.println("Game Over");
        }
        else{
            System.out.println("Congratulations, this is the right number");
	    System.out.println();
        }
    }
}
