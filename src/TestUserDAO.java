import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUserDAO {

	//String=文字列
	String name = "";
	String password = "";
	
	//voidは戻り値がないメソッドで指定する特別な型
	public void select(String name, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
	
		String sql ="select * from test_table where user_name=? and password=?";
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		try {
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//voidは戻り値がないメソッドで指定する特別な型
	public void selectAll() {

		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		/*test_tableに入っているデータ、user_name=? password=?に入る2つの条件を満たしたデータがsqlに代入される。
		 ?はプレースホルダと言って、その都度違うデータを入れて使用する。
		［例］user_name="taro" password="123"とした場合は太朗と１２３しかデータを抽出することができなくなる。*/
		String sql = "select * from test_table";

		//try.catchはjavaの例外処理のための構文
		try {

			//PreparedStatementとはDBまで運んでくれる箱のこと
			PreparedStatement ps = con.prepareStatement(sql);

			//executeQuery();は実行メソッド、必ずResultSetが返ってくる
			ResultSet rs = ps.executeQuery();
			
			//while(rs.next())はカーソルを1行ずつ実行していきデータがなくなったら実行を終了する
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				
			}

			/*tryの中でエラーが発生した場合、catchが受け取り
			 printStackTraceでエラーに至る履歴を表示してくれる*/
			//SQLException（クラスが見つからない場合の例外）
			} catch (SQLException e) {
				e.printStackTrace();
		}

		//try.catchはjavaの例外処理のための構文
		try {

			//データベースとの接続をクローズ
			//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
			con.close();

			/*tryの中でエラーが発生した場合、catchが受け取り
			 printStackTraceでエラーに至る履歴を表示してくれる*/
			//SQLException（クラスが見つからない場合の例外）
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	
	}
	
	public void selectByName(String name) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		String sql ="select * from test_table where user_name=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		try {
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public void selectByPassword(String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		String sql ="select * from test_table where password=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString (1, password);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			con.close() ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
	
