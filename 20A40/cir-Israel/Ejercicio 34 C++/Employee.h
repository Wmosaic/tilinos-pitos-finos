#ifndef EMPLOYEE_H
#define EMPLOYEE_H

#include <string>
#include <ctime>

class Employee {
   private:
      std::string name;
      double salary;
      std::tm birthdate;

   public:
      // Constructors
      Employee();
      Employee(const std::string& name, double salary, const std::tm& birthdate);

      ~Employee();

      // Getter methods
      std::string getName() const;
      double getSalary() const;
      std::tm getBirthdate() const;

      // Setter methods
      bool setName(const std::string& name);
      bool setSalary(double salary);
      bool setBirthdate(const std::tm& birthdate);

      // Other methods
      virtual std::string getDetails() const;
};

#endif // EMPLOYEE_H