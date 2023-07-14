import java.util.*;

class Account{
	String User,Pass;
	double balance,AccNo;
	int Tflag=0,flag=0;
	public Account(String u,String P,double bal,long AccNo)
	{
		User=u;
		Pass=P;
		balance=bal;
		this.AccNo=AccNo;
	}
	public void credentialsCheck(String U,String P,int i,int n)
	{
		if(User.equals(U) && Pass.equals(P))
		{
			System.out.print("\n***Successfully logged in***\n");
			flag=1;
		}
		else
		{
			if(i>=n-1)
			 System.out.print("Credentials not matched try again");
		}
	}
	public int getFlag()
	{
		return flag;
	}
	public void Deposit(double bal)
	{
		balance+=bal;
		System.out.print("Successfully Credited\n");
	}
	public void Withdraw(double bal)
	{
		if(balance>=bal)
		{
			balance-=bal;
			System.out.print("Amount debited Successfully\n");
		}
		else
		{
			System.out.print("Insufficient balance");
		}
	}
	public double getBalance()
	{
		return balance;
	}
	public void Transfer(String U,long ANo,double bal,int i,int n,int j)
	{
		if(AccNo==ANo&&User.equals(U))
		{
			Tflag=1;
		}
		else
		{
			if(i>=n-1)
				System.out.print("Incorrect Account Number");
		}
	}
	public int getTFlag()	
	{
		return Tflag;
	}
	public void setTFlag()
	{
		Tflag=0;
	}
}
public class ATM
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.print("***WELCOME TO SBI ATM INTERFACE***");
	System.out.print("\n_______________________________");
		System.out.print("\n\nEntry Number of users you want to register:");
		int n=s.nextInt();
		Account A[]=new Account[n];
		long AccNo;

		for(int i=0;i<n;i++)
		{
			System.out.print("\nEnter Person "+(i+1)+" details\n");
			System.out.print("\nEnter UserName:");
			String UserName=s.next();
			System.out.print("\nEnter Password:");
			String Password=s.next();
			System.out.print("\nEnter Balance:");
			double balance=s.nextInt();
			System.out.print("\nEnter Account Number:");
			AccNo=s.nextLong();
			A[i]=new Account(UserName,Password,balance,AccNo);
		}
		
		String Q[]=new String[200];
		int l=0;
		int j=0,f=0,k=0;
		double amount;
		while(true)
		{
			if(f==0)
			{
				System.out.print("\nEnter UserName and Password to login:");
				String U=s.next();	
				String P=s.next();
				for(int i=0;i<n;i++)
				{
					A[i].credentialsCheck(U,P,i,n);
					if(A[i].getFlag()==1)
					{
						j=i;break;
					}
				}
			}
			if(A[j].getFlag()==1)
			{
				System.out.print("\n1.Deposit()");
				System.out.print("\n2.Withdraw()");
				System.out.print("\n3.To display balance");
				System.out.print("\n4.Transfer");
				System.out.print("\n5.Transaction History");
				System.out.print("\n6.Quit()");
				System.out.print("\nEnter your choice:");
				int x=s.nextInt();f=1;
				switch(x)
				{
					case 1:System.out.print("\nEnter money you want to credit:");
						amount=s.nextDouble();
						A[j].Deposit(amount);
						Q[l++]="Credited :+"+amount;
							break;
					case 2:System.out.print("\nEnter money you want to debit:");
						amount=s.nextDouble();
						A[j].Withdraw(amount);
						Q[l++]="Debited :+"+amount;
							break;
					case 3:System.out.print("\nCurrent Balance:"+A[j].getBalance()+"\n");
							break;
					case 4:System.out.print("\nEnter Account Number which you want to transfer:");
						AccNo=s.nextLong();
						System.out.print("\nEnter UserName:");
						String Us=s.next();
						System.out.print("\nEnter Amount you want to Transfer:");
						amount=s.nextDouble();
						for(int i=0;i<n;i++)
						{
							A[i].Transfer(Us,AccNo,amount,i,n,j);
							if(A[i].getTFlag()==1)
							{
								k=i;A[i].setTFlag();
								if(A[j].balance>=amount)
								{
									A[j].balance-=amount;
									Q[l++]="Transfered : -"+amount;
									System.out.print("Amount transferred Successfully\n");
								}
								else
								{
									System.out.print("Insufficient balance");
								}
							}
						}
						break;
					case 5:for(int i=0;i<20;i++)
						{
							if(Q[i]!=null)
								System.out.print("\n"+Q[i]+"\n");
						}
						break;
					case 6:System.out.print("\nYou want to Quit(yes/no):");
						String reply=s.next();
						if(reply.equals("yes"))
							System.out.print("\nThanks for Visiting\n");
							System.exit(0);
						f=1;
				}
			}
		}
	}
}
				