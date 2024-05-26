package BookStore;

public class Book{
	private String title;
	private String author;
	private int pubYear;
	private double Price;
	private String editor;

public Book(String t, String a, int py, double p,String e){
	    if (t != null) this.title = t;
	    if (a != null) this.author = a;
	    if(py > 0) this.pubYear = py;
	    if(p>0) this.Price = p;
            if(e != null) this.editor = e;		 	
	}

public String getTitle(){return title;}
public String getAuthor(){return author;}
public int getpubYear(){return pubYear;}
public double getPrice(){return Price;}
public String getEditor(){return editor;}

public String toString(){
	String cadena = author +", "+title +", "+pubYear;
	cadena += ", $"+Price+", "+editor;
	return cadena;  
	}
}
