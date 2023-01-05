package Stack;

import Stack.lib.Stack;
import java.util.Random;

//não consegui fazer usando pilha implementada em vetor 
public class Q4 {
  //tamanho máximo do barulho
  final static int MAX_SIZE = 52;
  //declarando o baralho
  final static Stack <Integer> cheap = new Stack<Integer>();
  public static void main(String args[]) {
    createStacksWithValidateOfSize();
  }

  public static void createStacksWithValidateOfSize() {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    Stack<Integer> s3 = new Stack<Integer>();
    Stack<Integer> s4 = new Stack<Integer>();

    Random sizeOfStacks = new Random();
    int size1;
    int size2;
    int size3;
    int i;

    size1 = sizeOfStacks.nextInt(MAX_SIZE) + 1; // (1 ate 52)
    size2 = sizeOfStacks.nextInt(MAX_SIZE) + 1; // (1 até 52)
    size3 = sizeOfStacks.nextInt(MAX_SIZE) + 1; // (1 até 52)

    //preenche o baralho
    for(i=0;i<MAX_SIZE;i++){
      cheap.push(i+1);//1 representando o ÁS;
    }

    if (size1 + size2 + size3 != MAX_SIZE) {
      createStacksWithValidateOfSize();//roda até o tamanho ser 52
    } else {
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
  }
}
