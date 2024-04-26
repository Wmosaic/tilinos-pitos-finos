#pragma once
#include "Employee.h"

class Manager : public Employee {
private:
    int numberOfReports;
    int officeID;
    float bonus;

public:
    // Constructor
    Manager(std::string name, std::string address, 
            float salary, int numberOfReports, int officeID, float bonus);

    void setNumberOfReports(int reports);
    void setOfficeID(int office);
    void setBonus(float bonusAmount);

    int getNumberOfReports() const;
    int getOfficeID() const;
    float getBonus() const;

    // Otros métodos
    void hires();
    void plans();

    std::string toString() const;
};
