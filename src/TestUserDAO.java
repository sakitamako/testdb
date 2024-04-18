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
		
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		/*test_tableに入っているデータ、user_name=? password=?に入る2つの条件を満たしたデータがsqlに代入される。
		 ?はプレースホルダと言って、その都度違うデータを入れて使用する。
		［例］user_name="taro" password="123"とした場合は太朗と１２３しかデータを抽出することができなくなる。*/
		String sql ="select * from test_table where user_name=? and password=?";
		
		//tryの中でエラーが発生した場合に、catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる
		try {
			
			//PreparedStatementとは DB まで運んでくれる箱
			PreparedStatement ps = con.prepareStatement(sql);
			
			//データベースの中に入るデータ
			ps.setString(1, name);
			ps.setString(2, password);
			
			//executeQuery();は実行メソッドで、必ず ResultSetが返ってくる
			ResultSet rs = ps.executeQuery();
			
			//ここでは2つのことをしている
			//下に1行ずらすこと
			//データが存在していれば戻り値を true で返す・存在しなければ falseで返す
			if (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				
			}
		//catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる	
		//SQLException（クラスが見つからない場合の例外）
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		//tryの中でエラーが発生した場合に、catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる
		try {
			
			//データベースとの接続をクローズ
			//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
			con.close();
			
		//catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる	
		//SQLException（クラスが見つからない場合の例外）
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//voidは戻り値がないメソッドで指定する特別な型
	public void selectAll() {

		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//test_tableに入っているデータがsqlに代入される
		String sql = "select * from test_table";

		//tryの中でエラーが発生した場合に、catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる
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

			//catchが受け取りprintStackTraceでエラーに至る履歴を表示してくれる
			//SQLException（クラスが見つからない場合の例外）
			} catch (SQLException e) {
				e.printStackTrace();
		}

		//tryの中でエラーが発生した場合に、catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる
		try {

			//データベースとの接続をクローズ
			//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
			con.close();

		//catchが受け取りprintStackTraceでエラーに至る履歴を表示してくれる
		//SQLException（クラスが見つからない場合の例外）
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	
	}
	
	//voidは戻り値がないメソッドで指定する特別な型
	public void selectByName(String name) {
		
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		//test_tableに入っているデータuser_name=? の条件を満たしたデータがsqlに代入される
		String sql ="select * from test_table where user_name=?";
		
		//tryの中でエラーが発生した場合に、catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる
		try {
			
			//PreparedStatementとは DB まで運んでくれる箱
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			//executeQuery();は実行メソッドで、必ず ResultSetが返ってくる
			ResultSet rs = ps.executeQuery();
			
			//while(rs.next())はカーソルを1行ずつ実行していきデータがなくなったら実行を終了する
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				
			}
		
		//catchが受け取りprintStackTraceでエラーに至る履歴を表示してくれる
		//SQLException（クラスが見つからない場合の例外）
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		//tryの中でエラーが発生した場合に、catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる
		try {
			
			//データベースとの接続をクローズ
			//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
			con.close();
			
		//catchが受け取りprintStackTraceでエラーに至る履歴を表示してくれる
		//SQLException（クラスが見つからない場合の例外）	
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	//voidは戻り値がないメソッドで指定する特別な型
	public void selectByPassword(String password) {
		
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		//test_tableに入っているデータ password=?に入る条件を満たしたデータがsqlに代入される
		String sql ="select * from test_table where password=?";
		
		//tryの中でエラーが発生した場合に、catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる
		try {
			
			//PreparedStatementとは DB まで運んでくれる箱
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString (1, password);
			
			//executeQuery();は実行メソッドで、必ず ResultSetが返ってくる
			ResultSet rs = ps.executeQuery();
			
			//while(rs.next())はカーソルを1行ずつ実行していきデータがなくなったら実行を終了する
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		
		//catchが受け取りprintStackTraceでエラーに至る履歴を表示してくれる
		//SQLException（クラスが見つからない場合の例外）	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//tryの中でエラーが発生した場合に、catchが受け取り、printStackTraceでエラーに至る履歴を表示してくれる
		try {
			
			//データベースとの接続をクローズ
			//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
			con.close() ;
		
		//catchが受け取りprintStackTraceでエラーに至る履歴を表示してくれる
		//SQLException（クラスが見つからない場合の例外）
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
	
