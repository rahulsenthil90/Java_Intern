import java.util.*;
public class randomnumfind
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    Random randomNum=new Random();
		int randomnum=randomNum.nextInt(100);
		int i=0;
		System.out.println("You have 5 chances to find the number between 1 to 100 \nLet's Go");
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
		        break;
		    }
		}
		if(i==5){
		    System.out.println("The chances is over and the number is "+randomnum);
		}
	}
}
