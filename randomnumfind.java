import java.util.*;
public class randomnumfind
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    Random randomNum=new Random();
			int score=0;
			int attempt=1;
	    while(true){
					int i=0;
					int randomnum=randomNum.nextInt(100);
					System.out.println("You have 5 chances to find the number between 1 to 100\nLet's Go\n");
					for(i=0;i<5;i++){
						int num=sc.nextInt();
						if(num<randomnum){
								System.out.println("The Number is greater than "+num);
						}
						else if(num>randomnum){
								System.out.println("The Number is lesser than "+num);
						}
						else if(num==randomnum){
								System.out.println("Congratulation! The Number you given is correct");
								score++;
								break;
						}
					}
					if(i==5){
							System.out.println("\nThe chances is over and the number is "+randomnum);
					}
					System.out.println("\n\tScore:"+score+"\n\tNo.of.attempt:"+attempt+"\n\nDo you want to play again --> press 1");
					int playagain=sc.nextInt();
					if(playagain!=1){
							score=0;
							attempt=1;
							break;
					}
					else{
							attempt++;
					}
	    }
	}
}
