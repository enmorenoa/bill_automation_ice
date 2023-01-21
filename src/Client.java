import Ice.StringHolder;
import InvoiceAccounts.Product;
import pcd.util.TextIO4GUI;

public class Client {
	public static void main(String[] args) {
		int status = 0;
		Ice.Communicator ic = null;
		String userInput;
		new TextIO4GUI("Client");
		try {
			ic = Ice.Util.initialize(args);
			
			System.out.println("Iniciando sistema...");
			Ice.ObjectPrx base = ic
					.stringToProxy("products:default -p 10000");
			InvoiceAccounts.serverProductsPrx prods = InvoiceAccounts.serverProductsPrxHelper.checkedCast(base);
			
			TextIO4GUI.putln("Welcome to our bar, do you wish something?");
			TextIO4GUI.putln("Waiting for your message... These are the options:");
			TextIO4GUI.putln("<RequestLetter> Request the product menu");
			TextIO4GUI.putln("<RequestBill> Request the bill");
			TextIO4GUI.putln("<Suggestion> Request a suggestion to the bar");
			
			userInput = TextIO4GUI.getlnString();
			String p = "";
			
			StringHolder s = new StringHolder();
			while(!userInput.equalsIgnoreCase("RequestBill")) {
				switch(userInput) {
					case "RequestLetter":
						prods.requestMenu(s);
						TextIO4GUI.putln(s.value);
						TextIO4GUI.putln("Waiting for your order...These are the available products:");
						TextIO4GUI.putln("<CocaCola> Order a Coca Cola");
						TextIO4GUI.putln("<FantaL> Order a Lemon Fanta");
						TextIO4GUI.putln("<FantaO> Order an Orange Fanta");
						TextIO4GUI.putln("<Coffee> Order a Coffee");
						p = "RequestLetter";
						
					break;
					case "CocaCola":
						p = prods.requestProduct(new InvoiceAccounts.Product(userInput,0.0));
					break;
					case "FantaL":
						p = prods.requestProduct(new InvoiceAccounts.Product(userInput,0.0));
					break;
					case "FantaO":
						p = prods.requestProduct(new InvoiceAccounts.Product(userInput,0.0));
					break;
					case "Coffee":
						p = prods.requestProduct(new InvoiceAccounts.Product(userInput,0.0));
					break;
					case "Suggestion":
						p = prods.requestSuggestion();
						TextIO4GUI.putln(p);
						p ="?";
						break;
					default:
						p="?";
						TextIO4GUI.putln("We don't understand what you have asked for, can you repeat please?");
				}
				if(!p.equalsIgnoreCase("RequestLetter") && !p.equals("?")) {
					TextIO4GUI.putln("Here is your "+p+" , do you wish something more?");
				}
				userInput = "";
				
				userInput = TextIO4GUI.getlnString();
				
			}
			Ice.ObjectPrx base2 = ic.stringToProxy("bill:default -p 10000");
			InvoiceAccounts.serverBillPrx bill = InvoiceAccounts.serverBillPrxHelper.checkedCast(base2);
			int num = prods.getNumProducts();
			
			for(int i=0; i<num; i++) {
				bill.addProduct(prods.getProduct(i));
			}
			
			double price = bill.makeBill(s);
			TextIO4GUI.putln("");
			TextIO4GUI.putln("");
			TextIO4GUI.putln("");
			TextIO4GUI.putln("Here is your bill");
			TextIO4GUI.putln(s.value);
			TextIO4GUI.putln("Total price: "+price);
			TextIO4GUI.putln("");
			TextIO4GUI.putln("");
			TextIO4GUI.putln("");
			
			TextIO4GUI.putln("If you want to leave, you have to type <Thanks>");
			TextIO4GUI.putln("If you see a product that not correspond to the bill type the product to delete. "
					+ "Example: type <CocaCola> to delete the product");
			userInput = TextIO4GUI.getlnString();
			boolean del = false;
			while(!userInput.equalsIgnoreCase("Thanks")) {
				 del = bill.deleteProduct(userInput);
				 if(del) {
					 TextIO4GUI.putln("Product "+userInput+" deleted!");
				 }else {
					 TextIO4GUI.putln("This product is not present in the bill");
				 }
				
				price = bill.makeBill(s);
				TextIO4GUI.putln("");
				TextIO4GUI.putln("");
				TextIO4GUI.putln("");
				TextIO4GUI.putln("Here is your bill");
				TextIO4GUI.putln(s.value);
				TextIO4GUI.putln("Total price: "+price);
				TextIO4GUI.putln("");
				TextIO4GUI.putln("");
				TextIO4GUI.putln("");
				TextIO4GUI.putln("If you want to leave, you have to type <Thanks>");
				TextIO4GUI.putln("If you see a product that not correspond to the bill type the product to delete.");
				TextIO4GUI.putln("Example: type <CocaCola> to delete the product");
				 
				
				userInput = TextIO4GUI.getlnString();
			}	
			
		} catch (Ice.LocalException e) {
			System.out.println("Error al inicializar. ¿Has levantado antes el servidor?");
			status = 1;
		} catch (Exception e) {
			System.out.println("Error al inicializar. ¿Has levantado antes el servidor?");
			status = 1;
		}
		if (ic != null) {
			// Clean up
			//
			try {
				ic.destroy();
			} catch (Exception e) {
				System.out.println("Error al inicializar. ¿Has levantado antes el servidor?");
				status = 1;
			}
		}
		System.exit(status);
	}
}
