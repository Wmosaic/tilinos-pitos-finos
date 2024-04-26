public class CSR extends Employee {

    private String headSetType;
    private Manager myMgr;
    private String loginID;

    public boolean setHeadSetType(String typ){
        if(!(typ.length() > 0))
            return false;
        this.headSetType = typ;
        return true;
    }

    public boolean setLoginID(String id){
        if(!(id.length() > 0))
            return false;
        this.loginID = id;
        return true;
    }

    public boolean setManager(Manager mgr){
        if(!(mgr != null))
            return false;
        this.myMgr = mgr;
    }


    public String getHeadSetType() {    return this.headSetType;  }
    public String getLoginID()     {    return this.loginID;      }
    public Manager getMyMgr()      {    return this.myMgr;        }

    @Override
    public String toString(){
        String concat = super.toString() + "\tHeadset type: " + headSetType +
                 "\tLogin ID: " + loginID + "\tManager: " + myMgr.getName();
        return concat;
    }
}
