# ReadMe

<details>
  <summary> Deutsch / German </summary>
 
### Installation 

* **Downloads:**
  * JDK: [Java Development Kit](https://www.oracle.com/java/technologies/downloads/#javasejdk)
  * Visual Studio Code: [Visual Studio Code Download](https://code.visualstudio.com/)

* **Installation:**
  * Folgen Sie den Anweisungen des JDK-Installers.
  * In VS Code unter _Extensions_ laden Sie das Paket _Extension Pack for Java_ von Microsoft herunter, indem Sie `⇧` + `⌘` + `X` oder `STRG` + `⇧` + `X` drücken und danach suchen.

### Codebeschreibung

### Calc.java

* **Importierte Bibliotheken:**
  ```java
    import java.util.Scanner;
  ```
  Die Bibliotheken:
  * _Scanner_ wird für die Eingabeüberwachung verwendet.

* **Definition von Textfarben:**
  ```java
    public static final String ANSI_RESET = "\u001B[0m"; // Reset color
    public static final String ANSI_RED = "\u001B[31m"; // Red
    public static final String ANSI_GREEN = "\u001B[32m"; // Green
  ```
* **Erstellen einse neuen Scanner Objektes:**
  ```java
  public static Scanner reader = new Scanner(System.in);
  ```
  Das Scanner-Objekt wird unter dem Bezeichner _reader_ zugänglich gemacht.

* **Statische Float-Variable zum Speichern des letzten Ergebnisses:**
  ```java
    static float ans;
  ```
  _ans_ wird am Anfang des Codes als statische Variable definiert, um das Ergebnis von überall abzurufen oder zu überschreiben bzw. zu speichern.

* **Funktion zum Beenden des Codes:**
  ```java
    static void quit_code() {
      reader.close();
      System.out.println(ANSI_GREEN + "Program ended with exitcode: 0" + ANSI_RESET);
      System.exit(0);
    }
  ```
  Die Funktion schließt das Objekt der Klasse Scanner, _reader_, gibt eine Bestätigung aus und beendet das Programm mit dem Exit-Code 0.

* **While-Loop in der static void Methode:**
  ```java
    public static void main(String[] args) {
      int input = 0;

      // Define options
      System.out.println(
        "Please choose one of these options:\n(1) Add\n(2) Subtract\n(3) Multiply\n(4) Divide\n-----\n(9) Quit");
      while (true) {
  ```
  Da die Datei [Calc.java](/Project/Calc.java) die Hauptdatei ist, enthält sie eine `static void main` Methode. Im folgenden werden die möglichen Operationen angezeigt, die verwendet werden können. Anschließend wird eine While-True-Schleife geöffnet, die es ermöglicht, fortlaufend Befehle einzugeben bzw. die Rechenoperation auszuwählen.

* **Eingabeaufforderung für die Rechenoperation:**
  ```java
    try {
      System.out.print("\nInput: : ");
      input = reader.nextInt(); 
    } catch (Exception e) {
      System.out.println(ANSI_RED + e + ANSI_RESET);
    } finally {
      reader.nextLine(); 
    }
  ```
  Am Anfang der While-True-Schleife wird ein Try-Catch-Finally-Block eingefügt, der die Eingabe der Rechenoperation ermöglicht. Der Try-Block ist notwendig, um Fehler bei Eingaben anderer als Integer zu vermeiden. Wenn jedoch eine Eingabe erfolgt, die kein Integer ist, wird der Fehler ausgegeben, ohne dass das Programm beendet wird. Schließlich wird der Puffer gelöscht, um Probleme mit der Eingabe zu vermeiden.

* **Switch-Cases:**
  ```java
    try {
      System.out.print("\nInput: ");
      input = reader.nextInt(); // picking an option
    } catch (Exception e) {
      System.out.println(ANSI_RED + e + ANSI_RESET);
    } finally {
      reader.nextLine(); // clear buffer
    }

    switch (input) {
      case 9:
        quit_code();
        break;
      case 1:
        /* Add */
        if (ans != 0) {
          System.out.print("Do you want to use the previus result (" + ans
            + ")? Type 'y' if yes and something else, if not?\nInput: ");
          String use_ans = reader.nextLine();

          if (use_ans.equals("y")) {
            ans = Operations.add_r(ans);
          } else {
            ans = Operations.add();
          }
        } else {
          ans = Operations.add();
        }
        break;

      case 2:
        /* Subtract */
        if (ans != 0) {
          System.out.println("Do you want to use the previus result (" + ans
            + ")? Type 'y' if yes and something else, if not?\nInput: ");
          String use_ans = reader.nextLine();

          if (use_ans.equals("y")) {
            ans = Operations.sub_r(ans);
          } else {
            ans = Operations.sub();
          }
        }
        ans = Operations.sub();
        break;

      case 3:
        /* Multiply */
        if (ans != 0) {
          System.out.print("Do you want to use the previus result (" + ans
            + ")? Type 'y' if yes and something else, if not?\nInput: ");
          String use_ans = reader.nextLine();

          if (use_ans.equals("y")) {
            ans = Operations.mult_r(ans);
          } else {
            ans = Operations.mult();
          }
        } else {
          ans = Operations.mult();
        }
        break;

      case 4:
        /* Divide */
        if (ans != 0) {
          System.out.print("Do you want to use the previus result (" + ans
            + ")? Type 'y' if yes and something else, if not?\nInput: ");
          String use_ans = reader.nextLine();

          if (use_ans.equals("y")) {
            ans = Operations.div_r(ans);
          } else {
            ans = Operations.div();
          }
        } else {
          ans = Operations.div();
        }
        break;

      case 5:
        /* Show previus result */
        System.out.println(ans);
        break;
  
      default:
        System.out.println( ANSI_RED + "This is not a valid Input" + ANSI_RESET);
    }
  ```
  Der obige Code zeigt die Switch-Abfrage mit den verschiedenen Cases. Jede Zahl ist in diesem Fall eine Ausführung bzw. Zuweisung

</details>

<details>
  <summary> English / Englisch</summary>
# ReadMe

### Installation 

* **Downloads:**
  * JDK: [Java Development Kit](https://www.oracle.com/java/technologies/downloads/#javasejdk)
  * Visual Studio Code: [Visual Studio Code Download](https://code.visualstudio.com/)

* **Installation:**
  * Follow the instructions of the JDK installer.
  * In VS Code, under _Extensions_, download the _Extension Pack for Java_ package from Microsoft by pressing `⇧` + `⌘` + `X` or `CTRL` + `⇧` + `X` and then searching for it.

### Code Description

### Calc.java

* **Imported Libraries:**
  ```java
    import java.util.Scanner;
  ```
  The libraries:
  * _Scanner_ is used for input monitoring.

* **Definition of Text Colors:**
  ```java
    public static final String ANSI_RESET = "\u001B[0m"; // Reset color
    public static final String ANSI_RED = "\u001B[31m"; // Red color
    public static final String ANSI_GREEN = "\u001B[32m"; // Green Color
  ```
* **Opening the Scanner:**
  ```java
  public static Scanner reader = new Scanner(System.in);
  ```
  The Scanner object is made accessible under the identifier _reader_.

* **Static Float Variable for Storing the Last Result:**
  ```java
    static float ans;
  ```
  _ans_ is defined as a static variable at the beginning of the code to retrieve, overwrite, or store the result from anywhere.

* **Function to Exit the Code:**
  ```java
    static void quit_code() {
      reader.close();
      System.out.println(ANSI_GREEN + "Program ended with exit code: 0" + ANSI_RESET);
      System.exit(0);
    }
  ```
  The function closes the _reader_ scanner, prints a confirmation, and exits the program with exit code 0.

* **While-Loop in the Static void Method:**
  ```java
    public static void main(String[] args) {
      int input = 0;

      // Defining the options
      System.out.println(
        "Please choose one of these options:\n(1) Add\n(2) Subtract\n(3) Multiply\n(4) Divide\n-----\n(9) Quit");
      while (true) {
  ```
  Since the file [Calc.java](/Project/Calc.java) is the main file, it contains a `static void main` method. Here, the possible operations are displayed, followed by a while-true loop that allows continuous input of commands or selection of the arithmetic operation.

* **Input Prompt for Arithmetic Operation:**
  ```java
    try {
      System.out.print("\nInput: ");
      input = reader.nextInt(); // picking an option
    } catch (Exception e) {
      System.out.println(ANSI_RED + e + ANSI_RESET);
    } finally {
      reader.nextLine(); // clear buffer
    }
  ```
  At the beginning of the while-true loop, a try-catch-finally block is inserted to enable the input of the arithmetic operation. The try block is necessary to handle errors with inputs other than integers. If an input other than an integer occurs, the error is displayed without ending the program. Finally, the buffer is cleared to avoid issues with input.

* **Switch-Cases:**
  ```java
    try {
      System.out.print("\nInput: ");
      input = reader.nextInt(); // picking an option
    } catch (Exception e) {
      System.out.println(ANSI_RED + e + ANSI_RESET);
    } finally {
      reader.nextLine(); // clear buffer
    }

    switch (input) {
      case 9:
        quit_code();
        break;
      case 1:
        /* Add */
        if (ans != 0) {
          System.out.print("Do you want to use the previous result (" + ans
            + ")? Type 'y' if yes and something else, if not?\nInput: ");
          String use_ans = reader.nextLine();

          if (use_ans.equals("y")) {
            ans = Operations.add_r(ans);
          } else {
            ans = Operations.add();
          }
        } else {
          ans = Operations.add();
        }
        break;

        case 2:
          /* Subtract */
          if (ans != 0) {
            System.out.println("Do you want to use the previous result (" + ans
              + ")? Type 'y' if yes and something else, if not?\nInput: ");
            String use_ans = reader.nextLine();

            if (use_ans.equals("y")) {
              ans = Operations.sub_r(ans);
            } else {
              ans = Operations.sub();
            }
          }
          ans = Operations.sub();
          break;

          case 3:
            /* Multiply */
            if (ans != 0) {
              System.out.print("Do you want to use the previous result (" + ans
                + ")? Type 'y' if yes and something else, if not?\nInput: ");
              String use_ans = reader.nextLine();

              if (use_ans.equals("y")) {
                ans = Operations.mult_r(ans);
              } else {
                ans = Operations.mult();
              }
            } else {
              ans = Operations.mult();
            }
            break;

          case 4:
            /* Divide */
            if (ans != 0) {
              System.out.print("Do you want to use the previous result (" + ans
                + ")? Type 'y' if yes and something else, if not?\nInput: ");
              String use_ans = reader.nextLine();

              if (use_ans.equals("y")) {
                ans = Operations.div_r(ans);
              } else {
                ans = Operations.div();
              }
            } else {
              ans = Operations.div();
            }
            break;

            case 5:
              /* Show previous result */
              System.out.println(ans);
              break;
  
            default:
              System.out.println( ANSI_RED + "This is not a valid Input" + ANSI_RESET);
            }
  ```
  The above code shows the switch query with different cases. Each number is an execution or assignment
</details>
