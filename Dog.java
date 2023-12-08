class Dog extends Animal {

    public Dog(String name, String breed, String color, String healthStatus, int age) { // SHOULD WE INCLUDE LOST AND FOUND PA
        super(name, breed, color, healthStatus, age);
        this.color = color;
    }

    @Override
    public int calculateAdoptionFee() {
        return 1000;
    }
}