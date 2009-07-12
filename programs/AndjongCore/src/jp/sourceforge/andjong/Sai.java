package jp.sourceforge.andjong;

import java.util.Random;

/**
 * サイコロを管理するクラスです。
 * 
 * @author Yuji Urushibara
 * 
 */
public class Sai {
	/** 番号 */
	private int no;

	/**
	 * 番号を取得します。
	 * 
	 * @return 番号
	 */
	public int getNo() {
		return no;
	}

	/**
	 * サイコロを振って番号を取得します。
	 * 
	 * @return 番号
	 */
	public int saifuri() {
		return no = new Random().nextInt(6) + 1;
	}
}
