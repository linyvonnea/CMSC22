public abstract class Animal {
    private String name;
    private String breed;
    private String color;
    private String healthStatus;
    private int age;
    private boolean lost;

    public Animal(String name, String breed, String color, String healthStatus, int age, boolean lost){
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.healthStatus = healthStatus;
        this.age = age;
        this.lost = lost;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getHealthStatus(){
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus){
        this.healthStatus = healthStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", healthStatus='" + healthStatus + '\'' +
                ", age=" + age +
                ", lost=" + lost +
                '}';
    }
}
