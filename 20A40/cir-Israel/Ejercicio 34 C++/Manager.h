#ifndef MANAGER_H
#define MANAGER_H

#include "Employee.h" // Include the base class header

class Manager : public Employee {
   private:
      double bonus;
      std::string department;
   
   public:   
      Manager(); // Constructors
      Manager(const std::string& name, double salary, 
              const std::tm& birthdate, double bonus, 
              const std::string& department);
    
      ~Manager(); // Destructor

      // Getter methods
      double getBonus() const;
      std::string getDepartment() const;

      // Setter methods
      bool setBonus(double bonus);
      bool setDepartment(const std::string& department);

      // Overridden method
      std::string getDetails() const override;
};

#endif // MANAGER_H