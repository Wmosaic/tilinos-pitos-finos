class Father:
    def drive(self): print("Father drives his son to school")
    def cook(self): print("Father cooks barbecue")

class Mother:
    def cook(self): print("Mother loves to cook for her son")
    def drive(self): print("Mother drives her son to school too")

class Son(Father,Mother): 
    def love(self):
        print("I love my Parents because:")
        Mother.drive(self)
        print ("and")
        Father.drive(self)

c=Son()
Father.drive(c)
Father.cook(c)
Mother.drive(c)
Mother.cook(c)
c.love()