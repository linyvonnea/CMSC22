class Dog extends Animal {
    public Dog(String name, String breed, String color, String healthStatus, int age, boolean lost) {
        super(name, breed, color, healthStatus, age, lost);
    }

    @Override
    public int calculateAdoptionFee() {
        return 1000;
    }
}

