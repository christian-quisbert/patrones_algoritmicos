package factorial;

public class Factorial {
	private static double r = 1;
	
	// Iterativo
	public static double factorial1 (int num){
		while(num >= 2){
			r *= num;
			num--;
		}
		return r;
	}
	
	// Recursivo
	public static double factorial2 (int num){
		if(num >= 2){
			r = num * factorial2(num-1);
		}
		else{
			return 1;
		}
		return r;
	}
	
	public static void main (String[] args){
		double a = factorial1(100);
		double b = factorial2(100);
		System.out.println(a);
		System.out.println(b);
	}
}
