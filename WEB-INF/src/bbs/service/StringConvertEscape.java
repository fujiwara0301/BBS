package bbs.service;


/**
 * フォームへの入力値の変換を行う.
 *
 * @author Fujiwara
 */
public class StringConvertEscape {

	/**
	 * メタ文字を実態参照に変換する.
	 *
	 * @param message 変換処理を行う文字列
	 * @return 変換済みの文字列
	 */
	public String strConvertEscape(String message) {

		String editMessage = message.replace("&","&amp;");
		editMessage = editMessage.replace("<","&lt;");
		editMessage = editMessage.replace(">","&gt;");
		return editMessage;
	}

	/**
	 * 改行文字を改行タグに変換する.
	 *
	 * @param message 変換処理を行う文字列
	 * @return 変換済みの文字列
	 */
	public String strConvertIndention(String message) {

		String editMessage = message.replace("\r\n","<br/>");
		return editMessage;
	}
}