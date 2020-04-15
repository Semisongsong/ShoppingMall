package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOCenter implements DAOInterface {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
//	private MemberDAO memDAO = null;
//	private ManagementDAO mgmtDAO = null;
//	private CartDAO cartDAO = null;
	private static DAOCenter DAOcenter;

	public DAOCenter() {
		connect();
		if (conn != null) {
//			memDAO = MemberDAO.getInstance(conn);
//			mgmtDAO = ManagementDAO.getInstance(conn);
//			cartDAO = CartDAO.getInstance(conn);
		}
	}

	public static DAOCenter getInstance() {
		if (DAOcenter == null) {
			DAOcenter = new DAOCenter();
		}
		return DAOcenter;
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class load fail :" + e.getMessage());
		}
	}

	private void connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ooo", "system", "11111111");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class load fail : " + e.getMessage());
		}
	}

	public void whichone(Object objectMember, Object m) {
		System.out.println("디에이오센터에 오신걸 환영합니다.");
		String ch = String.valueOf(m);
		if(ch.equals("join")) {
			MemberDAO dao = MemberDAO.getInstance();
			dao.InsertMember(objectMember);
			System.out.println("왔다");
		}
//		switch (ch) {
//
//		case "join":
//			MemberDAO dao = MemberDAO.getInstance();
//			dao.InsertMember(objectMember);
//			System.out.println("왔다");
//			break;
//		case "goods":
//			break;
//		case "cart":
//			break;
//		case "order":
//			break;
//		}

	}

	@Override
	public Boolean Insert(Object DTO) {
//		String[] check = (String[]) DTO;
//		MemberDTO member = new MemberDTO();
//		for (int i = 0; i < check.length; i++) {
//			member.setId(check[0]);
//			member.setName(check[1]);
//			member.setPwd(check[2]);
//			member.setAdr(check[3]);
//			member.setCell(check[4]);
//		}
		MemberDAO dao = MemberDAO.getInstance();
		dao.InsertMember(DTO);
		return true;
	}

	@Override
	public Boolean Select(Object DTO) {
		System.out.println("왔니??");
		return null;
	}

	@Override
	public Boolean Edit(Object DTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Delete(Object DTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
