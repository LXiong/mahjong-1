package jp.sourceforge.andjong;

import static jp.sourceforge.andjong.Info.*;
import jp.sourceforge.andjong.Game.SAI;

/**
 * UIを実装するクラスです。
 * <p>
 * コンソールで動くように実装しています。<br>
 * UIクラスを継承し、別のUIを実装します。
 * </p>
 * 
 * @author Yuji Urushibara
 * 
 */
public class UI {
	/** InfoUIオブジェクト */
	private InfoUI infoUi;

	/** 手牌 */
	private Tehai tehai = new Tehai();

	/** 河 */
	private Kawa kawa = new Kawa();

	/**
	 * UIを初期化します。
	 * 
	 * @param infoUi
	 *            InfoUIオブジェクト
	 */
	public UI(InfoUI infoUi) {
		this.infoUi = infoUi;
	}

	/**
	 * イベントを処理します。
	 * 
	 * @param callPlayerIdx
	 *            イベントを発行した家
	 * @param targetPlayerIdx
	 *            イベントの対象の家
	 * @param eid
	 *            イベントID
	 */
	public void event(EID eid, int callPlayerIdx, int targetPlayerIdx) {
		switch (eid) {
		// 場所決め
		case UI_BASHOGIME:
			// 表示することはない。
			break;
		// 親決め
		case UI_OYAGIME:
			// サイ振りを表示します。
			SAI[] sai = infoUi.getSai();
			System.out.println("[サイ振り][" + sai[0].getNo() + "]["
					+ sai[1].getNo() + "]");
			break;
		// 洗牌
		case UI_SENPAI:
			// 表示することはない。
			break;
		// サイ振り
		case UI_SAIFURI:
			// ドラ表示牌を表示します。
			Hai[] doras = infoUi.getDora();
			System.out.print("[ドラ表示牌]");
			for (Hai hai : doras) {
				System.out.print("[" + idToString(hai.getId()) + "]");
			}
			System.out.println();
			break;
		// 流し
		case NAGASHI:
			// 表示することはない。
			break;
		// ツモ
		case TSUMO:
			System.out
					.print("[" + jikazeToString(infoUi.getJikaze()) + "][ツモ]");

			// 手牌を表示します。
			printJyunTehai(tehai);

			// ツモ牌を表示します。
			System.out
					.println(":" + idToString((infoUi.getTsumoHai()).getId()));
			break;
		// ツモあがり
		case TSUMOAGARI:
			System.out.print("[" + jikazeToString(infoUi.getJikaze())
					+ "][ツモあがり]");

			// 手牌を表示します。
			printJyunTehai(tehai);

			// ツモ牌を表示します。
			System.out
					.println(":" + idToString((infoUi.getTsumoHai()).getId()));
			break;
		// 捨牌
		case SUTEHAI:
			// 自分の捨牌のみを表示します。
			if (callPlayerIdx == 0) {
				System.out.print("[" + jikazeToString(infoUi.getJikaze())
						+ "][捨牌]");

				// 河を表示します。
				printKawa(kawa);

				// 捨牌を表示します。
				System.out.println(":"
						+ idToString((infoUi.getSuteHai()).getId()));
			}
			break;
		// ロン
		case RON:
			System.out
					.print("[" + jikazeToString(infoUi.getJikaze()) + "][ロン]");

			// 手牌を表示します。
			printJyunTehai(tehai);

			// 当たり牌を表示します。
			System.out.println(":" + idToString((infoUi.getSuteHai()).getId()));
			break;
		default:
			break;
		}
	}

	/**
	 * 手牌を表示します。
	 * <p>
	 * TODO 鳴き牌を表示すること。
	 * </p>
	 * 
	 * @param tehai
	 *            手牌
	 */
	private void printJyunTehai(Tehai tehai) {
		infoUi.copyTehai(tehai, 0);
		Hai[] jyunTehai = tehai.getJyunTehai();
		int jyunTehaiLength = tehai.getJyunTehaiLength();
		for (int i = 0; i < jyunTehaiLength; i++)
			System.out.print(idToString(jyunTehai[i].getId()));
	}

	/**
	 * 河を表示します。
	 * 
	 * @param kawa
	 *            河
	 */
	private void printKawa(Kawa kawa) {
		infoUi.copyKawa(kawa, 0);
		KawaHai[] kawaHais = kawa.getKawaHai();
		int kawaLength = kawa.getKawaHaiLength();
		for (int i = 0; i < kawaLength; i++)
			System.out.print(idToString(kawaHais[i].getId()));
	}

	/**
	 * 牌番号を文字列に変換します
	 * 
	 * @param id
	 *            牌番号
	 * @return 文字列
	 */
	static public String idToString(int id) {
		int kind = id & (Hai.KIND_SHUU | Hai.KIND_TSUU);
		id &= ~(Hai.KIND_SHUU | Hai.KIND_TSUU);

		switch (kind) {
		case Hai.KIND_WAN:
			switch (id) {
			case 1:
				return "一";
			case 2:
				return "二";
			case 3:
				return "三";
			case 4:
				return "四";
			case 5:
				return "五";
			case 6:
				return "六";
			case 7:
				return "七";
			case 8:
				return "八";
			case 9:
				return "九";
			}
			break;
		case Hai.KIND_PIN:
			switch (id) {
			case 1:
				return "�@";
			case 2:
				return "�A";
			case 3:
				return "�B";
			case 4:
				return "�C";
			case 5:
				return "�D";
			case 6:
				return "�E";
			case 7:
				return "�F";
			case 8:
				return "�G";
			case 9:
				return "�H";
			}
			break;
		case Hai.KIND_SOU:
			switch (id) {
			case 1:
				return "１";
			case 2:
				return "２";
			case 3:
				return "３";
			case 4:
				return "４";
			case 5:
				return "５";
			case 6:
				return "６";
			case 7:
				return "７";
			case 8:
				return "８";
			case 9:
				return "９";
			}
			break;
		case Hai.KIND_FON:
			switch (id) {
			case 1:
				return "東";
			case 2:
				return "南";
			case 3:
				return "西";
			case 4:
				return "北";
			}
			break;
		case Hai.KIND_SANGEN:
			switch (id) {
			case 1:
				return "白";
			case 2:
				return "發";
			case 3:
				return "中";
			}
			break;
		}

		return null;
	}

	/**
	 * 自風を文字列に変換します。
	 * 
	 * @param jikaze
	 *            自風
	 * @return　文字列
	 */
	static public String jikazeToString(int jikaze) {
		switch (jikaze) {
		case 0:
			return "東";
		case 1:
			return "南";
		case 2:
			return "西";
		case 3:
			return "北";
		}

		return null;
	}
}
