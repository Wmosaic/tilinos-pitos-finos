#include <iostream>

using namespace std;
class Mammal{
    public:
        Mammal() { cout << "Mammals can give direct birth." << endl; }
        virtual void eat() { cout <<"como omnivoro" << endl; }
};

class WingedAnimal{
    public:
        WingedAnimal() { cout << "Winged animal can flap." << endl; }
        virtual void eat() { cout <<"como herbivoro" << endl; }
};

class Bat: public Mammal, public WingedAnimal{
    public:
        void eat(){
            cout <<"los murcielagos chupamos la sangre" << endl;
            cout <<"somos vamipros" << endl;
        }
};

int main() {
    Bat b1;

    b1.Mammal::eat();
    b1.WingedAnimal::eat();
    b1.eat();
    return 0;
    
}