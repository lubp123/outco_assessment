import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * Problem: nth Fibonacci number
 *
 * Write two functions that return the nth Fibonacci number
 * using dynamic programming
 *
 * In your first implementation, implement a top-down 
 * approach using memoization. In your secon implementation, 
 * implement a bottom-up approach using tabulation
 *
 * Your functions should be able to handle finding the 1000th
 * Fibonacci number
 * 
 */

public class fibonacci {
  public static void main(String args[]) {
    TopDown prob1 = new TopDown();
    System.out.println(prob1.fib(1000));

    BottomUp prob2 = new BottomUp();
    System.out.println(prob2.fib(1000));
  }
}

class TopDown {
  HashMap<Integer, Integer> fibCache = new HashMap<Integer,Integer>(); 
  public int fib(int n){
  
  //check cahe
  if(fibCache.get(n)!=null){
	  return fibCache.get(n); 
  }
  if(n ==0){
	  return 0; 
  }else if(n ==1){
	  return 1; 
  }
  int fib1 = fib(n-2); 
  fibCache.put(n-2, fib1);
  int fib2 = fib(n-1); 
 
  return fib1 + fib2; 
	  
  }
}

class BottomUp {
 //implement a global queue 
 LinkedList<Integer> sumQueue = new LinkedList<Integer>(); 
  public int fib(int n){
    //initlize queue 
	  sumQueue.push(1);
	  sumQueue.push(1);
	  int count = 0;
	  while(count != n-2){
		  int newSum = sumQueue.pop() + sumQueue.peek(); 
		  sumQueue.addLast(newSum);
		  count++; 
	  }
	 
	 return sumQueue.removeLast();
  }
}





