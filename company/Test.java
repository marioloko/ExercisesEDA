package company;

public class Test{
	public static void main(String[] args){
		Company company = new Company();
		company.hireEmployee(new Employee());
		
		//Store in an array the current members of the company
		Employee[] employees = company.toArray();
		
		//Print all the current employees of the company
		for(int pos=0;pos<employees.length;pos++){
			System.out.println(employees[pos]);
		}
		
		//Check if exist a new employee
		boolean exist = company.existEmployee(new Employee());
		System.out.println(exist);
		
		//Add the bruce employee to the company and then check if exist
		Employee bruce = new Employee(10101010,"Bruce","Wayne");
		company.hireEmployee(bruce);
		boolean existBruce = company.existEmployee(bruce);
		System.out.println(existBruce);
		
		//Check the size of the company
		int size = company.employeesNumber();
		System.out.println(size);
		
		//FireEverybody and then check if there is no employee in the company(size=0)
		company.fireEverybody();
		size = company.employeesNumber();
		System.out.println("After firing everybody the size is: "+size);
		
		//hire Bruce and a new employee
		company.hireEmployee(bruce);
		company.hireEmployee(new Employee());
		
		//check if both has been hired
		size = company.employeesNumber();
		System.out.println("Now the size is: "+size);
		
		//fire bruce and check that it has been fired
		boolean found = company.fireEmployee(bruce);
		size = company.employeesNumber();
		System.out.println("Has bruce been found: "+found);
		System.out.println("After firing bruce the size is: "+size);
		
		//try to fire a new employee
		found = company.fireEmployee(new Employee());
		size = company.employeesNumber();
		System.out.println("Has the new employee been found: "+found);
		System.out.println("After trying to fire the new Employee the size is: "+size);
		
	}
}