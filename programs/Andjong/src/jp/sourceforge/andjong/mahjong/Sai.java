package jp.sourceforge.andjong.mahjong;

import java.util.Random;

/**
 * �T�C�R�����Ǘ�����B
 *
 * @author Yuji Urushibara
 *
 */
public class Sai {
	/** �ԍ� */
	private int no = 1;

	/** �����W�F�l���[�^ */
	private Random random = new Random();

	/**
	 * �ԍ����擾����B
	 *
	 * @return �ԍ�
	 */
	public int getNo() {
		return no;
	}

	/**
	 * �T�C�R����U���Ĕԍ����擾����B
	 *
	 * @return �ԍ�
	 */
	public int saifuri() {
		return no = random.nextInt(6) + 1;
	}
}