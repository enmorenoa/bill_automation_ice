module InvoiceAccounts{

	struct Product{
		string name;
		double price;
	};

	interface serverProducts {
		string requestProduct(Product pc);
		void requestMenu(out string menu);
		string requestSuggestion();	
		int getNumProducts();
		Product getProduct(int num);
	};
	
	interface serverBill {
		void addProduct(Product p);
		bool deleteProduct(string name);
		double makeBill(out string billProducts);
	};
	
};

