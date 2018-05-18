public class CalculateRoots {
	public static void main(String[] args){
		double numberToRoot= 4;
		double a=.75;
		double actualRoot= Math.sqrt(numberToRoot);
		double lowCap= 0;
		double highCap= 100*numberToRoot;
		if(lowCap > highCap){
			double temp = lowCap;
			lowCap = highCap;
			highCap = temp;
		}
		System.out.println("" +bisectionMethod(actualRoot, numberToRoot, lowCap, highCap, 0, highCap));
		System.out.println("" +newtonMethod(actualRoot, numberToRoot, 1, 0, highCap));
		System.out.println("" +functionalMethod(actualRoot, numberToRoot, a, 1, 0, highCap));
		
	}
	
/*
 * 
 */
	private static double functionalMethod(double actualRoot, double numberToRoot, double a, double check, int count, double previous) {
		if(java.lang.Math.abs(check-previous) < java.lang.Math.pow(10,-13) ){
			System.out.println("Functional's " +check +" Iterations: " +(count+1));
			return check;
		}
		if(actualRoot!=check){
			double holder = check;
			System.out.println("Functional's " +check);
			check =(1-a)*check+(double)((a*numberToRoot)/check);
			return functionalMethod(actualRoot, numberToRoot, a, check, count +1, holder);
		}
		System.out.println("Functional's " +check +" Iterations: " +count);
		return check;
	}
/*
 * 
 */
	private static double newtonMethod(double actualRoot, double numberToRoot, double check, int count, double previous) {
		if(java.lang.Math.abs(check-previous) < java.lang.Math.pow(10,-13) ){
			System.out.println("Newton's " +check +" Iterations: " +(count+1));
			return check;
		}
		if(actualRoot!=check){
			double holder = check;
			System.out.println("Newton's " +check);
			double temp = check;
			temp = (.5)*(check + (double)(numberToRoot/check));
			check=temp;
			return newtonMethod(actualRoot, numberToRoot, check, count+1, holder);
		}
		
		System.out.println("Newton's " +check +" Iterations: " +count);
		return check;
	}
/*
 * 
 */
	private static double bisectionMethod(double actualRoot, double numberToRoot, double lowCap, double highCap, int count, double previous) {
		double midpoint = (lowCap+highCap)/2;
		System.out.println("bisection's " +midpoint);
		
		if(java.lang.Math.abs(midpoint-previous) < java.lang.Math.pow(10,-13) ){
			midpoint = 1;
			numberToRoot=1;
		}
		  
		if(midpoint*midpoint < numberToRoot)
			return bisectionMethod(actualRoot, actualRoot*actualRoot, midpoint, highCap, count+1, midpoint);
		if(midpoint*midpoint > numberToRoot)
			return bisectionMethod(actualRoot, actualRoot*actualRoot, lowCap, midpoint, count+1, midpoint);
		System.out.println(" Iterations: " +(count+1));
		return midpoint;
	}
	
	

}
