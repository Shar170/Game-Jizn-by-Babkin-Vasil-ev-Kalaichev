package version01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	
	private static String IP;
	
	public Client() {
		IP = JOptionPane.showInputDialog("Please, enter the IP!");
		
		try {
			
			Socket socket = new Socket(IP, 3000);
			
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			
			String line = "Ready";
			
			dataOutputStream.writeUTF(line);
			dataOutputStream.flush();
			Main.countRows = Integer.parseInt(dataInputStream.readUTF());
			
			dataOutputStream.writeUTF(line);
			dataOutputStream.flush();
			Main.countColums = Integer.parseInt(dataInputStream.readUTF());
			
			dataOutputStream.writeUTF(line);
			dataOutputStream.flush();
			Main.countPoints = Integer.parseInt(dataInputStream.readUTF());
			
		} catch (Exception e) {
			
		}
	}

}
