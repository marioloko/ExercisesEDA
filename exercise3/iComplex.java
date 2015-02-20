package exercise3;

public interface iComplex{
	/**
	 * Set a number for the real part of a complex number
	 * @param real The number to set for the real part
	 */
	void setReal(double real);
	/**
	 * Set a imaginary number for the imaginary part of a complex number
	 * @param imaginary The imaginary number to set for the real part
	 */
	void setImaginary(double imaginary);
	/**
	 * Give you the real part of a complex number
	 * @return The real part of a complex number
	 */
	double getReal();
	/**
	 * Give you the imaginary part of a colplex number
	 * @return The real part of a complex number
	 */
	double getImaginary();
	/**
	 * Give you the module of a complex number
	 * @return
	 */
	double getModule();
	/**
	 * Return the sum of two complex numbers
	 * @param otherComplex other complex number to be sum
	 * @return The sum of two complex numbers
	 */
	iComplex sum(iComplex otherComplex);
	/**
	 * Return the multiplication of two complex numbers
	 * @param otherComplex Other complex number to be multiplicated
	 * @return The multiplication between two complex numbers
	 */
	iComplex multiplication(iComplex otherComplex);
	
}