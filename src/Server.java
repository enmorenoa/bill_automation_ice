import pcd.util.TextIO4GUI;

public class Server {
	public static void main(String[] args) {
		int status = 0;
		Ice.Communicator ic = null;
		TextIO4GUI TextIO = new TextIO4GUI("Bar Server");
		try {
			ic = Ice.Util.initialize(args);
			Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints(
					"Adapter", "default -p 10000");
			
			Ice.Object object = new Products();
			adapter.add(object, ic.stringToIdentity("products"));
			System.out.println("Products levantando...");
			
			Ice.Object object2 = new Bill();
			adapter.add(object2, ic.stringToIdentity("bill"));
			System.out.println("Bill levantando...");
			
			adapter.activate();
			
			
			ic.waitForShutdown();
			TextIO = null;
		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (ic != null) {
			// Clean up
			//
			try {
				ic.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}

		System.exit(status);
	}
}
