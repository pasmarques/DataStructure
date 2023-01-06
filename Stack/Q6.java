package Stack;

import java.util.Scanner;
import Stack.lib.Stack;

public class Q6 {
  final static int MAX_SIZE = 10;// estacionamento com 10 carros

  static Stack<String> cars = new Stack<String>(MAX_SIZE);
  static Stack<String> aux = new Stack<String>(MAX_SIZE);
  static Scanner inputKeyboard = new Scanner(System.in);
  static String userInputStr;

  public static void main(String args[]) {

    do {
      System.out.println("\nChoose an option:");
      System.out.println("1-Enter with a car:");
      System.out.println("2-Leave with a car:");
      System.out.println("0-Exit to parking:");

      userInputStr = inputKeyboard.nextLine();

      if (Integer.parseInt(userInputStr) == 1) {
        entranceMenu();
      } else if (Integer.parseInt(userInputStr) == 2) {
        exitMenu();
      } else if (Integer.parseInt(userInputStr) == 0) {
        System.out.println("\nExiting program");
        inputKeyboard.close();
        return;
      }
    } while (Integer.parseInt(userInputStr) != 0);

  }

  private static void entranceMenu() {

    System.out.println("Car arriving in the parking lot");
    if (cars.isFull()) {
      System.out.println("There are no many parking spaces to put you car");
      return;
    }
    System.out.println("Please, type the license Plate of your car: ");
    String userInputStr;
    userInputStr = inputKeyboard.nextLine();
    cars.push(userInputStr);
    continueInEntranceMenu();

  }
  private static void continueInEntranceMenu(){
    do {
      System.out.println("\nGot another car waiting to park? ");
      System.out.println("\nChoose an option:");
      System.out.println("1-Yes:");
      System.out.println("2-No:");

      userInputStr = inputKeyboard.nextLine();
      if (Integer.parseInt(userInputStr)==1) {
        entranceMenu();
      } else if (Integer.parseInt(userInputStr)==2) {
        continue;
      }
    } while (Integer.parseInt(userInputStr)!=1&&Integer.parseInt(userInputStr)!=2);
  }

  private static void exitMenu() {
    if (cars.size() == 0) {
      System.out.println("\nParking is empty");
      return;
    }
    System.out.println("Car is leaving the parking lot");
    System.out.println("Please, type the license Plate of the car: ");
    userInputStr=inputKeyboard.nextLine();

    int cont=0;
    //enquanto não achar a placa do carro
    while(cars.peek().equals(userInputStr) != true){
      aux.push(cars.pop());
      cont++;//conta as manobras
    }
    cars.pop();//tira o carro desejado de fato
    System.out.println("\nThe car was maneuvered  " + cont + " times until leave the parking");

    while(cont != 0){
      cars.push(aux.pop());//reordena a pilha com os carros que foram removidos para remover um carro x
      cont--;
    }

  }
}
