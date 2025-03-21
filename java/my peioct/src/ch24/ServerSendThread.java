package ch24;

import java.io.DataOutputStream;
import java.util.Scanner;

public class ServerSendThread implements Runnable{

	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);
	
	ServerSendThread(DataOutputStream dout){
		this.dout = dout;
	}
	
	@Override
	public void run() {
		String send;
		
		try {
		while(true) {
			System.out.print("[SERVER(q:종료)] : ");
			send = sc.nextLine();
			if(send.equals("q")) {
				break;
			}
			
			dout.writeUTF(send);
			dout.flush();
		}
	}
	catch(Exception e) {
		System.out.println("[EXCEPTION] 예외발생 ServerSendThread 종료 ");
	}
	finally {
		try {dout.close();}catch(Exception e2) {}
		}
	}

}
