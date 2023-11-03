package tp;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMT extends Thread{
	private int nbClient;
	private static final int PORT = 1234;
	public static void main (String[]args) {
		new ServeurMT().start();
	}
	@Override
	public void run() {
		try {
			System.out.println("Demarrage de serveur");
			ServerSocket ss = new ServerSocket(PORT);
			while (true) {
				Socket s = ss.accept();
				new ClientProcess(s, ++nbClient).start();
				System.out.println("le client num"+ "est connecté");
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
	}

public class ClientProcess extends Thread{
	private int numClient;
	private Socket s;
	public ClientProcess(Socket s, int numClient) {
		this.s= s; 
		this.numClient=numClient;
	}
	public void run() {
		try {
			new PrintWriter(s.getOutputStream(),true).println("Binevenue, Client num" + numClient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Operation op = new ObjectInputStream(s.getInputStream()).readObject();
	}
}
	
}	
	
	
	