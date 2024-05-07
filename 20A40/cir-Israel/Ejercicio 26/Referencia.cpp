#include<iostream>

using namespace std; // traducido por CST

class referencia
{  private: int x;
   public:
      referencia() {}
      referencia &incremento()
      {  x++;
         return *this;
      }
      void print() { cout << "x = " << x << endl; }
};

           // Chained function calls. All calls
int main() //  modify the same object as same object
{  referencia r = referencia();  // is returned

   r.incremento().incremento().incremento();
   r.print();
   return 0;
}