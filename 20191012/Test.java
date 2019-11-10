//递归调用思想
import java.util.Scanner;
public class Test {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("请输入台阶数：");
		int n = sc.nextInt();
		System.out.println(fun(n));
			
	}
	
	public static int fun (int n){
		if(n == 1 || n == 2){
			return n;
		}
		return fun(n-1) + fun(n-2);
	}
}
	

/*
public class Test {
	public static void main(String[] args) {
		int num = 3;
		System.out.println(sum(num));
	}

	public static int sum(int num) {
		if(num == 1 || num == 2 ) {
		    return num;
		}	
	    return sum(num - 1) + sum(num - 2);		
	}
}



public class Test {
	public static void main(String[] args) {
		int num = 3;
		System.out.println(sum(num));
	}

	public static int sum(int num) {
		if(num == 1 || num == 2 ) {
		    return num;
		}	
	    return sum(num - 1) + sum(num - 2);		
	}
}



public class Test {
	public static void main(String[] args) {
		int num = 123;
        int ret = sum(num);	
		System.out.println("ret = " + ret);
	}

	public static int sum(int num) {
		if(num <= 9) {
		    return num;
		}	
	    return num % 10 + sum(num / 10);		
	}
}



public class Test {
	public static void main(String[] args) {
		int sum = 5;	
		System.out.println(sum(num));
	}

	public static int sum(int num) {
		if(num == 1) {
		    return 1;
		}	
	    return num + sum(num - 1);		
	}
}



public class Test {
	public static void main(String[] args) {
		fun(654);	
	}

	public static void fun(int num) {
		if(num > 9) {
			fun(num / 10);
		}	
        System.out.println(num % 10);
	}
}
*/

