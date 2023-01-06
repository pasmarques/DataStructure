package Stack;

import Stack.lib.Stack;
import java.util.Random;
//não consegui fazer usando Stack implementada em vetor 
public class Q4 {
  public static void main(String args[]) {
    final int MAX_SIZE = 52;
    final Stack <Integer> cheap = new Stack<Integer>();
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    Stack<Integer> s3 = new Stack<Integer>();
    Stack<Integer> s4 = new Stack<Integer>();
    int i;

    for(i = 1; i <= MAX_SIZE; i++){
      cheap.push(i);
    }

    Random sizeOfStacks = new Random();
    int size1;
    int size2;
    int size3;
    
    size1 = sizeOfStacks.nextInt(MAX_SIZE) + 1; // (1 ate 52)
    size2 = sizeOfStacks.nextInt(MAX_SIZE) + 1; // (1 até 52)
    size3 = sizeOfStacks.nextInt(MAX_SIZE) + 1; // (1 até 52)

    //enquanto a soma dos tamanhos não for 52 gera mais número
    while(size1 + size2 + size3 != MAX_SIZE)
    {
      size1 = sizeOfStacks.nextInt(MAX_SIZE) + 1; // (1 ate 52)
      size2 = sizeOfStacks.nextInt(MAX_SIZE) + 1; // (1 até 52)
      size3 = sizeOfStacks.nextInt(MAX_SIZE) + 1; // (1 até 52)
    }
   
    //preenche cada pilha até o tamanho gerado
    while (s1.size() != size1) {
      i = 0;
      s1.push(cheap.pop());
      i++;
    }

    while (s2.size() != size2) {
      i = 0;
      s1.push(cheap.pop());
      i++;
    }

    while (s3.size() != size3) {
      i = 0;
      s1.push(cheap.pop());
      i++;
    }
    
    //percorre as pilhas tirando os items do topo e os recombina na 4 pilha
    while(!s1.isEmpty()){
      s4.push(s1.pop());
    }

    while(!s2.isEmpty()){
      s4.push(s2.pop());
    }

    while(!s3.isEmpty()){
      s4.push(s3.pop());
    }
    //printa a 4 pilha embaralhada
    s4.toString();

  }
}
