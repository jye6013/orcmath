package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {

	private ArrayList<Places> list = new ArrayList<Places>();
	
	public CatalogMaker() {
		list.add(new Places("Toronto", "Canada"));
		list.add(new Places("Paris", "France"));
		list.add(new Places("Tokyo", "Japan"));
	}
	
	public String getCsvContent(){
		String data = "location,country\n";
		for(Places c: list) {
			data += c + "\n";
		}
		return data;
	}
	
	public void addNewItem(String location, String country) {
		list.add(new Places(location, country));
		System.out.println("Item added successfully.");
	}

	public static void main(String[] args) {
		CatalogMaker x = new CatalogMaker();
		System.out.println(x.getCsvContent());
		Scanner in = new Scanner(System.in);
		
		System.out.println("Type a location.");
		String location = in.nextLine();
		System.out.println("Now enter the country.");
		String country = in.nextLine();
	}

}
