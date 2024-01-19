# ReadMe

### Installation 

* **Downloads:**
  * JDK: [Java Development Kit](https://www.oracle.com/java/technologies/downloads/#javasejdk)
  * Visual Studio Code: [Visual Studio Code Download](https://code.visualstudio.com/)

* **Installation:**
  * Folgen Sie den Anweisungen des JDK-Installers.
  * In VS Code unter _Extensions_ laden Sie das Paket _Extension Pack for Java_ von Microsoft herunter, indem Sie `⇧` + `⌘` + `X` oder `STRG` + `⇧` + `X` drücken und danach suchen.

### Beschreibung des Codes

### Calc.java

* **Importieren der Bibilotheken:**
  ```java
    import java.util.Scanner;
  ```
  Die Bibliotheken:
  * _Scanner_ wird für die Eingabeüberwachung verwendet.

* **Text-Farben Definieren:**
  ```java
    public static final String ANSI_RESET = "\u001B[0m"; // Reset color
    public static final String ANSI_RED = "\u001B[31m"; // Red color
    public static final String ANSI_GREEN = "\u001B[32m"; // Green Color
  ```
* **Scanner eröffenen:**
  ```java
  public static Scanner reader = new Scanner(System.in);
  ```
  Rufe das Objekt Scanner unter dem Bezeichner _reader_ auf.

* **static Float zum Speichern vom Letzten ergebniss:**
  ```java
    static float ans;
  ```
  _ans_ wird am Anfang vomcode als statische Variable definiert, um von überall aus das Ergebniss abzurufen und / oder zu überschrieben bzw. speichern.

* **Funktion zum beenden des Codes:**
  ```java
    static void quit_code() {
      reader.close();
      System.out.println(ANSI_GREEN + "Program ended with exitcode: 0" + ANSI_RESET);
      System.exit(0);
    }
  ```
  Die Funktion schließt den Scanner _reader_, giebt eine Bestätigung aus und beendet das Programm mit Exitode 0.

* **While-loop in Static void Methode:**
  ```java
    public static void main(String[] args) {
      int input = 0;

      // Defining the options
      System.out.println(
        "Please choose one of these options:\n(1) Add\n(2) Subtract\n(3) Multiply\n(4) Divide\n-----\n(9) Quit");
      while (true) {
  ```
  Da die Datei [Calc.java](/Project/Calc.java) die Main-Datei ist, hat sie eine static void main Funktion. Im folgenden werden dann die möglichen Operationen angegeben, welche genutzt werden können. Im folgenden wird ein While-True-Loop geöffnet welcher die immer neue Eingabe von Befehlen/ dem wählen der Rechenoperation auswählen lässt.

* **Input Abfrage für Rechenoperation:**
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
  Am Anfang des While-True-Lopps wird ein Try-Catch-Finally Block eingefügt, welcher die Eingabe der Rechenoperation zulässt. Der Try Block ist insofern notwendig, da sonst ein Fehler bei einer anderen Eingabe als einem Integer auftreten würde. Wenn nun aber ein anderer Userinput als ein Integer eingegeben wird, wird nun der Fehler ausgegebn ohne, dass das Programm beendet wird. Im folgenden wird ein finnaly Statement genutzt um den Buffer wieder zu löschen, anderer seits, würde bei einem falschen input nur noch die Ausgabe mit dem Text _Input_ im While-True ausgegebn werden.

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
  Der obige Code zeigt nun die Switch-Abfrage mit den verschienen Cases. Jede Zahl ist in diesem fall eine Ausführung bzw. Zuweisung zum jeweiligen Case, welcher die Operation ausführt. Bei der eingabe von 9 (`case 9:`) wird die oben deifnierte Funktion _`quit_code`_ ausgeführt, welche eben den Code beendet.
  Case 1 bis 4 führen die Verschiedenen Operationen aus (Addition, Subtraktion, Multiplikation, Division). Dabie wird zuerst geprüft, ob es schon ein vorheriges Ergebniss gab welches eben in der Variable _ans_ (Answer) angegeben wäre, oder ob der Wert der Varibale = 0 ist. Wenn dise der Fall ist, wird der Wert neu gesetzt, welche der Return-Wert der Funktion `add` in [Operations.java](Project/Operations.java) ist.
Wenn jedoch schon ein wert besteht, sprich `add != 0` wahr ist, wird eine Abfrage getätigt, ob der User mit dem vorherigen Ergebniss weiter rechen will, oder ob er eine neue Berechnung tätigen will, ohne `ans` als Wert.
Wenn der Benutzer ohne `ans` als Wert vortfahren will, wird die Stadart funktion, wie bei einem Wert von NULL/Null von `ans` vorgegangen. 
Wenn `y` als Eingabe getätigt wird, wird eine Extra funktion, welcher den Wert von `ans` als mitzugebenen Parameter bei der Eingabe, beim Aufruf verlangt.
Bei einem Eingabewert von `5` wird lediglich das letzte Ergebniss, als der Werte der Variable `ans` ausgegeben.

### Operations.java 

* **Importieren der Bibliotheken:**
  ```java
    import java.util.Scanner;
  ```
  Wie auch schon in [Calc.java](Project/Calc.java), wird _Scanner_ verwendet um die Benutzereingabe abzufragen.

* **Variablen & Scanner:**
  ```java
    public class Operations {
      // color of text
      public static final String ANSI_RESET = "\u001B[0m"; // Reset color
      public static final String ANSI_RED = "\u001B[31m"; // Red color

      private static float result;

      static Scanner reader = new Scanner(System.in);
  ```
  Nachdem die Klasse erstellt wird, werden auch hier wieder nötig Textfarben für die Ausgabe definiert und auch eine Statische Variable `result` für das speichern der Ergebnisse in einer Variable und nicht in einer pro Funktion.
  Auch ein neues Scanner-Objekt wird erstellt, um auch direkt von der Funktion der Klasse aus, den User-Input abzufragen.

* **Operationen ohne vorherigem Ergebniss:**
  ```java
    public static float add() {
      try {
        System.out.print("Number 1: ");
        float add_int = reader.nextFloat();

        System.out.print("\n\nNumber 2: ");
        float add_int2 = reader.nextFloat();

        result = add_int + add_int2;

        System.out.printf("\n\n%.2f + %.2f = %.2f%n", add_int, add_int2, result);
      } catch (Exception e) {
        System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
      } finally {
        reader.nextLine(); // clear buffer
      }

    return result;
    }

    public static float sub() {
      try {
        System.out.print("Number 1: ");
        float add_int = reader.nextFloat();

        System.out.print("\n\nNumber 2: ");
        float add_int2 = reader.nextFloat();

        result = add_int - add_int2;

        System.out.printf("\n\n%.2f * %.2f = %.2f%n", add_int, add_int2, result);
      } catch (Exception e) {
        System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
      } finally {
        reader.nextLine(); // clear buffer
      }

   xreturn result;
  }

 public static float mult() {
try {
            System.out.print("Number 1: ");
            float add_int = reader.nextFloat();

            System.out.print("\n\nNumber 2: ");
            float add_int2 = reader.nextFloat();

            result = add_int * add_int2;

            System.out.printf("\n\n%.2f * %.2f = %.2f%n", add_int, add_int2, result);

        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }

    public static float div() {
        try {
            System.out.print("Number 1: ");
            float add_int = reader.nextFloat();

            System.out.print("\n\nNumber 2: ");
            float add_int2 = reader.nextFloat();

            result = add_int / add_int2;

            System.out.printf("\n\n%.2f * %.2f = %.2f%n", add_int, add_int2, result);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }
