public class Test {
	
	/*public,どこからでも参照可能
      static,インスタンス可(new)しなくても外部から使用可能
      void,戻り値なし
      main,メソッド名
      String[],引数をString型の配列で受け取る
      args,引数名、argument（和訳：引数）の複数形でargumentsの略省*/
	public static void main(String[] args) {
		
		//インスタンス化
		TestUserDAO dao = new TestUserDAO();
		
		//メソッドを実行
		dao.select("taro", "123");
	}

}
