#include "Manager.h"

// Constructor
Manager::Manager(std::string name, std::string address, 
                 float salary, int numberOfReports, int officeID, float bonus)
    : Employee(name, address, salary), 
      numberOfReports(numberOfReports), 
      officeID(officeID), 
      bonus(bonus) {}


void Manager::setNumberOfReports(int reports) {
    numberOfReports = reports;
}

void Manager::setOfficeID(int office) {
    officeID = office;
}

void Manager::setBonus(float bonusAmount) {
    bonus = bonusAmount;
}

int Manager::getNumberOfReports() const { return numberOfReports; }
int Manager::getOfficeID() const { return officeID; }
float Manager::getBonus() const { return bonus; }

// Otros métodos
void Manager::hires() {
}
void Manager::plans() {
}

std::string Manager::toString() const {
    return "Manager{name='" + getName() + "', " +
           "address='" + getAddress() + "', " +
           "salary=" + std::to_string(getSalary()) + ", " +
           "numberOfReports=" + std::to_string(numberOfReports) + ", " +
           "officeID=" + std::to_string(officeID) + ", " +
           "bonus=" + std::to_string(bonus) + "}";
}