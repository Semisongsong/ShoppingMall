package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MemberDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private MemberDTO member = null;
	private static MemberDAO DAOobj;

	private MemberDAO() {
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("불러오기 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("불러오기 실패");
		}
	}

	public static MemberDAO getInstance() {
		if (DAOobj == null) {
			DAOobj = new MemberDAO();
		}
		return DAOobj;
	}

	private boolean connect() {
		boolean result = false;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("???? ????:" + e.getMessage());
		}
		return result;
	}

	public boolean InsertMember(Object oj) {
		boolean result = false;
		String[] check = (String[]) oj;
		member = new MemberDTO();
		for (int i = 0; i < check.length; i++) {
			member.setId(check[0]);
			member.setName(check[1]);
			member.setPwd(check[2]);
			member.setAdr(check[3]);
			member.setCell(check[4]);
		}
		if (connect()) {
			try {
				String sql = "insert into member values(?,?,?,?,?,1)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, member.getId());
				psmt.setString(2, member.getName());
				psmt.setString(3, member.getPwd());
				psmt.setString(4, member.getAdr());
				psmt.setString(5, member.getCell());
				int r = psmt.executeUpdate();

				if (r > 0) {
					result = true;
				}
				psmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB연결 실패");
			System.exit(0);
		}

		return result;
	}
}