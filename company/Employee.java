package company;

public class Employee{
	int cod_employee; //The Employeer code
	String name; //The Employer name
	String surname; //The Employer surname
	
	/**By default will create me as Employee: Adrian Gallego, with code 12345678*/
	public Employee(){
		this(12345678,"Adrián","Gallego");
	}
	
	/**With the full constructor we will give values to all values of  the Employee*/
	public Employee(int cod_employee, String name, String surname){
		this.cod_employee = cod_employee;
		this.name = name;
		this.surname = surname;
	}
	
	/**Return an String with all the characteristics of our Employee*/
	public String toString(){
		String str = "Employee name: "+name+"\n";
		str += "Employee surname: "+surname+"\n";
		str += cod_employee+"\n";
		return str;
	}
}