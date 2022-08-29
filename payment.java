package AkbankHGSProject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class payment {
   
	public static Car car = new Car();
	
	public static int paymentFunction(int balance,String type) {
	 int price=0;
	 switch(type) {
	 case "car":
		 price = 20;	 
	 break;
	 case "miniBus":
		 price = 30;
	 break;
	 case "bus":
		 price = 40;
	 break;
	 }
	 
	 if(balance >= price)
	    balance -= price;
	 
	 return balance;
	 
	}
	
	//Payment tested this part
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date date = new Date();  
		car.hgsNo = 8219289;
		car.name = "Mahmut Can";
		car.username = "Gönül";
		car.balance = 100;
		car.type = "miniBus";
		int currentBalance = payment.paymentFunction(car.balance, car.type);
		if(car.balance != currentBalance) {
			date = new Date();  
			car.passedTime = formatter.format(date).toString();
			car.balance = currentBalance;
			System.out.println(car.balance);
			System.out.println("Passed Time: "+car.passedTime);
			
		}
		
		
	}
	
}
