package Stack;

import java.util.Scanner;

import Stack.lib.Stack;

//utilizei pilha pra resolver a questão 4 da lista de Fila
public class QueueQ4 {
  private static Stack<Integer> factors = new Stack<>();
  static Scanner inputKeyboard = new Scanner(System.in);
  public static void main(String args[]) {

    System.out.println("Type a number and see the number's factors in descending order");
    int number =inputKeyboard.nextInt();
    
    while(number>1){
      int divisor = findFactor(number);
      factors.push(divisor);
      number=number/divisor;
    }

    while(!factors.isEmpty()){
      System.out.print(factors.pop()+ " ");
    }
    System.out.println();
  }
  
  private static int  findFactor(int n){
    for(int i=2;i<n/2;i++){
      if(isPrime(i)&&n%i==0){
        return i;
      }
    }
    return n;
  }
  private static boolean isPrime(int n) {
    for (int i = 2; i < n / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}
