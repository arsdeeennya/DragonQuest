
import java.util.Random;

public class part01 {

	static Player m_player = new Player();

	public static void main(String[] args) throws java.io.IOException {

		Console.putjyosyou(); // 序章を表示

		putCommand();

		if (m_player.hp <= 0) {
			return;
		}

		// りゅうおうを倒しにいく↓
		if (m_player.lv > 40) { // レベルが40以上満の場合
			Console.putGameClear(); // ゲームクリアの画面を表示
		} else { // レベルが40未満の場合
			Console.putGameOver(); // ゲームオーバーの画面を表示
		}
	}

	/**
	 * コマンドを表示します↓
	 */

	public static void putCommand() throws java.io.IOException {
		System.out.println("1.りゅうおうを倒しに行く");
		System.out.println("2.修行してからりゅうおうを倒しにいく");
		System.out.println("3.宿屋に泊る");

		int c = part01.inputCommand();

		if (c == '1') {
			System.out.println("りゅうおうが現れた");
		} else if (c == '2') {
			syugyou();

		} else if (c == '3') {// 宿屋に泊まる
			if (m_player.gold < 10) {
				System.out.println("所持金が足りません");
				putCommand();
			}
			m_player.hp = m_player.lv;
			m_player.gold -= 10;
			System.out.println("HPが回復した");
			Console.putStatus();
			putCommand();
		}
	}

	public static void syugyou() throws java.io.IOException {
		Random r = new Random();

		// 敵出現↓
		int e = r.nextInt(3) + 1;// 敵の数↓
		System.out.println("敵が" + e + "匹あらわれた");
		String m = "の具志堅の";
		String s = "";
		for (int i = 0; i < e; i++) {// for(変数の初期化;条件;変数の更新）
			s = s + m;// 繰り返す処理
		}

		System.out.println(s);

		// HPを減らす↓
		int d = r.nextInt(8);
		m_player.hp -= d;
		if (m_player.hp <= 0) {
			m_player.hp = 0;
		}

		// レベル上昇↓
		m_player.lv += e;
		// System.out.println("レベルが"+m_player.lv+"になった");

		if (m_player.hp <= 0) {
			System.out.println("GAME OVER");
		} else {
			Console.putStatus();
			putCommand();
		}
	}

	public static int inputCommand() throws java.io.IOException {
		int c = System.in.read();

		if (c == 10 || c == 13) {// 13はEnterのこと（キーコード一覧参照）
			return (inputCommand());

		}
		return (c);// cに戻る、cはsystem.in.read （part08）
	}

}
