package src;
public class Aims {
    public static void main(String[] args) {
        Order order1 = new Order();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("aaaaaaaaaaa");
        dvd1.setCost(19.95f);
        dvd1.setDirector("director");
        dvd1.setLength(87);
        order1.addDigitalVideoDisc(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion");
        dvd2.setCategory("Animationss");
        dvd2.setCost(20.32f);
        dvd2.setDirector("Roger Allersss");
        dvd2.setLength(200);
        order1.addDigitalVideoDisc(dvd2);
        
        order1.printOrder();
        

        Order order2 = new Order();

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The man");
        dvd3.setCategory("romeo");
        dvd3.setCost(201f);
        dvd3.setDirector("juliet");
        dvd3.setLength(200);
        order2.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lie");
        dvd4.setCategory("dragon");
        dvd4.setCost(20f);
        dvd4.setDirector("talor swift");
        dvd4.setLength(200);
        order2.addDigitalVideoDisc(dvd4);

        // order2.test();
        order2.printOrder();
        // System.exit();
    }
}   