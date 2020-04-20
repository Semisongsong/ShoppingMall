package Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class ServerChat extends Thread {
	private Socket withClient = null;
	private Socket withClient2 = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private String id = null;
	private String[] check = null;
	private ServerCenter sc = null;
	private ServerChat ss = null;
	String msg = null;
	ArrayList<String[]> list = null;

	public ServerChat(Socket withClient, Socket withClient2, ServerCenter sc) {
		this.withClient = withClient;
		this.withClient2 = withClient2;
		this.sc = sc;
		ss = this;
		// streamSet();
		// receive(msg);
	}

	@Override
	public void run() {
		streamSet();
		send(msg, withClient);
		// send2(list);
		recieve();
	}

	public void send(String msg, Socket withClient) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// while (true) {
					if (msg != null) {
						sendMsg = withClient.getOutputStream();
						System.out.println("����� ����ê�ε� ���� �޼����� Ȯ���غ����̾� : " + msg);
						sendMsg.write(msg.getBytes());
						System.out.println("�������� �޼����� ���¾��");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}

	public void send2(ArrayList<String[]> gList, Socket withClient2) {
		this.withClient2=withClient2;
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (msg != null) {
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						ObjectOutputStream oos = new ObjectOutputStream(baos);
						oos.writeObject(gList);

						byte[] bowl = baos.toByteArray();

						sendMsg = withClient2.getOutputStream();

						sendMsg.write(bowl);
						System.out.println("����Ʈ ������ �Ϸ�");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}).start();

	}

	public void streamSet() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("�޼����� ��ٸ��� ���Դϴ�");
					while (true) {
						reMsg = withClient.getInputStream();
						byte[] reBuffer = new byte[1024];
						reMsg.read(reBuffer);

						ByteArrayInputStream bais = new ByteArrayInputStream(reBuffer);

						ObjectInputStream ois = new ObjectInputStream(bais);

						Object o = ois.readObject();

						if (o != null) {
							check = (String[]) o;
							for (int i = 0; i < check.length; i++) {
								System.out.println(check[i]);
								id = check[0];
							}
							sc.select(check, withClient, withClient2);

//							String txt = "�������� �Ǿ����ϴ�.";
//							sendMsg = withClient.getOutputStream();
//							sendMsg.write(txt.getBytes());
						}

//						InetAddress c_ip = withClient.getInetAddress();
//						String ip = c_ip.getHostAddress();
//
//						System.out.println(id + "�� �α��� (" + ip + ")");
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}

	public void recieve() {
		this.withClient2=withClient;
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("�޼����� ��ٸ��� ���Դϴ�");
					while (true) {
						reMsg = withClient2.getInputStream();
						byte[] reBuffer = new byte[100];
						reMsg.read(reBuffer);
						String msg = new String(reBuffer);
						msg = msg.trim();
						System.out.println("Ŭ���̾�Ʈ���� �޼����� �޾Ҿ��." + msg);
						sc.select(msg, withClient, withClient2);

					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}
}
