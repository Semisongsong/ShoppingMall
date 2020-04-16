package Client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
	private Socket withServer = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private String[] chk = null;
	String nnn = "";
	Scanner in = new Scanner(System.in);
	//Signup member = new Signup(null);

	ClientChat(Socket withServer) {
		this.withServer = withServer;
		start();
		streamSet(chk);
		// new Login();
		receive();
	}

	private void start() {
		new Login(this);

	}

	public void receive() {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
		try {
			// Login lg = new Login();
			System.out.println("send start~~");

			while (true) {
				
//				reMsg = withServer.getInputStream();
//				byte[] reBuffer = new byte[1024];
//				reMsg.read(reBuffer);
//
//				ByteArrayInputStream bais = new ByteArrayInputStream(reBuffer);
//
//				ObjectInputStream ois = new ObjectInputStream(bais);
//
//				Object o = ois.readObject();
//
//				if (o != null) {
//					String msg = String.valueOf(o);
//					Signup member = new Signup(this);
//					member.complete(msg); 
//				}
				
				
				byte[] reBuffer = new byte[1024];
				reMsg.read(reBuffer);
				String msg = new String(reBuffer);
				msg = msg.trim();
				System.out.println("클라이언트에서 메세지를 받았어요."+msg);
				Signup member = new Signup(this);
				member.complete(msg); 
				

//						System.out.println("zzz");
//						Login lg = new Login();
//						ByteArrayOutputStream baos = new ByteArrayOutputStream();
//						ObjectOutputStream oos = new ObjectOutputStream(baos);
//						oos.writeObject(check);
//						byte[] bowl = baos.toByteArray();
				// op = sc.getOutputStream();
//						op.write(bowl);

//						sendMsg = withServer.getOutputStream();
//						sendMsg.write(bowl);
//						sendMsg.write(pwd.getBytes());
			}
		} catch (Exception e) {
			System.out.println("client send end !!!");
			return;
		}
//			}
//		}).start();
	}

	public void streamSet(String[] check) {
		try {
			if (check != null) {

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(check);

				byte[] bowl = baos.toByteArray();

				sendMsg = withServer.getOutputStream();

				sendMsg.write(bowl);
				System.out.println("보내기 완료");
			}

			// 메세지 받기
//			reMsg = withServer.getInputStream();
//			byte[] reBuffer = new byte[100];
//			reMsg.read(reBuffer);
//			String msg = new String(reBuffer);
//			msg = msg.trim();
//			System.out.println("클라이언트에서 메세지를 받았어요."+msg);
//			Signup member = new Signup(this);
//			member.complete(msg); 
			

//			System.out.println("서버에서 보낸 메시지 확인 :" + msg);
		} catch (Exception e) {
		}
	}

}
