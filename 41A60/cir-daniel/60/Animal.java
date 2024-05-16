import java.util.*;

public class Animal{
    public void eat(){ System.out.println("I eat like a generic animal");}

    public static void main(String[] args){
        List<Animal> animals = new LinkedList<Animal>();

        animals.add(new Animal());
        animals.add(new Wolf());
        animals.add(new Fish());
        animals.add(new OtherAnimal());
        for (Animal currentAnimal : animals){
            currentAnimal.eat();
        }
    }
}

class Wolf extends Animal{
    public void eat(){ System.out.println("I eat like a wolf!");}
}

class Fish extends Animal{
    public void eat(){ System.out.println("I eat like a fish!");}
}

class OtherAnimal extends Animal{}
