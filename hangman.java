import java.util.Scanner;

public class hangman {

	public static void main(String[] args) {
		char x = 'y';
		int z = 0;
		
		Scanner input = new Scanner(System.in);
		
		while(x != 'n') {
			System.out.println("Welcome To Hangman! To play, enter y");
			System.out.println("To exit, enter n");						
			
			x = input.nextLine().charAt(0);
			
			if(x == 'y') {
				z = chosenWord();
								
				char y;
				char temp;
				String guess = "-";
				String guesstemp;
				String answer = wordbank.words[z].toUpperCase();
				for(int i = 1; i < answer.length(); i++) {
					guess = guess.concat("-");
				}
				for(int i = 7; i > 0; i--) {//loop 7 chances to guess correct letters
					System.out.println();
					System.out.println(i + " guesses left");
					System.out.println(guess);
					System.out.println("Choose a letter: ");
					System.out.println();
					
					y = input.nextLine().toUpperCase().charAt(0);
					int trap = answer.indexOf(y);//trap checks to see if input is correct
					if(trap != -1) {
						guesstemp = "";						
						for(int j = 0; j < answer.length(); j++) {
							if(guess.charAt(j) != '-') {
								temp = guess.charAt(j);
								guesstemp = guesstemp.concat(String.valueOf(temp));								
							}
							else if(answer.charAt(j) == y) {						
								guesstemp = guesstemp.concat(String.valueOf(y));								
							}
							else {
								guesstemp = guesstemp.concat("-");								
							}
						}
						guess = guesstemp;
						i++;
					}
					else {
						
					}
					if(guess.indexOf("-") == -1)
						break;
					/*if(i == 0)
						break;*/
				}				
				if(guess.indexOf("-") == -1) {
					System.out.println();
					System.out.println(guess);
					System.out.println();
					System.out.println("Congrats!! You won!");
					System.out.println();
				}
				else {
					System.out.println();
					System.out.println("Sorry, try again");
					System.out.println(wordbank.words[z]);
					System.out.println();
				}				
			}
			else {
				continue;
			}				
		}
		input.close();
	}
	public static int chosenWord(){
		int randomNum = (int)(Math.random() * 2466);
		String randomWord = wordbank.words[randomNum];
		while(randomWord.contains("-") || randomWord.contains(" ")) {
			randomNum = (int)(Math.random() * 2466);
			randomWord = wordbank.words[randomNum];
		}		
		return randomNum;
	}	
}
