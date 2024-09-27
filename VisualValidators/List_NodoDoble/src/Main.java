public class Main {
    public static void main(String[] args) {
        List myList = new List();
        myList.push("Enrique");
        myList.push("Pedro");
        myList.push("Villalobos");
        myList.push("Carlos");
        myList.push("Emilio");
        myList.push("Laura");
        myList.push("Daniela");
        myList.push("Michelle");

        myList.fondo();

        List newList = new List();
        newList.push(myList);

        System.out.println(myList.toString());
        System.out.println(newList.toString());
        System.out.println(myList.size());
    }
}