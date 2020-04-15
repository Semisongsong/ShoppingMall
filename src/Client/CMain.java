package Client;

import java.net.Socket;

import Manager.Setting;


public class CMain {

	public static void main(String[] args) throws Exception {
		Socket withServer = null;
		withServer = new Socket("1.247.118.32",12345);
		System.out.println("아이피랑 포트넘버 생성");
		new ClientChat(withServer);
		//new Login();
		//new Setting();
	}

}
