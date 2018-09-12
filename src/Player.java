
public class Player {

	static String name = "「ロト」";// プレイヤーの名前 staticを書けばブロックの外でもOK
	static int lv = 30; // プレイヤーのレベル
	static int hp = 30; // プレイヤーのHP
	static int gold = 50; // プレイヤーの所持金

	public static String getStatusString() {
		return ("       " + name + " " + " Lv" + lv + " HP" + hp + " " + gold + "G");
	}
}
