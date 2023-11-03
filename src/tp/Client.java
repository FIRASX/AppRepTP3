package tp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static final int PORT = 1234;
	private int numClient;
	public static void main(String[]args) throws UnknownHostException, IOException {
		System.out.println("je suis un client");
		Socket s = new Socket("localhost", PORT);
		try {
			System.out.println(new BufferedReader(new InputStreamReader(s.getInputStream())).readLine());
			//Operation op new Operation(op1, op2, oper);
			ObjectOutputStream OOS = new ObjectOutputStream(s.getOutputStream());
			//OOS.writeObject(op);
			
		}catch (Exception e) {
            e.printStackTrace();
        }
	}

}
