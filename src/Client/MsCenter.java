package Client;

import java.net.Socket;
import java.util.ArrayList;

import Manager.Setting;

public class MsCenter {
	private String msg = null;
	private Login login = null;
	private Signup join = null;
	// private Signup join = Signup.getInstance();
	private ClientChat ch = null;
	private Socket withClient = null;
	private Socket withClient2 = null;
	Setting sett = null;

	public MsCenter(Socket withClient, Socket withClient2) {
		this.withClient = withClient;
		this.withClient2 = withClient2;
		// checkMsg(msg);
//		this.join=join();

	}

	public void checkMsg(String msg) {
		if (msg.contains("member")) {
			join = new Signup(withClient);
			join.membercheck(msg);
		} else if (msg.contains("login")) {
			login = new Login(withClient);
			login.loginresult(msg);
		} else if (msg.contains("check")) {
			join = new Signup(withClient);
			join.idchk(msg);
			// join.jbchk(msg);
		}

	}

	public String allMsg(String[] in) {
		ch = new ClientChat(withClient, withClient);
		ch.streamSet(in);
		System.out.println("리턴값 확인중" + msg);
		return msg;

	}

	public ArrayList<String[]> list(String msg,Socket withClient2) {
		//this.withClient2=withClient;
		// this.ch = ch;
		// Setting sett = new Setting(withClient,withClient2);
		// sett.init(list);
		System.out.println(msg);
		this.withClient2=withClient;
		ch = new ClientChat(withClient, withClient2);
		ch.send(msg,withClient2);
//		if(list!=null) {
//			return list;
//		}
//		return list;
		return null;
	}

	public ArrayList<String[]> back(Socket withServer2, ArrayList<String[]> list) {
		Setting sett = new Setting(withClient, withClient2);
		sett.init(list, withClient2);
		return list;

	}

}
