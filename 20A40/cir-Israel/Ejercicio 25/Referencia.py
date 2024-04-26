class Referencia:   # traducido de Eckel por CST
  def __init__(self,x): self.x = x

  def incremento(self) :
    self.x += 1
    return self
      
  def main(self) :
    r = Referencia(0)
    r.incremento().incremento().incremento()
    print("\nx= ", r.x, "\n")

m = Referencia(0)
m.main()