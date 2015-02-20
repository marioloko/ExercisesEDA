package exercise3;

public class Complex implements iComplex{
	double real;
	double imaginary;
	
	public Complex(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	@Override
	public void setReal(double real){
		this.real = real;
	}
	
	@Override
	public void setImaginary(double imaginary){
		this.imaginary = imaginary;
	}
	
	@Override
	public double getReal(){
		return this.real;
	}
	
	@Override
	public double getImaginary(){
		return this.imaginary;
	}

	@Override
	public double getModule() {
		double module = Math.sqrt((this.real*this.real)+(this.imaginary*this.imaginary));
		return module;
	}

	@Override
	public iComplex sum(iComplex otherComplex) {
		double newReal = this.real + otherComplex.getReal();
		double newImaginary = this.imaginary + otherComplex.getImaginary();
		Complex sumComplex = new Complex(newReal,newImaginary);
		return sumComplex;
	}

	@Override
	public iComplex multiplication(iComplex otherComplex) {
		double newReal = (this.real*otherComplex.getReal())-(this.imaginary*otherComplex.getImaginary());
		double newImaginary =(this.imaginary*otherComplex.getReal()+this.real*otherComplex.getImaginary());
		Complex multiplicationComplex= new Complex(newReal,newImaginary);
		return multiplicationComplex;
	}	
}