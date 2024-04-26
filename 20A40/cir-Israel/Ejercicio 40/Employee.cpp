#include "Employee.h"

// Constructor
Employee::Employee(std::string name, std::string address, float salary) {
    this->name = name;
    this->address = address;
    this->salary = salary;
}

void Employee::setName(std::string name) {
    this->name = name;
}

void Employee::setAddress(std::string address) {
    this->address = address;
}

void Employee::setSalary(float salary) {
    this->salary = salary;
}

std::string Employee::getName() const { return name;}
std::string Employee::getAddress() const { return address; }
float Employee::getSalary() const { return salary; }

// Método para recibir salario
void Employee::receivePay() {
}

std::string Employee::toString() const {
    return "Employee{name='" + name + "', " +
           "address='" + address + "', " +
           "salary=" + std::to_string(salary) + "}";
}