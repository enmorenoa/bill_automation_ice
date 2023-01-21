
import java.util.ArrayList;

import Ice.Current;
import Ice.StringHolder;
import InvoiceAccounts.Product;
import pcd.util.TextIO4GUI;

@SuppressWarnings("serial")
public class Bill extends InvoiceAccounts._serverBillDisp {

	ArrayList<Product> bill = new ArrayList<Product>();
	
	@Override
	public void addProduct(Product p, Current current) {
		TextIO4GUI.putln("Adding "+p.name+" to the bill");
		bill.add(p);
	}

	@Override
	public boolean deleteProduct(String name, Current current) {
		boolean del = false;
		TextIO4GUI.putln("Looking product...");
		int i = 0;
		while(i<bill.size()) {
			if(name.equalsIgnoreCase(bill.get(i).name)) {
				TextIO4GUI.putln(bill.get(i).name+" product deleted.");
				bill.remove(i);
				del = true;
				break;
			}
			i++;
		}
		return del;
	}
	
	
	@Override
	public double makeBill(StringHolder billProducts, Current current) {
		String fin = "";
		double b = 0.0;
		TextIO4GUI.putln("Generating the bill of products...");
		for(Product prod : this.bill) {
			b+=prod.price;
			fin+=prod.name+": "+prod.price+"\n";
		}
		billProducts.value = fin;
		TextIO4GUI.putln("The results of the operations has been "+b);
		return b;
	}	

	
   
}
