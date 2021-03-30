package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD,cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title :" + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD,cinderellaDVD.getTitle());
		System.out.println("jungle dvd title : " + jungleDVD.getTitle());
	}
	
	public static void swap(DigitalVideoDisc jungleDVD,DigitalVideoDisc cinderellaDVD) {
	String tmp = jungleDVD.getTitle();
	jungleDVD.setTitle(cinderellaDVD.getTitle());
	cinderellaDVD.setTitle(tmp);
	}
	public static void changeTitle(DigitalVideoDisc dvd,String title) {
		String oldtitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldtitle);
	}
}
