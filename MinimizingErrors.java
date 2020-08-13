//input -  Number Of Users n, P, Q.
//input - E1, E2, E3,.... E(n).

//Output - Minimum numbers of operations to get error count zero.
//Note :- When user's error count decreases from P (an operation), all others decreases from Q. 


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

class MinimizingErrors 
{
	public static void main(String args[] )
	{
		// Write your code here
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int p = s.nextInt();
		int q = s.nextInt();
		int [] errors = new int[n];
		int projects = 0;
		
		for(int i=0; i<n; i++){
		    errors[i] = s.nextInt();
		}
		Arrays.sort(errors);
		for(int i=0; i < n; i++){
        	if(errors[n-1]>0){	
        		if(errors[n-1]%p == 0){
        	    	projects = projects + (errors[n-1] / p ) - 1;
    		        errors[n-1] = (errors[n-1]%p) + p;
    		        for(int j=0;j<n-1;j++){
    		            errors[j] = errors[j]-q;
    		        }
        		}else{
        		    projects = projects + (errors[n-1] / p );
        		    errors[n-1] = errors[n-1]%p;
        		    for(int j=0;j<n-1;j++){
    		            errors[j] = errors[j]-q;
    		        }
        		}
		    }else{
		       break; 
		    }
		    Arrays.sort(errors);
		}		
		System.out.println(projects);
	}
}
