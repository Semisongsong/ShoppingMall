package Client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientChat {
	private Socket withServer = null;
	private Socket withServer2 = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private String[] chk = null;
	String nnn = "";
	Scanner in = new Scanner(System.in);
	// Signup member = new Signup(null);
	String msg = null;
	ArrayList<String[]> list;
	private static MsCenter mc = MsCenter.getInstance();

	public ClientChat(Socket withServer, Socket withServer2) {
		this.withServer = withServer;
		this.withServer2 = withServer2;
		start();
		streamSet(chk);
		receive2(withServer);
		receive();
		send(msg, withServer);
	}

	private void start() {
		//new Login(withServer, withServer2);
		new MsCenter(this);
	}

	public void receive() {
		// this.withServer=withServer;
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("receive start~~");

					while (true) {
						reMsg = withServer.getInputStream();
						byte[] reBuffer = new byte[1024];
						reMsg.read(reBuffer);
						msg = new String(reBuffer);

						if (msg != null) {
							msg = msg.trim();
							System.out.println("클라이언트에서 메세지를 받았어요." + msg);

							gotoCenter(msg);
						}
					}
				} catch (Exception e) {
					System.out.println("client send end !!!");
					return;
				}
			}
		}).start();
	}

	public void receive2(Socket withServer) {// 객체 받는 곳임.
		// this.withServer=withServer;
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("receive start~~");

					while (true) {
						// if (reMsg != null) {
						reMsg = withServer.getInputStream();
						byte[] reBuffer = new byte[1024];
						reMsg.read(reBuffer);
						System.out.println("클라이언트에서 객체를 받을 곳입니닷!!!");

						ByteArrayInputStream bais = new ByteArrayInputStream(reBuffer);

						ObjectInputStream ois = new ObjectInputStream(bais);

						Object o = ois.readObject();

						if (o != null) {
							// (Object[]) list.toArray()=Object[] o;
							// Object[] o = (Object[]) list.toArray();
							ArrayList<String[]> list = (ArrayList<String[]>) o;
							for (int i = 0; i < list.size(); i++) {
								System.out.println(list.get(i));
							}
							gotoCenter2(list);
						}
						// }
					}

				} catch (Exception e) {
					System.out.println("client send end !!!");
					return;
				}
			}
		}).start();
	}

	private void gotoCenter(String msg) {
		MsCenter mc = new MsCenter(this);
		// mc.setMsg(msg);
		mc.checkMsg(msg);
	}

	private void gotoCenter2(ArrayList<String[]> list) {
		System.out.println("메세지센터가기전임");
		MsCenter mc = new MsCenter(this);
		mc.back(withServer2, list);
	}

	public void streamSet(String[] check) {
		new Thread(new Runnable() {
			@Override
			public void run() {
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
		}).start();
	}

	public void send(String msg, Socket withServer2) {
		this.withServer = withServer;
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (msg != null) {
						System.out.println("여기는 클라이언트챗이다오바 : " + msg);
						sendMsg = withServer2.getOutputStream();
						sendMsg.write(msg.getBytes());
						System.out.println("리스트 달라는 메세지 보내기 완료");
					}
				} catch (Exception e) {
				}
			}
		}).start();
	}

}
