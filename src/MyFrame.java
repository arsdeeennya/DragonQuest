
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	JLabel jlChild;
	JLabel jlMsg;
	JPanel jpChild2;
	BufferedImage biMonster;

	public MyFrame() throws IOException {

		File file = new File("vx_chara08_a-3f6af75.png");// ファイルを開くimport java.io.File;
		biMonster = ImageIO.read(file); // 画像全体を読み込む import
										// javax.imageio.ImageIO;

		setBounds(20, 40, 940, 540); // フレームサイズを設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ×ボタンの有効化
		add(createBasePanel()); // 親パネルを作成し、フレームに貼り付け↓
		setVisible(true); // フレームを表示状態へ

		enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);
	}

	protected void processKeyEvent(KeyEvent e) {
		if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
			System.out.println("キー" + e.getKeyCode() + "のイベント" + e.getKeyCode() + "が押されたよ");

			if (e.getKeyCode() == java.awt.event.KeyEvent.VK_1) {
				jlMsg.setText("りゅうおうを倒した");
			}
			if (e.getKeyCode() == java.awt.event.KeyEvent.VK_2) {
				jpChild2.removeAll();
				addMonster();
			}
			if (e.getKeyCode() == java.awt.event.KeyEvent.VK_3) {
				jlMsg.setText("昨夜はお楽しみでしたね");
			}
		}
	}

	/**
	 *
	 * 基盤パネルを作成
	 *
	 */

	JPanel createBasePanel() throws IOException {

		JPanel jp = MyLib.createPanel(Color.BLACK);

		// フォントを作成
		Font f = new Font(Font.MONOSPACED, Font.BOLD, 40);

		// レイアウト１行目
		// パネルを作成し、親パネルに貼り付け↓
		JPanel jpChild = MyLib.createPanel(Color.BLUE);
		jp.add(jpChild);

		// ラベルを作成し、子パネルに貼り付け
		jlChild = new JLabel(Player.getStatusString());
		jlChild.setFont(f);
		jlChild.setForeground(Color.WHITE);
		jlChild.setPreferredSize(new java.awt.Dimension(900, 60));
		jpChild.add(jlChild);

		// レイアウト２行目
		// パネルを作成し、親パネルに貼り付け↓
		jpChild2 = MyLib.createPanel(Color.CYAN);
		jp.add(jpChild2);

		// 選択肢をパネルに貼り付け
		JLabel jlMain = new JLabel("<html>1.りゅうおうを倒しにいく<br>2.スライムをたおす<br>3.宿屋に泊まる");
		jlMain.setFont(f);
		jpChild2.add(jlMain);

		// 区切り線
		JPanel jpHR = MyLib.createPanel(Color.WHITE);
		jpHR.setPreferredSize(new java.awt.Dimension(900, 4));
		jp.add(jpHR);

		// レイアウト３行目
		// ラベルを作成し、パネルに貼り付け
		jlMsg = new JLabel("ドラゴンクエストだよん");

		jlMsg.setFont(f);
		jlMsg.setForeground(new Color(255, 128, 0));
		jp.add(jlMsg);

		return (jp);
	}

	/**
	 * モンスターをパネルに加えます
	 */

	void addMonster() {

		Random r = new Random();

		// 敵出現↓
		int e = r.nextInt(6) + 1;// 敵の数↓

		// 敵グラフィック表示
		int cw = 32; // セルサイズ・幅
		int ch = 48; // セルサイズ・高さ
		int sw = cw * 4; // 表示サイズ・幅
		int sh = ch * 4; // 表示サイズ・高さ

		for (int i = 0; i < e; i++) {// for(変数の初期化;条件;変数の更新）
			MyLib.putMonster(jpChild2, biMonster, 0, 0, cw, ch, sw, sh);// モンスター0-0を表示
		}
		/*
		 * putMonster( jpChild2, biMonster, 0, 0, cw, ch, sw, sh );//モンスター0-0を表示
		 * putMonster( jpChild2, biMonster, 6, 0, cw, ch, sw, sh );//モンスター6-0を表示
		 * putMonster( jpChild2, biMonster, 9, 0, cw, ch, sw, sh );//モンスター9-0を表示
		 * putMonster( jpChild2, biMonster, 0, 4, cw, ch, sw, sh );//モンスター0-4を表示
		 * putMonster( jpChild2, biMonster, 6, 4, cw, ch, sw, sh );//モンスター6-4を表示
		 * putMonster( jpChild2, biMonster, 9, 4, cw, ch, sw, sh );//モンスター9-4を表示
		 */
		// HPを減らす↓
		int d = r.nextInt(8);
		Player.hp -= d;
		if (Player.hp < 0) {
			Player.hp = 0;
		}
		// レベル上昇↓
		Player.lv += e;

		String s = "<html>スライムが" + e + "匹あらわれた!!<br>" + Player.name + "は" + d + "ポイントのダメージを受けた!!<br>";

		if (Player.hp == 0) {
			s += "GAME OVER";
		} else {
			s += "レベルが" + Player.lv + "になった";
		}

		// メッセージ表示
		jlMsg.setText(s);
		jlChild.setText(Player.getStatusString());
	}
}
