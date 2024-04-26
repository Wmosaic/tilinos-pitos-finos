#include "Employee.h"

#include <iostream> // For std::cerr

// Default constructor
Employee::Employee() {}

// Overloaded constructor
Employee::Employee(const std::string& name, double salary, 
                   const std::tm& birthdate) : 
          name(""), salary(0.0), birthdate({0}) 
          {  if (!name.empty()) this->name = name;
             if (salary >= 0) this->salary = salary;
             this->birthdate = birthdate;
          }

Employee::~Employee() {}

// Getter methods
std::string Employee::getName() const {   return name;   }
double Employee::getSalary() const {   return salary;   }
std::tm Employee::getBirthdate() const {   return birthdate;   }

// Setter methods
bool Employee::setName(const std::string& name) {
    if (!name.empty()) {
        this->name = name;
        return true;
    } else {
        std::cerr << "Error: Empty name provided.\n";
        return false;
    }
}

bool Employee::setSalary(double salary) {
    if (salary >= 0) {
        this->salary = salary;
        return true;
    } else {
        std::cerr << "Error: Salary cannot be negative.\n";
        return false;
    }
}

bool Employee::setBirthdate(const std::tm& birthdate) {
    this->birthdate = birthdate;
    return true; // No validation needed for birthdate
}

// Other methods
std::string Employee::getDetails() const {
    return "Name: " + name + "\nSalary: " + std::to_string(salary);
}