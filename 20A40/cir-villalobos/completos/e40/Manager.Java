public class Manager extends Employee {

    private int numberOfReports;
    private int officeID;
    private double bonus;

    public boolean setNumberOfReports(int rep){
        if(!(rep >= 0))
            return false;
        this.numberOfReports = rep;
        return true;
    }

    public boolean setOfficeID(int id){
        if(!(id >= 0))
            return false;
        this.officeID = id;
        return true;
    }

    public boolean setBonus(int bon){
        if(!(bon >= 0))
            return false;
        this.bonus = bon;
        return true;
    }
    public int getNumberOfReports() {    return this.numberOfReports;    }
    public int getOfficeID()        {    return this.officeID;    }
    public double getBonus()        {    return this.bonus;    }

    @Override
    public String toString(){
        concat = super.toString() + "\t# of reports: " + numberOfReports +
                 "\tOffice ID: " + officeID + "\tBonus: " + bonus;
        return concat;
    }
}
