package d2;

public class Waiter {
    //组装者
    private Factory factory;
    public void setFactory(Factory factory){
        this.factory = factory;
    }
    public FruitMeal construct(){
        factory.CreateA();
        factory.CreateB();
        return factory.getFruitMeal();
    }
}
