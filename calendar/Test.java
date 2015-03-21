package calendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test{
	public static void main(String[] args){
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); //Create a new format dd/MM/yyyy hh:mm:ss
		
		Date time = GregorianCalendar.getInstance().getTime(); //Get the current date
		long currentTimeMillis = GregorianCalendar.getInstance().getTimeInMillis(); //Get the current date in milliseconds(Initial time)
		System.out.println("Initial date: "+date.format(time)); //Print the current date in the format dd/MM/yyyy hh:mm:ss
		
		date.applyPattern("yyyyMMdd"); //Set the date format to yyyyMMdd
		GregorianCalendar gregorianCalendar = new GregorianCalendar(2015,2,20,20,57); //Create a new gregorian calendar with a date enter as parameter
		System.out.println(date.format(gregorianCalendar.getTime())); //Print the gregorian date in format yyyyMMdd
		long gregorianTimeMillis = gregorianCalendar.getTimeInMillis(); //Store the gregorian time in millis
		
		date.applyPattern("MM/dd/yy hh mm"); //Set the format to MM/dd/yy hh mm
		System.out.println(date.format(gregorianCalendar.getTime())); //Print the gregorian date in the previous format
		
		if(gregorianTimeMillis > currentTimeMillis){ //Check if the current time is a date before the enter as parameter in the gregorian calendar
			System.out.println("Before");
		}else if(gregorianTimeMillis < currentTimeMillis){
			System.out.println("After");
		}else{
			System.out.println("Equals");
		}
		
		date.applyPattern("dd/MM/yyyy hh:mm:ss"); //Change the format to dd/MM/yyyy hh:mm:ss
		time = GregorianCalendar.getInstance().getTime(); //Get the date before finalizing the program
		System.out.println("Finalizing date: "+date.format(time)); //Print the finalizing date in the format dd/MM/yyyy hh:mm:ss
		System.out.println();
		
		currentTimeMillis = GregorianCalendar.getInstance().getTimeInMillis() - currentTimeMillis; //Calculate the program execution time. It will be the time at last minus the time at the begining
		
		System.out.println("The timing of the program is: "+currentTimeMillis+" ms.");
	}
}