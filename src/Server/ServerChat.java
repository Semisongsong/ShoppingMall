package Server;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerChat extends Thread {
	private Socket withClient = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private String id = null;
	private MemberDAO dao = null;
	private String[] check = null;
	LoginDTO Login = null;

	ServerChat(Socket withClient) {
		this.withClient = withClient;
		// streamSet();
	}

	@Override
	public void run() {
		streamSet();
		// receive();
		// send();
	}

	public void streamSet() {
		try {
			System.out.println("*******************************");
			FileInputStream fis = new FileInputStream("D:/java_src/Object.txt");
			System.out.println("1");
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println("2");
			Object o = ois.readObject();
			System.out.println("3");
			// int[] obj3 = (int[])ois.readObject();
			check = (String[]) o;
			System.out.println("4");
			for (int i = 0; i < check.length; i++) {
				Login.getList();
				System.out.println(check[i]);
				System.out.println("5");
			}
			System.out.println("finally");
			//ois.close();

//			System.out.println("*******************************");
//
//			if (reMsg != null) {
//				reMsg = withClient.getInputStream();
//				byte[] reBuffer = new byte[1024];
//				reMsg.read(reBuffer);
//				System.out.println(reBuffer + "         ����Ʈ����");
//
//				ByteArrayInputStream bais = new ByteArrayInputStream(reBuffer);
//				System.out.println(bais + "      ArrayInput");
//
//				ObjectInputStream ois = new ObjectInputStream(reMsg);
//				System.out.println(ois + "       ObjectInput");
//
//				Object o = ois.readObject();
//				System.out.println(o + "        ��ü����ȯ");
//				check = (String[]) o;
//				System.out.println(check + "      ���� ��ü");
//				for (int i = 0; i < check.length; i++) {
//					System.out.println(check[i]);
//
//					System.out.println("����");
//				}
//			}
//			reMsg = withClient.getInputStream();
//			byte[] reBuffer = new byte[100];
//			reMsg.read(reBuffer);
//			id = new String(reBuffer);
//			id = id.trim();
//
//			InetAddress c_ip = withClient.getInetAddress();
//			String ip = c_ip.getHostAddress();
//
//			System.out.println(id + "�� �α��� (" + ip + ")");
//
//			String reMsg = "�������� �Ǿ����ϴ�.";
//			sendMsg = withClient.getOutputStream();
//			sendMsg.write(reMsg.getBytes());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
