
public class Console {

	/**
	 * 序章を表示します こうやってコメントアウトするとコマンドプロントを操作して、マニュアルが作れる(Part05参照)
	 */


	public static void putjyosyou() {

		/*
		 * String name ="とんぬら"; 遊びで、ここで変数の初期化をするとこっちの変数が優先された
		 */

		System.out.println("ラダトーム城の光の玉がりゅうおうに奪われた！");
		putStatus();
	}

	public static void putStatus() {
		put("-------------------------");
		put(part01.m_player.getStatusString());
		put("-------------------------");
	}

	/**
	 * ゲームクリアの画面を表示します
	 */
	public static void putGameClear() {
		System.out.println("りゅうおうを倒した！！");
	}

	/**
	 * ゲームオーバーの画面を表示します
	 */
	public static void putGameOver() {
		System.out.println("りゅうおうに負けた");
	}

	/**
	 * 引数で指定された文字列を表示します
	 */
	public static void put(String str) {

		System.out.println(str);

	}
}
