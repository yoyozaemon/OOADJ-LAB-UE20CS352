package accountdetails;
class Account
{  
            int acc_no;  
            String name;  
            float amount; 
            
           Account()
            {
               acc_no=0;  
               name=null;  
               amount=0.0f;   
            }
            
            void insert(int acc_no,String n,float amt)
            {  
                    this.acc_no=acc_no;  
                    name=n;  
                    amount=amt;  
            }  
            
            void deposit(float amt)
            {  
                    amount=amount+amt;  
                    System.out.println(amt+" deposited");  
            }  
            void withdraw(float amt)
            {  
                    if(amount<amt)
                    {  
                       System.out.println("Insufficient Balance");  
                    }
                    else
                    {  
                        amount=amount-amt;  
                        System.out.println(amt+" withdrawn");  
                   }  
            }  
                void checkBalance()
                {
                    System.out.println("Balance is: "+amount);
                }  
                void display()
                {
                    System.out.println(acc_no+" "+name+" "+amount);
                }  
                
               @Override
               public String toString()
                {
                    return("its display from to string\naccount number="+acc_no+"\nname="+name+"\namount="+amount);
                }
}  //End of Class Account
  
public class AccountDetails
{  
        public static void main(String[] args)
        {  
            
                Account a=new Account(); 
                a.display();
                System.out.println(a.toString());
                Account a1=new Account();  
                a1.insert(832345,"Ankit",1000);  
                a1.display();  
                a1.checkBalance();  
                a1.deposit(40000);  
                a1.checkBalance();  
                a1.withdraw(15000);  
                a1.checkBalance();  
                //System.out.println(a.toString());
                
     }

} 