package learners.functions;


public class GaussianFunction implements ActivationFunction {
	
	private static double a = 1.0 / Math.sqrt(2.0 * Math.PI);
    
	public double compute(double x) {
	    return a * Math.exp(-(x * x) / 2);
	}

	public double computeDerivative(double x) {
	    return x * compute(x);
	}
    
}
