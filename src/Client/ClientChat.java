package Client;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
	private Socket withServer = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private String[] chk = null;
	Scanner in = new Scanner(System.in);

	ClientChat(Socket withServer) {
		this.withServer = withServer;
		start();
		streamSet(chk);
		// new Login();
		// send();
	}

	private void start() {
		new Login(this);

	}

	public void send() {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
		try {
			// Login lg = new Login();
			System.out.println("send start~~");

			while (true) {
//						//FileOutputStream fos = new FileOutputStream(USERINFO_SER);
//						BufferedOutputStream bos = new BufferedOutputStream();
//						ObjectOutputStream out = new ObjectOutputStream(bos);
//						Login u1 = new Login(check);
//						
//						ArrayList list = new ArrayList<>();
//						list.add(u1);
//						out.writeObject(u1);
//						out.writeObject(list);
//						out.close();
//						System.out.println("직렬화 완료");
				// Login l = new Login();

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
			reMsg = withServer.getInputStream();
			byte[] reBuffer = new byte[100];
			reMsg.read(reBuffer);
			String msg = new String(reBuffer);
			msg = msg.trim();
			System.out.println(msg);

			System.out.println("서버에서 보낸 메시지 확인 :" + msg);
		} catch (Exception e) {
		}
	}

}
