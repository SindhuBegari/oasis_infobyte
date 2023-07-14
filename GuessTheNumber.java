import java.util.Scanner;
import java.util.Random;

class GuessNumber{
	int systemInput;
	int userInput;
	int noofGuesses=0;
	GuessNumber(){
		Random random=new Random();
		this.systemInput=random.nextInt(100)+1;
	}
	public boolean takeUserInput(){
		if(noofGuesses<10){
			System.out.print("Guess the number : ");
			this.userInput=GuessTheNumber.takeIntegerInput(100);
			noofGuesses++;
			return false;
		}
		else{
			System.out.println("No.of attempts finished \n Better luck next time\n");
			return true;
		}
	}
	public boolean iscorrectGuess(){
		if(systemInput == userInput){
			System.out.println("Congratulations , you guess the number "+systemInput+" in "+noofGuesses+" guesses");
			switch(noofGuesses){
				case 1: System.out.println("Your Score is 100"); break;
				case 2: System.out.println("Your Score is 90"); break;
				case 3: System.out.println("Your Score is 80"); break;
				case 4: System.out.println("Your Score is 70"); break;
				case 5: System.out.println("Your Score is 60"); break;
				case 6: System.out.println("Your Score is 50"); break;
				case 7: System.out.println("Your Score is 40"); break;
				case 8: System.out.println("Your Score is 30"); break;
				case 9: System.out.println("Your Score is 20"); break;
				case 10: System.out.println("Your Score is 10"); break;
			}
			System.out.println();
			return true;
		}
		else if(noofGuesses<10 && userInput>systemInput){
			if(userInput-systemInput>10){
				System.out.println("Too High");
			}
			else{
				System.out.println("Little High");
			}
		}
		else if(noofGuesses<10 && userInput<systemInput){
			if(userInput-systemInput>10){
				System.out.println("Too Low");
			}
			else{
				System.out.println("Little Low");
			}
		}
		return false;
	}
}
public class GuessTheNumber{
	public static int takeIntegerInput(int limit){
		int input=0;
		boolean x=false;
		while(!x){
			try{
				Scanner s=new Scanner(System.in);
				input=s.nextInt();
				x=true;
				if(x&&input>limit || input<1){
					System.out.println("choose the no. between 1 to "+limit);
					x=false;
				}
			}
			catch(Exception e){
				System.out.println("Enter only Integer value");
				x=false;
			}
		};
		return input;
	}
	public static void main(String[] args){
		System.out.println("1.Start the Game\n2.Exit");
		System.out.println("Enter your choice: ");
		int choice=takeIntegerInput(2);
		int nextRound=1;
		int noofRounds=0;
		if(choice==1){
			while(nextRound==1){
				GuessNumber guessnumber=new GuessNumber();
				boolean isMatched=false;
				boolean isLimitCross=false;
				System.out.println("\nRound"+ ++noofRounds+" starts");
				while(!isMatched && !isLimitCross){
					isLimitCross=guessnumber.takeUserInput();
					isMatched=guessnumber.iscorrectGuess();
				}
				System.out.println("1.Try Next Round\n2.Exit");
				System.out.println("Enter your choice : ");
				nextRound=takeIntegerInput(2);
				if(nextRound != 1){
					System.exit(0);
				}
			}
		}
		else{
			System.exit(0);
		}
	}
}