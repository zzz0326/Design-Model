package d2;

public class AFactory extends Factory{
    //其中一个分配方式

    @Override
    public void CreateA(){
        fruit = new Apple();
        meal.setFruitA(fruit.eat());
        fruit = null;
    }

    @Override
    public void CreateB(){
        fruit = new Melon();
        meal.setFruitB(fruit.eat());
    }

}
