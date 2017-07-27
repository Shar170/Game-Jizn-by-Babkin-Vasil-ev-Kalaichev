package version01;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Server {
	
	public Server() {
		try { 
			ServerSocket serverSocket = new ServerSocket(3000);
			Socket socket = serverSocket.accept();
			JOptionPane.showMessageDialog(null, "User connect!");
			
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			
			String line = null;
			
				line = dataInputStream.readUTF();
				dataOutputStream.writeUTF(Integer.toString(Main.countRows));
				dataOutputStream.flush();
				
				line = dataInputStream.readUTF();
				dataOutputStream.writeUTF(Integer.toString(Main.countColums));
				dataOutputStream.flush();
				
				line = dataInputStream.readUTF();
				dataOutputStream.writeUTF(Integer.toString(Main.countPoints));
				dataOutputStream.flush();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
