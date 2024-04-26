#pragma once
#include <iostream>
#include <string>

class Employee {
private:
    std::string name;
    std::string address;
    float salary;

public:
    // Constructor
    Employee(std::string name, std::string address, float salary);

    void setName(std::string name);
    void setAddress(std::string address);
    void setSalary(float salary);

    std::string getName() const;
    std::string getAddress() const;
    float getSalary() const;

    // Método para recibir salario
    void receivePay();

    std::string toString() const;
};