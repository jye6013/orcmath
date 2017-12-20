package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker2 {

	private ArrayList<Places> list = new ArrayList<Places>();
	
	public CatalogMaker2() {
		list.add(new Places("Toronto", "Canada", 1));
		list.add(new Places("Paris", "France", 2));
		list.add(new Places("Tokyo", "Japan", 3));
	}
	
	public static void main(String[] args) {
		CatalogMaker2 x = new CatalogMaker2();
		System.out.println(x.getCsvContent());
		Scanner in = new Scanner(System.in);
		
		System.out.println("Type a location.");
		String location = in.nextLine();
		System.out.println("Now enter the country.");
		String country = in.nextLine();
	}
	
	public String getCsvContent(){
		String data = "location,country\n";
		for(Places c: list) {
			data += c + "\n";
		}
		return data;
	}
	
	public void addNewItem(String location, String country, int timesVisited) {
		list.add(new Places(location, country, timesVisited));
		System.out.println("Item added successfully.");
	}
	
	public void save() {
		
	}
	
	public void getCatalog() {
		return ;
	}

	

}
