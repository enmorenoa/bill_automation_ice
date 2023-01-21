


import InvoiceAccounts.*;
import pcd.util.TextIO4GUI;

import java.util.ArrayList;

import Ice.Current;
import Ice.StringHolder;

@SuppressWarnings("serial")
public class Products extends InvoiceAccounts._serverProductsDisp {
	ArrayList<Product> products = new ArrayList<Product>();
	
	@Override
	public String requestProduct(Product pc, Current current) {
		// TODO Auto-generated method stub
		Product p = new Product();
		String nameP = pc.name;
		
		switch(nameP) {
			case "CocaCola":
				p.name = nameP;
				p.price = 2.50;
			break; 
			
			case "FantaL":
				p.name = nameP;
				p.price = 2.30;
			break; 
			
			case "FantaO":
				p.name = nameP;
				p.price = 2.30;
			break; 
			
			case "Coffee":
				p.name = nameP;
				p.price = 1.10;
			break; 
		}
		
		TextIO4GUI.putln("The client has requestted a "+p.name);
		products.add(p);
		return products.get(products.size()-1).name;
	}

	@Override
	public void requestMenu(StringHolder menu, Current current) {
		// TODO Auto-generated method stub
		TextIO4GUI.putln("The client has requestted a the menu");
		menu.value = "MENU BAR; 1.CocaCola 2.50€; 2.FantaL 2.30€; 3.FantaO 2.30€; 4.Coffee 1.10€";
	}

	@Override
	public String requestSuggestion(Current current) {
		// TODO Auto-generated method stub
		TextIO4GUI.putln("The client has requestted a suggestion");
		String suggestion = "Our prices are incrementing in order to offer a good service, we recommend our coffee house specialty";
		return suggestion;
	}

	@Override
	public int getNumProducts(Current current) {
		// TODO Auto-generated method stub
		return products.size();
	}

	@Override
	public Product getProduct(int num, Current current) {
		// TODO Auto-generated method stub
		return products.get(num);
	}	
	
	
   
}
