# include <iostream>
# include <tuple>

using namespace std;

class Referencia
{
    public:
    int x = 0;
    
    Referencia &incremento()
    {
        x++;
        return *this;
    }

};

void meta()
{
    cout<<"Hacer lo mismo que el 24 pero ahora en C++"<<endl;
}

tuple<Referencia,Referencia> calculos()
{
    
    Referencia r =  Referencia();
    Referencia alias;

    alias = r.incremento().incremento().incremento();
    alias.incremento().incremento();

    return make_tuple(r,alias);
}

void salida(Referencia rR, Referencia rA)
{
    cout <<"r= " << rR.x;
    cout<<endl<<"alias= " <<rA.x;
}

int main(int argc, char const *argv[])
{
    meta();
    tuple<Referencia,Referencia> myR = calculos();
    salida(get<0>(myR),get<1>(myR));

    return 0;
}
