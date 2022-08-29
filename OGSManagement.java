package AkbankHGSProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
public class OGSManagement {

	public static ArrayList<Car> passedCars = new ArrayList<Car>();
    
	public static String genareteName(Random rand) {
		var name="";
		var surname="";
		var keys = "asdfghjklizxcvbnmqwertyuopASDFGHJKLZXCVBNMQWERTYUOPI";
		var nameCount=rand.nextInt(20)+5;
		var surnameCount=rand.nextInt(20)+5;
		while(nameCount!=0 && surnameCount!=0) {
			if(nameCount!=0)
			   name += keys.charAt(rand.nextInt(keys.length()));
			if(surnameCount!=0)
				surname += keys.charAt(rand.nextInt(keys.length()));
			
			nameCount--;
			surnameCount--;
		}
		return name+","+surname;
	}
	
	public static int getTotalProfit(
	ArrayList<Car> _passedCars,
	String searchingDate,
	SimpleDateFormat formatter) throws ParseException {
		var total=0;
		for(int i=0; i<_passedCars.size();i++) {
		    var type = _passedCars.get(i).type;
			switch(type) {
			case "car":
				total+=20;	
				break;
			case "miniBus":
				total+=30;
				break;
			case "bus":
				total+=40;
				break;
		}
			
		}
		
		return total;
	}
	
	public static void main(String[] args) throws ParseException {
		Car car;
		var rand = new Random();
		var date = new Date();  
		var formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		for(int i=0; i<100;i++) {
			car = new Car();
			var nameData = genareteName(rand).split(",");
			car.balance = rand.nextInt(1000);;
			car.hgsNo = rand.nextInt(10000000);
			car.name = nameData[0];
			car.username = nameData[1];
			var type = rand.nextInt(3);
			switch(type) {
			case 0:
				car.type="car";
			break;
			case 1:
				car.type="miniBus";
			break;
			case 2:
				car.type="bus";
			break;
			}
			var currentBalance = payment.paymentFunction(car.balance, car.type);
			if(car.balance != currentBalance) {
				date = new Date();
				car.passedTime = formatter.format(date).toString();
				car.balance = currentBalance;
				passedCars.add(car);
			}
			
		}
		 
		System.out.println(getTotalProfit(
				passedCars,
				"29/08/2022",
				 formatter
				));
		
		
	}
	
}
