import java.util.Random;

//part08までは終わりました。次はpart09から見てください

public class part01 {

	static String name = "アルス";// 主人公の名前
	static int lv = 30;// 主人公のレベル
	static int hp = 30;// 主人公のHP
	static int gold = 50;// 主人公の所持金

	public static void main(String[] args) throws java.io.IOException {

		putJyosyou();
		putCommand();

		if (hp <= 0) {
			return;
		}

	}

	// 序章
	public static void putJyosyou() {
		System.out.println("りゅうおうに光の玉を奪われた！！");
		putStatus();
	}

	public static void putStatus() {
		System.out.println("---------------------------------");
		System.out.println("  " + name + "  " + "Lｖ" + lv + "  " + "HP" + hp + "  " + "G" + gold);
		System.out.println("---------------------------------");
	}

	public static void putCommand() throws java.io.IOException {
		System.out.println("1,魔王を倒しにいく");
		System.out.println("2,スライムをたおす");
		System.out.println("3,宿屋に泊まる");

		int c = inputCommand();

		if (c == '1') {
			System.out.println("魔王が現れた！");
			if (lv > 40) {
				putGameClear();
			}
			if (lv <= 40) {
				putGameOver();
			}

		} else if (c == '2') {
			syugyou();
		} else if (c == '3') {
			if (gold >= 10) {
				hp = lv;
				gold -= 10;
			}

			putStatus();
			putCommand();
		}
	}

	public static void syugyou() throws java.io.IOException {

		Random r = new Random();

		int e = r.nextInt(3) + 1;
		System.out.println("敵が" + e + "匹現れた");
		System.out.println();

		int d = r.nextInt(8);
		hp -= d;


		lv += e;

		System.out.println(d + "のダメージを受けた");

		if (hp <= 0) {
			hp = 0;
			putGameOver();
		} else {
			putStatus();
			putCommand();

		}
	}

	public static int inputCommand() throws java.io.IOException {
		int c = System.in.read();
		if (c == 10 || c == 13) {
			return inputCommand();
		}
		return c;
	}

	// ゲームオーバーを表示します
	public static void putGameOver() {
		System.out.println("GAME OVER");
	}

	// ゲームクリアを表示します
	public static void putGameClear() {
		System.out.println("GAME CLEAR");
		return;
	}

}
