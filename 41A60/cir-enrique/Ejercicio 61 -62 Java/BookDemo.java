import bookstore.*;
import cstio.*;
class BookDemo{
Pizarra pi = new Pizarra();
Book book [] = new Book [5];

public void inicio(){
pi.out("Se despliega el arreglo de Book con 5 elementos");
pi.setVisible(true);
}
void data(){
book[0] = new Book ("java Beginner's Guide", "Schildt", 2001, 240, "HcGraw Hill");
book[1] = new Book  ("java 2 Programmer's Reference", "Schildt", 2000, 350, "HcGraw Hill");
book[2] = new Book  ("HTML Programer's Reference", "Powell nd Whitworth", 1998, 280, "Pearson");
book[3] = new Book ("Red Storm Rising", "Clancy", 1986, 365, "0'Really");
book[4] = new Book ("On the Road", "Kerouac", 1955, 100, "PHI");
}

void show(int i){
pi.out (book[i].getTitle());
pi.out(book[i].getAuthor());
pi.out(book[i].getPubYear()+" ");
pi.out(book[i].getEditor());
pi.out(book[i].getPrice() + "\n");
}
public static void main (String args[]){
BookDemo bd = new BookDemo();

bd.inicio();
bd.data();
for(int i=0; i < bd.book.length; i++){
bd.show(i);
bd.pi.out(bd.book[i].toString() + "\n");
}
}}