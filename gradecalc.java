import java.util.*;
public class gradecalc
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\t\t\tStudent Grade Calculator");
		while(true){
		    System.out.println("\nPlease enter the total no.of Subjects: ");
    		int sub=sc.nextInt();
    		int mark,total=0;
    		String grade="";
    		float percentage;
    		for(int i=1;i<=sub;i++){
    		    System.out.print("Enter the mark of subject "+i+":");
    		    mark=sc.nextInt();
    		    total+=mark;
    		}
    		percentage=(float)total/sub;
    		if(percentage>=80 && percentage <=100){
    		    grade="A";
    		}
    		else if(percentage>=65 && percentage <=79){
    		    grade="B";
    		}
    		else if(percentage>=50 && percentage <=64){
    		    grade="C";
    		}
    		else if(percentage>=40 && percentage <=49){
    		    grade="D";
    		}
    		else if(percentage <40){
    		    grade="F";
    		}
				System.out.printf("\nThe Total mark is %d/100 \nPercentage:%.2f \nGrade: %s",total,percentage,grade);
    		System.out.println("\nTo Try again press --> 1");
    		int trys=sc.nextInt();
    		if(trys!=1)
    		break;
    	}
	}
}
