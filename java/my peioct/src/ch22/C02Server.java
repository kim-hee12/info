package ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(7000); // 192.168.16.25
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		Socket client = server.accept();
		
		System.out.println("CLIENT IP : " + client.getInetAddress());
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;
		
		while(true) {
			// 서버에서 클라이언트로 송신
			System.out.println("[SERVER(q:종료)] : ");
			send = sc.nextLine();
			if(send.equals("q")) {
				break;
			}
			dout.writeUTF(send);
			dout.flush();
			// 클라이언트가 서버에 수신
			recv =  din.readUTF();
			if(recv.equals("q"))
				break;
			System.out.println("[CLIENT] : "+recv);
			
		}		
		dout.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		server.close();
		
		System.out.println("서버 종료합니다");

	}

}
