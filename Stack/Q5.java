package Stack;

import java.util.Scanner;
import Stack.lib.Stack;

public class Q5 {
  public static void main(String args[]) {
    final String userInputStr;
    Scanner inputKeyboard = new Scanner(System.in);

    System.out.println("Type an expression to verify if was balanced: ");
    userInputStr = inputKeyboard.nextLine();

    if (validateExpression(userInputStr)){
      System.out.println("Valid expression");
    } 
    else{
      System.out.println("Invalid expression");
    }
    inputKeyboard.close();
  }
  
  //considerando expressões do tipo dados na questão, já começam com os caracteres (, [ ou {
  public static boolean validateExpression(String expression) {
    Stack<Character> str = new Stack<Character>();
    char currentChar;

    for (int i = 0; i < expression.length(); i++) {
      currentChar = expression.charAt(i);// pega o caracter da posição
      if (currentChar == '(' || currentChar == '[' || currentChar == '{') {// se for caracter de abertura na expressão
        str.push(currentChar);
      }
      char verifyClosing;// variável pra analisar se o caracter atual tem fechamento na expressão;
      //entra nesse switch semper que não encontrar um caracter de abertura
      //ao entrar olha o topo da pilha, que guarda sempre o último caractere de abertura encontrado
      switch (currentChar) {
        case ')':
          verifyClosing = str.pop();
          if (verifyClosing == '{' || verifyClosing == '[')
            return false;
          break;

        case ']':
          verifyClosing = str.pop();
          if (verifyClosing == '(' || verifyClosing == '{')
            return false;
          break;

        case '}':
          verifyClosing = str.pop();
          if (verifyClosing == '(' || verifyClosing == '[')
            return false;
          break;
      }
    }
    return (str.isEmpty());// se a pilha tiver vazia, expressão está balanceada
  }
}

