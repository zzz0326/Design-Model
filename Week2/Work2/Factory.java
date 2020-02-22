package d2;

public class Factory {
    //工厂

    protected FruitMeal meal = new FruitMeal();
    protected Fruit fruit = null;

    public void CreateA(){

    }
    public void CreateB(){

    }

    public FruitMeal getFruitMeal() {
        return meal;
    }
}
