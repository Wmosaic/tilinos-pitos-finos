public class Main {
    public static void main(String[] args) {
        List myList = new List();
        myList.add("Enrique");
        myList.add(71);
        myList.add("Villalobos");
        myList.add(77);
        myList.add("Emilio");
        myList.add(75);


        myList.add(myList.remove(2));
        myList.add(myList.remove(2));

        myList.addHead(58);
        myList.addHead("Daniela");
        myList.addHead(82);
        myList.addHead("Laura");

        myList.insert(65, 0);
        myList.insert("Fernando", 0);

        System.out.println(myList);

        System.out.println(myList.size());
    }
}