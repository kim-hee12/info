package ch24;

import java.io.DataOutputStream;
import java.util.Scanner;

public class ClientSendThread implements Runnable{

	//OutputStream
	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);
	
	ClientSendThread(DataOutputStream dout){
		this.dout = dout;
	}
	
	@Override
	public void run() {
		String send;
		
		try {
			while(true) {
				//SERVER->CLIENT (송신)
				System.out.print("[CLIENT(q:종료)] :");
				send=sc.nextLine();
				if(send.equals("q")) {
					break;
				}
				dout.writeUTF(send);
				dout.flush();	
			}
		}catch(Exception e) {
			System.out.println("[EXCEPTION] 예외발생 ClientSendThread 종료");	
		}finally {
			try {dout.close();}catch(Exception e2) {}
		}
		
	}

}