from multipledispatch import dispatch

class Referencia:

    def __init__(self,x):
        self.x = x

    def incremento(self):
        self.x += 1
        return self


def main(ref) :
    ref = Referencia(0)
    alias = ref.incremento().incremento().incremento()
    alias.incremento().incremento()
    print("\nref = ", ref.x)
    print("\nalias = ", alias.x)

m = Referencia(0)
main(m)
