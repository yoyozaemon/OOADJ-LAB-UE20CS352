import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner pes2ug20cs815 = new Scanner(System.in);

        int n = pes2ug20cs815.nextInt();

        for (int i = 0; i < n; i++) {
            String animalType = pes2ug20cs815.next();
            String attribute = pes2ug20cs815.next();
            String name = pes2ug20cs815.next();

            Animal animal;
            if (animalType.equals("DOG")) {
                animal = new Dog(attribute, name);
            } else {
                animal = new Cat(attribute, name);
            }

            System.out.println(animal.speak());
        }

        pes2ug20cs815.close();
    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String speak();

    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String breed, String name) {
        super(name);
        this.breed = breed;
    }

    public String speak() {
        return "The " + breed + " " + getName() + " is barking.";
    }
}

class Cat extends Animal {
    private String color;

    public Cat(String color, String name) {
        super(name);
        this.color = color;
    }

    public String speak() {
        return "The " + color + " cat " + getName() + " is meowing.";
    }
}
