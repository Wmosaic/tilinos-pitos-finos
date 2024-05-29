import BookStore.*;
import cstio.*;

public class BookDemo {
        Pizarra pi = new Pizarra();
	    Book book[] = new Book[5];
	
	public void Inicio(){
       	 	System.out.println("Se despliga el arreglo de Book con 5 elementos");
		pi.setVisible(true);
       }

 	void Data(){
		book[0] = new Book("Java Begginer´s guide","Schildt",2001,240,"McGraw Hill");
		book[1] = new Book("Java 2 programer´s reference","Schildt",2000,350,"McGrawHill" );
		book[2] = new Book("HTML Programer's Reference","Powell and whitworth",1998,280,"Pearson");
		book[3] = new Book("Read storm Rising","Clancy",1986,365,"O´ Really");
		book[4] = new Book("On the Road","Kerouac",1955,200,"PHI");
	}
	
	void Show(int i){
		String hola = String.valueOf(book[i].getpubYear());
		pi.out(book[i].getTitle());
		pi.out(book[i].getAuthor());
    	pi.out(hola);
		pi.out(book[i].getEditor());
    	pi.out(book[i].getPrice()+"");
	} 
	
	public static void main(String args[]){
	BookDemo bd = new BookDemo();
	
	bd.Inicio();
	bd.Data();
	int lim = bd.book.length;
	for(int i = 0; i < lim; i++)
		bd.pi.out(bd.book[i].toString()+'\n');
	
	for(int ii = 0; ii < lim; ii++)
		bd.Show(ii);
	
    }
}
