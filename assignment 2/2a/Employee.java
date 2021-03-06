import java.util.Scanner;

class Payslip
{
	int emp_id,no_hours,experience,dd,mm,yyyy;
	String emp_name,designation,dob,insurance;
	float basic,da,hra,lic,pf,gross,hour_wage,deduction,net_salary;
	Scanner obj = new Scanner(System.in);
	public void input()
	{
		System.out.print("Enter Employee Name     :");
		emp_name=obj.next();
		System.out.print("Enter Employee id       :");
		emp_id=obj.nextInt();
		System.out.print("Enter designation(First letter in caps) :");
		obj.nextLine();
		designation=obj.nextLine();
		System.out.print("Enter Date of birth     :");
		dob=obj.next();
		System.out.print("Enter Date of join      :");
		dd=obj.nextInt();
		mm=obj.nextInt();
		yyyy=obj.nextInt();
		System.out.print("Enter Basic pay         :");
		basic=obj.nextFloat();
		System.out.print("Do you opted LIC insurance :");
		insurance=obj.next();
		if(insurance.equals("yes"))
		{
			System.out.print("Enter LIC premium Amount :");
			lic=obj.nextFloat();
		}
		else if(insurance.equals("no"))
		{
			lic=0;
		}
		if(designation.equals("Intern"))
		{
			System.out.print("Enter No.of Hours worked:");
			no_hours=obj.nextInt();
			System.out.print("Enter Hourly wage       :");
			hour_wage=obj.nextFloat();
		}
	}
	public void salary()
	{
		if(designation.equals("Intern"))
		{
			da=2000;
			hra=1000;
			pf=500;
			basic=(no_hours*hour_wage);
			gross=basic+da+hra;
			deduction=lic+pf;
			net_salary=gross-deduction;
		}
		else if(designation.equals("Manager"))
		{
			da=(0.4f*basic);
			hra=(0.1f*basic);
			pf=(0.08f*basic);
			gross=basic+da+hra;
			deduction=lic+pf;
			net_salary=gross-deduction;
		}
		else if(designation.equals("Trainee")||designation.equals("Analyst")||designation.equals("Software engineer")||designation.equals("Teamlead"))
		{
			da=(0.3f*basic);
			hra=(0.1f*basic);
			pf=(0.08f*basic);
			gross=basic+da+hra;
			deduction=lic+pf;
			net_salary=gross-deduction;
		}
		else
		{
			System.out.println("Enter details as specified\n");
		}
	}
	public void payslip()
	{
		System.out.println("\n\n*********Salary Slip***********");
		System.out.println("\n\nEmployee name      :"+emp_name);
		System.out.println("Employee ID        :"+emp_id);
		System.out.println("Month and Year     :July and 2019");
		System.out.println("\nGross:");
		System.out.println("Basic              :"+basic);
		System.out.println("DA                 :"+da);
		System.out.println("HRA                :"+hra);
		System.out.println("\nNet Gross          :"+gross);
		System.out.println("\n\nDectections :");
		System.out.println("Provident Fund     :"+pf);
		System.out.println("Life insurance     :"+lic);
		System.out.println("\nTotal Dectections  :"+deduction);
		System.out.println("\n\nNet Salary         :"+net_salary);
	}
	public void promote()
	{
		System.out.println("\nPromotion Statement\n");
		experience=2019-yyyy;
		if(experience>=3)
		{
			if(designation.equals("Trainee")||designation.equals("Analyst")||designation.equals("Software engineer")||designation.equals("Teamlead"))
			{
				System.out.println("You are Promoted to Manager !");
			}
			else if(designation.equals("Intern"))
			{
				System.out.println("You are now one of our employee...");
			}	
			else
			{
				System.out.println("You are already in the top position..\n");
			}
		}
		else
		{
			System.out.println("You need more experience");
		}
	}
}
public class Employee
{
	public static void main(String args[])
	{
		int i;
		System.out.print("Enter the number of Employees");
		Scanner obj = new Scanner(System.in);
		int n=obj.nextInt();
		Payslip b[] = new Payslip[n];
		for(i=0;i<n;i++)
		{
			b[i] = new Payslip();
		}
		System.out.println("Enter the Details of Employees:");
		for(i=0;i<n;i++)
		{	
			int k=i+1;
			System.out.println("\nEmployee "+k+" :");
			b[i].input();
			b[i].salary();
		}
		char ch;
		do{
		System.out.println("\n1.Display Salary details of Employees\n2.Display salary details of a particular Employee\nSelect an option");
		int x=obj.nextInt();
		if(x==1)
		{
			for(i=0;i<n;i++)
			{
				int k=i+1;
				System.out.println("Salary details of Employee "+k);
				b[i].payslip();
				b[i].promote();
			}
		}
		else if(x==2)
		{
			System.out.println("Enter the Employee Name :");
			int flag =0;
			String name = new String(obj.next());

			{
				for(i=0;i<n;i++)
				{
					if(b[i].emp_name.equals(name))
					{
						b[i].payslip();
						b[i].promote();
						flag=1;
						break;
					}
				}
				if(flag==0)
				{
					System.out.println("Check the Entered Name...Terminated");
				}
			}
		}	
		else
		{
			System.out.println("Check the option Entered......");
		}
		System.out.println("do you want to continue");
		ch=obj.next().charAt(0);}while(ch=='y');	
	}
}
/*

PS F:\java> javac Employee.java
PS F:\java> java Employee
Enter the number of Employees2
Enter the Details of Employees:

Employee 1 :
Enter Employee Name     :ram
Enter Employee id       :23
Enter designation(First letter in caps) :Manager
Enter Date of birth     :23/5/1992
Enter Date of join      :4 5 2012
Enter Basic pay         :30000
Do you opted LIC insurance :yes
Enter LIC premium Amount :300

Employee 2 :
Enter Employee Name     :reshma
Enter Employee id       :12
Enter designation(First letter in caps) :Intern
Enter Date of birth     :4/6/2000
Enter Date of join      :21 7 2017
Enter Basic pay         :12000
Do you opted LIC insurance :no
Enter No.of Hours worked:32
Enter Hourly wage       :12

1.Display Salary details of Employees
2.Display salary details of a particular Employee
Select an option
1
Salary details of Employee 1


*********Salary Slip***********


Employee name      :ram
Employee ID        :23
Month and Year     :July and 2019

Gross:
Basic              :30000.0
DA                 :12000.0
HRA                :3000.0

Net Gross          :45000.0


Dectections :
Provident Fund     :2400.0
Life insurance     :300.0

Total Dectections  :2700.0


Net Salary         :42300.0

Promotion Statement

You are already in the top position..

Salary details of Employee 2


*********Salary Slip***********


Employee name      :reshma
Employee ID        :12
Month and Year     :July and 2019

Gross:
Basic              :384.0
DA                 :2000.0
HRA                :1000.0

Net Gross          :3384.0


Dectections :
Provident Fund     :500.0
Life insurance     :0.0

Total Dectections  :500.0


Net Salary         :2884.0

Promotion Statement

You need more experience
do you want to continue
y

1.Display Salary details of Employees
2.Display salary details of a particular Employee
Select an option
2
Enter the Employee Name :
reshma


*********Salary Slip***********


Employee name      :reshma
Employee ID        :12
Month and Year     :July and 2019

Gross:
Basic              :384.0
DA                 :2000.0
HRA                :1000.0

Net Gross          :3384.0


Dectections :
Provident Fund     :500.0
Life insurance     :0.0

Total Dectections  :500.0


Net Salary         :2884.0

Promotion Statement

You need more experience
do you want to continue
n

*/