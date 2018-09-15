
public class Player {

	 String name = "「ロト」";// プレイヤーの名前 を書けばブロックの外でもOK
	 int lv = 30; // プレイヤーのレベル
	 int hp = 30; // プレイヤーのHP
	 int gold = 50; // プレイヤーの所持金

	public  String getStatusString() {
		return ("       " + name + " " + " Lv" + lv + " HP" + hp + " " + gold + "G");
	}

	public  Player(){
		lv = 30;
		hp = 30;
		gold = 50;
	}
}
