class ComplexNumber {

    private double real;
    private double imaginary;
    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    double getReal() {
        return real;
    }

    double getImaginary() {
        return imaginary;
    }

    double abs() {
       return Math.sqrt(Math.pow(real,2)+Math.pow(imaginary,2));
    }

    ComplexNumber add(ComplexNumber other) {
        double sumReal = real+other.real;
        double sumImaginary = imaginary+other.imaginary;
        return new ComplexNumber(sumReal,sumImaginary);
    }

    ComplexNumber subtract(ComplexNumber other) {
        double diffReal = real-other.real;
        double diffImaginary = imaginary-other.imaginary;
        return new ComplexNumber(diffReal,diffImaginary);
    }

    ComplexNumber multiply(ComplexNumber other) {
        double prodReal = real*other.real -  imaginary*other.imaginary;
        double prodImaginary = imaginary*other.real + real*other.imaginary;
        return new ComplexNumber(prodReal,prodImaginary);
    }

    ComplexNumber divide(ComplexNumber other) {
       double divReal = (real*other.real + imaginary*other.imaginary)/(other.real*other.real+other.imaginary*other.imaginary);
       double divImg = (imaginary*other.real - real*other.imaginary)/(other.real*other.real+other.imaginary*other.imaginary);
       return new ComplexNumber(divReal,divImg);
    }

    ComplexNumber conjugate() {
        return new ComplexNumber(real,-imaginary);
    }

    ComplexNumber exponentialOf() {
        double exp_a = Math.exp(this.real); // Calculate e^a
        double cos_b = Math.cos(this.imaginary); // Calculate cos(b)
        double sin_b = Math.sin(this.imaginary); // Calculate sin(b)

        double resultReal = exp_a * cos_b;
        double resultImaginary = exp_a * sin_b;

        return new ComplexNumber(resultReal, resultImaginary);
    }
}