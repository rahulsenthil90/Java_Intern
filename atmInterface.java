import java.util.*;
class Account{
    long acc_no;
    String cus_name,ph_no;
    int bal,pass;
    Account(long account,String name,int balance,int passkey,String phone){
        this.acc_no=account+13345;
        this.cus_name=name;
        this.bal=balance;
        this.pass=passkey;
        this.ph_no=phone;
    }
}
public class atmInterface
{
	public static void main(String[] args) {
	    try (Scanner sc = new Scanner(System.in)) {
				Account A[]=new Account[100];
				boolean f1,f2,f3;
				int accountcount=0;
System.out.println("\n\t\t\t**********ATM Machine**********");
f1=true;
while (f1){
					System.out.println("\n\t\t\tWelcome to CodSoft Bank\n");
					System.out.print("Enter your Account Number: ");
					int accountno=sc.nextInt();
					if(accountno==3012){
					    System.out.println("\n\t\t\t **********Bank Officer Login*********");
					    f2=true;
					    while(f2){
				  		    System.out.println("Enter the number\n1.Add Account\n2.Customer's Account\n3.Exit");
				  		    int bchoice=sc.nextInt();
				  		    if(bchoice==1){
				      		    int pass=0000;
				      		    System.out.println("\nCustomer Name\tOpening Balance \t Phone number");
				      		    A[accountcount]=new Account(accountcount,sc.next(),sc.nextInt(),pass,sc.next());
				      		    System.out.println("\nAccount no: "+A[accountcount].acc_no+"\nCustomer Name: "+A[accountcount].cus_name+"\nBalance: "+A[accountcount].bal+"\nPhone No: "+A[accountcount].ph_no);
				      		    accountcount++;
				  		    }
				  		    else if(bchoice==2){
				  		        System.out.println("No.of.Customer: "+accountcount);
				  		        for(int i=0;i<accountcount;i++){
				  		             System.out.println("\nCustomer: "+(i+1) +"\nAccount no: "+A[i].acc_no+"\nCustomer Name: "+A[i].cus_name+"\nBalance: "+A[i].bal+"\nPhone No: "+A[i].ph_no+"\n");
				  		        }
				  		    }
				  		    else if(bchoice==3){
				  		        f2=false;
				  		    }
				  		    else{
				  		        System.out.println("Please Enter a Valid Number !!!");
				  		    }
					        
					    }
					}
					else if(accountno==A[accountno-13345].acc_no){
					    f3=true;
				  		while(f3){
				      		System.out.print("Enter The 4 digit pin: ");
				      		int pin=sc.nextInt();
				      		if(pin==A[accountno-13345].pass){
				      		    System.out.println("\nWelcome "+A[accountno-13345].cus_name+"...\nChoose one option to continue\n1.Fast Cash\t\t2.Withdrawal\n3.Deposit\t\t4.Balance Enquire\n5.Transfer Fund\t\t6.Pin Change");
				      		    int cchoice=sc.nextInt();
				      		    if(cchoice==1){
				      		        System.out.println("Select Amount\n1.Rs.100\t\t2.Rs.200\n3.Rs.500\t\t4.Rs.1000\n5.Rs.2000\t\t6.Rs.5000\n7.Rs.10000\t\t8.Cancel");
				      		        int amountoption=sc.nextInt();
				      		        if(amountoption==1){
				      		            if(A[accountno-13345].bal-100>=500){
				      		                A[accountno-13345].bal=A[accountno-13345].bal-100;
				      		                System.out.println("Rs.100 Successfully withdrawn\nAvailable Balance: "+A[accountno-13345].bal);
				      		            }
				      		            else{
				      		                System.out.println("Sorry, Insufficient Balance Min.Balance must be 500 \nAvailable Balance:"+A[accountno-13345].bal);
				      		            }
				      		        }
				      		        else if(amountoption==2){
				      		            if(A[accountno-13345].bal-200>=500){
				      		                A[accountno-13345].bal=A[accountno-13345].bal-200;
				      		                System.out.println("Rs.200 Successfully withdrawn\nAvailable Balance: "+A[accountno-13345].bal);
				      		            }
				      		            else{
				      		                System.out.println("Sorry, Insufficient Balance Min.Balance must be 500 \nAvailable Balance:"+A[accountno-13345].bal);
				      		            }
				      		        }
				      		        else if(amountoption==3){
				      		            if(A[accountno-13345].bal-500>=500){
				      		                A[accountno-13345].bal=A[accountno-13345].bal-500;
				      		                System.out.println("Rs.500 Successfully withdrawn\nAvailable Balance: "+A[accountno-13345].bal);
				      		            }
				      		            else{
				      		                System.out.println("Sorry, Insufficient Balance Min.Balance must be 500 \nAvailable Balance:"+A[accountno-13345].bal);
				      		            }
				      		        }
				      		        else if(amountoption==4){
				      		            if(A[accountno-13345].bal-1000>=500){
				      		                A[accountno-13345].bal=A[accountno-13345].bal-1000;
				      		                System.out.println("Rs.1000 Successfully withdrawn\nAvailable Balance: "+A[accountno-13345].bal);
				      		            }
				      		            else{
				      		                System.out.println("Sorry, Insufficient Balance Min.Balance must be 500 \nAvailable Balance:"+A[accountno-13345].bal);
				      		            }
				      		        }
				      		        else if(amountoption==5){
				      		            if(A[accountno-13345].bal-2000>=500){
				      		                A[accountno-13345].bal=A[accountno-13345].bal-2000;
				      		                System.out.println("Rs.2000 Successfully withdrawn\nAvailable Balance: "+A[accountno-13345].bal);
				      		            }
				      		            else{
				      		                System.out.println("Sorry, Insufficient Balance Min.Balance must be 500 \nAvailable Balance:"+A[accountno-13345].bal);
				      		            }
				      		        }
				      		        else if(amountoption==6){
				      		            if(A[accountno-13345].bal-5000>=500){
				      		                A[accountno-13345].bal=A[accountno-13345].bal-5000;
				      		                System.out.println("Rs.5000 Successfully withdrawn\nAvailable Balance: "+A[accountno-13345].bal);
				      		            }
				      		            else{
				      		                System.out.println("Sorry, Insufficient Balance Min.Balance must be 500 \nAvailable Balance:"+A[accountno-13345].bal);
				      		            }
				      		        }
				      		        else if(amountoption==7){
				      		            if(A[accountno-13345].bal-10000>=500){
				      		                A[accountno-13345].bal=A[accountno-13345].bal-10000;
				      		                System.out.println("Rs.10000 Successfully withdrawn\nAvailable Balance: "+A[accountno-13345].bal);
				      		            }
				      		            else{
				      		                System.out.println("Sorry, Insufficient Balance Min.Balance must be 500 \nAvailable Balance:"+A[accountno-13345].bal);
				      		            }
				      		        }
				      		        else if(amountoption==8){
				      		            f3=false;
				      		        }
				      		        else{
				      		            System.out.println("Invalid Number!!!");
				      		        }
				      		        System.out.println("\t\t\tThanks You for Visting Our ATM\n\n");
				      		        f3=false;
				      		    }
				      		    else if(cchoice==2){
				      		        System.out.print("Please enter the amount to withdraw: ");
				      		        int withdrawamount=sc.nextInt();
				      		        if(A[accountno-13345].bal-withdrawamount>=500){
				  		                A[accountno-13345].bal=A[accountno-13345].bal-withdrawamount;
				  		                System.out.println("Rs."+withdrawamount+" Successfully withdrawn\nAvailable Balance: "+A[accountno-13345].bal);
				  		            }
				  		            else{
				  		                System.out.println("Sorry, Insufficient Balance Min.Balance must be 500 \nAvailable Balance:"+A[accountno-13345].bal);
				  		            }
				  		            f3=false;
				      		    }
				      		    else if(cchoice==3){
				      		        System.out.print("Please enter the amount to Deposit: ");
				      		        int deposit=sc.nextInt();
				      		         A[accountno-13345].bal=A[accountno-13345].bal+deposit;
				  		             System.out.println("Rs."+deposit+" Successfully Deposited\nAvailable Balance: "+A[accountno-13345].bal);
				  		             f3=false;
				      		    }
				          		else if(cchoice==4){
				                     System.out.println("Available Balance: "+A[accountno-13345].bal);
				                     f3=false;
				          		}
				          		else if(cchoice==5){
				          		    System.out.print("Please Enter account number to transfer: ");
				          		    int t_acc=sc.nextInt();
				          		    if(t_acc==A[t_acc-13345].acc_no){
				          		        System.out.println("Account Holder Name: "+A[t_acc-13345].cus_name+"\nAccount No: "+A[t_acc-13345].acc_no+"\nPlease enter the number\n1.Correct\t\tIf Incorrect,please any number except 1");
				          		        int check=sc.nextInt();
				          		        if(check==1){
				          		            System.out.print("Enter the amount to transfer: ");
				          		            int t_amount=sc.nextInt();
				          		            if(A[accountno-13345].bal-t_amount>=500){
				          		                A[accountno-13345].bal=A[accountno-13345].bal-t_amount;
				          		                A[t_acc-13345].bal+=t_amount;
				          		                System.out.println("Rs."+t_amount+" Successfully Transfered...\nAvailable Balance: "+A[accountno-13345].bal);
				          		            }
				          		            else{
				          		                System.out.println("Sorry, Insufficient Balance Min.Balance must be 500 \nAvailable Balance:"+A[accountno-13345].bal);
				          		            }
				          		        }
				          		        else{
				          		            f3=false;
				          		        }
				          		    }
				          		    else{
				          		        System.out.println("!!! Invalid Account Number !!!");
				          		    }
				          		    f3=false;
				          		}
				          		else if(cchoice==6){
				          		    System.out.print("Enter your Phone number: ");
				          		    String mobile=sc.next();
				          		    if(mobile.equals(A[accountno-13345].ph_no)){
				          		        int changepin=sc.nextInt();
				          		        A[accountno-13345].pass=changepin;
				          		        System.out.println("Pin Changed Successfully");
				          		    }
				          		    else{
				          		        System.out.println("!!!Invalid Phone number!!!");
				          		    }
				          		    f3=false;
				          		}
				          		else{
				          		    System.out.println("!!!Invalid Number!!!");
				          		    f3=false;
				          		}
				      		}
				      		else{
				      		    System.out.println("!!! Invalid Pin Number !!!");
				      		    f3=false;
				      		}
				      		}
					}
					
					else{
					    System.out.println("!!! Invalid Account Number !!!");
					}
				}
			}
	}
}
