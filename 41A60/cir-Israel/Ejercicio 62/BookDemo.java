import bookstore.*;
import cstio.*;

public class BookDemo {
    Pizarra pi = new Pizarra();
	Book book[] = new Book[5];
	
	public void inicio(){
       	pi.out("Se despliga el arreglo de Book con 5 elementos");
		pi.setVisible(true);
       }

 	void data(){
		book[0] = new Book("java Beginner´s Guide",
							"Schildt",2001,
							240,"McGraw Hill");
		book[1] = new Book("java 2 programer´s Reference",
							"Schildt",2000,
							350,"McGrawHill" );
		book[2] = new Book("HTML Programer's Reference",
							"Powell and whitworth",
							1998,280,"Pearson");
		book[3] = new Book("Read storm Rising",
							"Clancy",1986,
							365,"O´ Really");
		book[4] = new Book("On the Road","Kerouac",1955,200,"PHI");
	}
	
	void Show(int i){
		pi.out (book[i].getTitle());
		pi.out (book[i].getAuthor());
		pi.out (book[i].getEditor());
    	pi.out (book[i].getPrice()+"\n");
	} 
	
	public static void main(String args[] ){
	BookDemo bd = new BookDemo();
	
	bd.inicio();
	bd.data();
	for(int i = 0; i < bd.book.length; i++)
	bd.pi.out(bd.book[i].toString()+"\n");
    }
}
