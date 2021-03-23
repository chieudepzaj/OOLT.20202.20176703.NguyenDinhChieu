
public class Aims {
	public static void main(String[] args) {
		Order anOrder = new Order(); 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",194,87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Doraemon","children","Nambazilt",90,55);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Spiderman","drama","Den Houser",100,90);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Hulk","action","Joan Lapotar",120,60);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Silent Hill","horor","Koon De",95,95);
		String phone = "012 3456789";
		String[] output = phone.split(" ");
		System.out.println(output[0]);
		System.out.println(output[1]);
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd4);
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
	}
}
