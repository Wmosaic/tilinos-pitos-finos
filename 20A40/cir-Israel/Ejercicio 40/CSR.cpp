#pragma once
#include "Manager.h"

class CSR : public Employee {
private:
    std::string headSeType;
    Manager myMgr;
    std::string loginID;

public:
    // Constructor
    CSR(std::string name, std::string address, float salary, 
        std::string headSeType, Manager myMgr, std::string loginID);

    void setHeadSeType(std::string headSeType);
    void setMyMgr(Manager myMgr);
    void setLoginID(std::string loginID);

    std::string getHeadSeType() const;
    Manager getMyMgr() const;
    std::string getLoginID() const;

    // Otros métodos
    void clocksIn();
    void clockOut();

    std::string toString() const;
};