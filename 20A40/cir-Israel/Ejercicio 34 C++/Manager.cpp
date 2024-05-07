#include "Manager.h"
#include <iostream>

// Default constructor
Manager::Manager() : bonus(0.0), department("") {}

// Overloaded constructor
Manager::Manager(const std::string& name, double salary, 
                 const std::tm& birthdate, double bonus, 
                 const std::string& department) : 
         Employee(name, salary, birthdate), bonus(0.0), department("") 
         {  if (setBonus(bonus)) this->bonus = bonus;
            if (setDepartment(department)) this->department = department;
         }

// Destructor
Manager::~Manager() {}

// Getter methods
double Manager::getBonus() const {   return bonus;  }
std::string Manager::getDepartment() const {   return department;  }

// Setter methods
bool Manager::setBonus(double bonus) {
    if (bonus >= 0) {
        this->bonus = bonus;
        return true;
    } else {
        std::cerr << "Error: Bonus cannot be negative.\n";
        return false;
    }
}

bool Manager::setDepartment(const std::string& department) {
    if (!department.empty()) {
        this->department = department;
        return true;
    } else {
        std::cerr << "Error: Empty department provided.\n";
        return false;
    }
}

// Overridden method
std::string Manager::getDetails() const {
    return Employee::getDetails() + "\nBonus: " + std::to_string(bonus) + 
                                    "\nDepartment: " + department;
}