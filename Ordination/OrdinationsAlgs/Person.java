package OrdinationsAlgs;

public class Person implements Comparable<Person> {
  private String name;
  private String registration;
  private float pontuation;

  public Person(String name, String registration, Float pontuation) {
    if (validateName(name) && validatePontuation(pontuation) && validateRegister(registration)) {
      this.name = name;
      this.registration = registration;
      this.pontuation = pontuation;
    } else {
      return;
    }
  }

  public String getRegistration() {
    return this.registration;
  }

  public String getName() {
    return this.name;
  }

  public float getPontuation() {
    return this.pontuation;
  }

  private boolean validateName(String name) {
    final int minSize = 3;
    return (name.length() >= minSize);
  }

  private boolean validatePontuation(float pontuation) {
    return (pontuation >= 0);
  }

  private boolean validateRegister(String registration) {
    final int sizeformat = 9;// #########
    return (registration.length() == sizeformat);
  }

  @Override
  public int compareTo(Person obj) {
    if (obj.getName().compareTo(this.getName())>0) {
      return 1;
    }
      return -1;
  }
  
  private boolean equalsLocal(Person obj) {
    return compareTo(obj) == 0;
  }

  @Override
  public boolean equals(Object obj) {
    return equalsLocal((Person) obj);
  }

  @Override
  public String toString() {
    return this.getName() + " " + this.getRegistration() + " " + this.getPontuation();
  }

}
