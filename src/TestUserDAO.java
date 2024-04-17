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
		String sql = "select * from test_table where user_name=? and password=?";

		//try.catchはjavaの例外処理のための構文
		try {

			//PreparedStatementとはDBまで運んでくれる箱のこと
			PreparedStatement ps = con.prepareStatement(sql);

			//データベースの中に入るデータ
			ps.setString(1, name);
			ps.setString(2, password);

			//executeQuery();は実行メソッド、必ずResultSetが返ってくる
			ResultSet rs = ps.executeQuery();

			/*この項目では2つのことをしてくれている
			 ①下に1行ずらすこと
			 ②データが存在していれば戻り値をtrueで返す・存在しなければfalseで返す
			 初期位置はカラム名（user_nameとかpassword）0行目からスタートする。
			 今回はif(rs.next())が実行されたので1行下にずれる。
			 そうするとtaro 123の行のデータを抽出してくれる。
			 今回は1行で終了だが、while(rs.next())はデータが存在する限り1行ずつ移動する。*/
			if (rs.next()) {
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

}
