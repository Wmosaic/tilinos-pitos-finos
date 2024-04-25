public class Employee {

    private String name;
    private String adress;
    private double salary;

    public boolean setName(String nam){
        if(!(nam.length() > 0))
            return false;
        this.name = nam;
        return true;
    }

    public boolean setAdress(String add){
        if(!(add.length() > 0))
            return false;
        this.adress = add;
        return true;
    }

    public boolean setSalary(double sal){
        if(!(sal >= 0))
            return false;
        this.salary = sal;
        return true;
    }

    public String getName()   {    return this.name;      }
    public String getAdress() {    return this.adress;    }
    public double getSalary() {    return this.salary;    }

    public String toString(){
        String concat = "Name: " + name + "\tSalary: " +
                        salary + "\tAdress: " + adress;
        return concat;
    }
}
