
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyLib {

	/**
	 * パネルを作成し、背景色を設定します。
	 */
	static JPanel createPanel(Color c) {
		JPanel jp = new JPanel();
		jp.setBackground(c);
		return (jp);
	}

	/**
	 * モンスターを表示します
	 *
	 * @param jpChild2
	 *            表示対象パネル
	 * @param ba
	 *            画像全体
	 * @param x
	 *            表示するセル座標x
	 * @param y
	 *            表示するセル座標y
	 * @param cw
	 *            セルの大きさ・幅
	 * @param ch
	 *            セルの大きさ・高さ
	 * @param sw
	 *            表示サイズ・幅
	 * @param sh
	 *            表示サイズ・高さ
	 */

	static void putMonster(JPanel jpChild2, BufferedImage ba, int x, int y, int cw, int ch, int sw, int sh) {
		BufferedImage bs = ba.getSubimage(cw * x, ch * y, cw, ch);
		Image im = bs.getScaledInstance(sw, sh, Image.SCALE_DEFAULT);
		ImageIcon ii = new ImageIcon(im); // JLabel用に型変換
		JLabel jlImage = new JLabel(ii); // 画像のコンポーネントを作成
		jlImage.setSize(cw, ch); // 画像のコンポーネントサイズを設定
		jpChild2.add(jlImage); // 画像を貼り付け
	}
}
