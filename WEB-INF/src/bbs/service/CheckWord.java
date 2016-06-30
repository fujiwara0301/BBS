package bbs.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * フォームに入力された値のチェックを行う.<br>
 *
 * 各項目で必要に応じて必須チェック、文字数チェックを行う.
 *
 * @author Naoto Fujiwara
 */
public class CheckWord {

	/**
	 * エラーリスト.
	 */
	private ArrayList<String> errorList = new ArrayList<String>();

	/**
	 * 名前のチェックを行う.<br>
	 *
	 * 20文字以下であるかの文字数チェックを行い、エラーが見つかった場合エラーリストに書き込む.
	 *
	 * @param name　名前
	 * @param errorWord　エラーメッセージで表示する”名前”文字列
	 */
	public void nameCheck(String name, String errorWord) {
		lengthCheck(name, errorWord, 20);
	}

	/**
	 * メールアドレスのチェックを行う.<br>
	 *
	 * 正規表現を用いた表記のチェック及び30文字以下であるかの文字数チェックを行い、
	 * エラーが見つかった場合エラーリストに書き込む.
	 *
	 * @param mail　メールアドレス
	 * @param errorWord エラーメッセージで表示する”メール”文字列
	 */
	public void mailCheck(String mail, String errorWord) {
		if (!mail.equals("")
				&& !hasChecked(mail, "^[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+$")) {
			errorList.add("メールアドレスは必須ではありません。入力する場合は一つの@を含んだ半角英数字のアドレスであるか確認してください。");
		}
		lengthCheck(mail, errorWord, 30);
	}

	/**
	 * タイトルのチェックを行う.<br>
	 *
	 * 必須チェック及び20文字以下であるかの文字数チェックを行い、
	 * エラーが見つかった場合エラーリストに書き込む.
	 *
	 * @param title タイトル
	 * @param errorWord エラーメッセージで表示する”タイトル”文字列
	 */
	public void titleCheck(String title, String errorWord) {
		requiredCheck(title, errorWord);
		lengthCheck(title, errorWord, 20);
	}

	/**
	 * 本文のチェックを行う.<br>
	 *
	 * 必須チェック及び200文字以下であるかの文字数チェックを行い、
	 * エラーが見つかった場合エラーリストに書き込む.
	 *
	 * @param message 本文
	 * @param errorWord エラーメッセージで表示する”本文”文字列
	 */
	public void messageCheck(String message, String errorWord) {
		requiredCheck(message, errorWord);
		lengthCheck(message, errorWord, 200);
	}

	/**
	 * パスワードのチェックを行う.<br>
	 *
	 * 必須チェック及び半角英数字であるかのチェック、8文字以下であるかの文字数チェックを行い、
	 * エラーが見つかった場合エラーリストに書き込む.
	 *
	 * @param password パスワード
	 * @param errorWord エラーメッセージで表示する”パスワード”文字列
	 */
	public void passwordCheck(String password, String errorWord) {
		if (!hasChecked(password, "^[0-9a-zA-Z]+$")) {
			errorList.add("パスワードは必須です。半角英数字で入力してください。");
		}
		lengthCheck(password, errorWord, 8);
	}

	/**
	 * エラーリストを出力する.
	 *
	 * @return エラーリスト
	 */
	public ArrayList<String> getErrorList() {
		return errorList;
	}
	/**
	 * 文字の判定を行う.<br>
	 *
	 * 入力された値が指定されたパターンに一致するかどうか判定する.
	 *
	 * @param inputWord 入力値
	 * @param regex パターン
	 * @return 結果 (パターンと一致する場合true、一致しない場合falseを返す)
	 */
	private boolean hasChecked(String inputWord, String regex) {

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputWord);
		return matcher.find();
	}

	/**
	 * 必須チェックを行う.
	 *
	 * @param getword チェックを行う文字列
	 * @param errorWord エラーメッセージで表示する言葉
	 */
	private void requiredCheck(String getword, String errorWord) {
		if (getword.equals("")) {
			errorList.add(errorWord + " は必須です。");
		}
	}

	/**
	 * 文字数チェックを行う.
	 *
	 * @param getword チェックを行う文字列
	 * @param errorWord エラーメッセージで表示する言葉
	 * @param limitNumber 文字数上限
	 */
	private void lengthCheck(String getword, String errorWord, int limitNumber) {
		if (getword.length() > limitNumber) {
			errorList.add(errorWord +  "が長すぎます。 " + limitNumber + " 文字以内で入力してください。");
		}
	}
}