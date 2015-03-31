package company;
import java.util.ArrayList;

public class Company{
	private String name; //name of the company
	private ArrayList<Employee> employeesList; //List of the employees of that company
	
	/**The default constructor create the UC3M company*/
	public Company(){
		this("UC3M");
	}
	
	/**The String constructor create a company with the name enter as parameter
	 * 
	 * @param name
	 */
	public Company(String name){
		this.name = name;
		this.employeesList = new ArrayList<Employee>(); //Initializate the employees ArrayList
	}
	
	/**Convert the arrayList of employees in an array of employees
	 * 
	 * @return an array of employees
	 */
	public Employee[] toArray(){
		Employee[] employees = new Employee[employeesList.size()]; //Create a new array with the length of the employeesList size
		return employeesList.toArray(employees); //Store each elements of the arrayList in the employees array and return it
	}
	
	/**Add a new employee to the employeesList if the employee enter as parameter is not a null objects
	 * 
	 * @param e, Employee to be hire in the company
	 */
	public void hireEmployee(Employee e){
		if(e != null){
			employeesList.add(e); //Add the new employee to the employeeList
		}
	}
	
	/**Calculate the number of employees which is the employeesList size
	 * 
	 * @return The number of the employees 
	 */
	public int employeesNumber(){
		return employeesList.size(); //The size of the array list will be the number of employees
	}
	
	/**Check if exist a given Employee enter as parameter, to do that check if that Employee belongs to the employees list
	 * 
	 * @param e, Employee to check whether is in the company or not
	 * @return true if the Employee works in that company
	 */
	public boolean existEmployee(Employee e){
		return employeesList.contains(e); //If the list of employees contains than employee then the employee existd
	}

	/**Fire everybody in the company, removing every Employee in th employeesList*/
	public void fireEverybody(){
		employeesList.clear(); //Remove all the employees in the employees List
	}
	
	/**Fire the Employee enter as parameter, and return if the Employee was in the company before firing him
	 * 
	 * @param e, Employee to get fired away of the company
	 * @return Whether the Employee has been found within the company or not
	 */
	public boolean fireEmployee(Employee e){
		return employeesList.remove(e); //Remove an employee from the employee list, if the employee does not exist return false
	}
}