// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2>0){
			for(int i=0;i<x2;i++){
			x1++;
		}}
		else{
			for(int i=0;i<(-x2);i++){
			x1--;
		}}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2<0){
			for(int i=0;i<(-x2);i++){
			x1++;
		}}
		else{
			for(int i=0;i<(x2);i++){
			x1--;
		}}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int add= x1;
		int Max=x2;
		if(x2<0){
		  Max= minus(minus(x2, x2), x2);
		}
		for(int i=1; i<Max; i++){
			x1 = plus(x1, add);
		}
		if(x2>0){
			return x1;
		} else{
			return minus(minus(x1, x1), x1);
		}
		
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int add = x;
		for(int i=1; i<n; i++){
			x = times(x, add);
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int counter = 0;
		boolean Negative = false;
		if(x2 == 0){
			return(00);
		}
		if(x1 < 0){
			x1 = times(x1, -1);
			Negative = !Negative;
		}
		if(x2<0){
			x2 = times(x2, -1);
			Negative =!Negative;
			
		}
		while(x2 <= x1){
			x1 = minus(x1, x2);
			counter++;
		}
		if(Negative == true){
			return(times(counter, -1));
		} else{
			return(counter);
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		boolean Negative = false;
		if(x1<0 && x2<0){
			Negative = true;
			x1=times(x1, -1);
			x2=-times(x2, -1);
		}
		while(x2 <= x1){
			x1= minus(x1, x2);
		}
		if(Negative == true){
			return(times(x1, -1));
		} else{
			return(x1);
		}
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int L= 1;
		int H= x;
		int g= 0;
		int i=1;
		int square=0;
		while(i!=0){
			g = div(plus(L, H), 2);
			if(pow(g, 2) > x){
				H=g;
			} else{
				if(pow(square,2)<pow(g,2)){
					square=g;
					L=g;
				}
				else{
					i=0;
				}
			}
		}
		return square;
		}
	}
	  	  
