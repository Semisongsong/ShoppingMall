package Client;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import Server.LoginDTO;

public class ClientChat {
	private Socket withServer = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private String[] lgs = null;
	private static final LoginDTO login = null;
	private static final String USERINFO_SER = "user.ser";
	Scanner in = new Scanner(System.in);

	ClientChat(Socket withServer) {
		this.withServer = withServer;
		streamSet(lgs);
		new Login();
		// send();
	}

	public void send() {
		new Thread(new Runnable() {
			@Override
			public void run() {
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
//						System.out.println("����ȭ �Ϸ�");
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
			}
		}).start();
	}

	public void streamSet(String[] check) {
		try {
			FileOutputStream fos = new FileOutputStream("D:/java_src/Object.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(check);
			System.out.println("������");

//			for (int i = 0; i < check.length; i++) {
//				System.out.println(check[i]);
//			}
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			System.out.println(check);
//			ObjectOutputStream oos = new ObjectOutputStream(baos);
//			// oos.flush();
//			oos.writeObject(check);
//			System.out.println("������Ʈ������");
//
//			byte[] bowl = baos.toByteArray();
//			System.out.println("����Ʈ����...");
//			sendMsg = withServer.getOutputStream();
//			System.out.println("�ƿ�ǲ ��Ʈ������");
//
//			sendMsg.write(bowl);
//			System.out.println("�ٺ�����");

			// �޼��� ������
//			System.out.println("���� �޼����� �Է��ϼ���");
//			String text = in.nextLine();
//
//			sendMsg = withServer.getOutputStream();
//			sendMsg.write(text.getBytes());
//			System.out.println("�������ѰŴ�??");
//
//			// �޼��� �ޱ�
//			reMsg = withServer.getInputStream();
//			byte[] reBuffer = new byte[100];
//			reMsg.read(reBuffer);
//			String msg = new String(reBuffer);
//			msg = msg.trim();
//			System.out.println(msg);
//
//			System.out.println("�������� ���� �޽��� Ȯ�� :" + msg);
			// myG = new FrameEX2(this);
			// myG.setMe(id);

		} catch (Exception e) {

		}
	}

}
