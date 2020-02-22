package d2;

public class Main {

    public static void main(String[] args) {
        //实体类通过工厂进行建造
        //工厂里可以生产很多类型的商品(虚拟工厂)
        //建造完成后通过建造者进行组合

        Waiter waiter = new Waiter();
        Factory factory = new AFactory();
        waiter.setFactory(factory);
        System.out.println(waiter.construct().getFruitA()+waiter.construct().getFruitB());
    }

}
