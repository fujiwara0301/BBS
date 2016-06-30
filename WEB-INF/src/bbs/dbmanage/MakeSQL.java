package bbs.dbmanage;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import bbs.entity.Contribution;

/**
 * データベースアクセスのためのSQLを作成する.
 *
 * @author Naoto Fujiwara
 */
public class MakeSQL {

	/**
	 * 新規登録用のSQLを作成する.
	 *
	 * @param name 名前
	 * @param mail メール
	 * @param title タイトル
	 * @param message 本文
	 * @param password パスワード
	 * @return SQL文
	 */
	public static String makeInsert(Contribution record) {

		String nowTime = makeNowTime();
		String sql = "INSERT INTO bbs.list "
				+ "(name, mail, title, message, password, postingtime) VALUES ('"
				+ record.getName() + "', '" + record.getMail() + "', '"
				+ record.getTitle() + "', '" + record.getMessage() + "', '"
				+ record.getPassword() + "', '" + nowTime + "')";
		return sql;
	}

	/**
	 * レコードの更新を行うSQLを生成する.
	 *
	 * @param name 名前
	 * @param mail メールアドレス
	 * @param title タイトル
	 * @param message 本文
	 * @param password パスワード
	 * @param ID ID
	 * @return SQL文
	 */
	public static String makeUpdate(Contribution record) {

		String nowTime = makeNowTime();
		String sql = "UPDATE bbs.list SET "
				+ "name='" + record.getName() + "', mail='" + record.getMail()
				+ "', title='" + record.getTitle() + "', message='"
				+ record.getMessage() + "', password='" + record.getPassword()
				+ "', postingtime='" + nowTime + "' WHERE ID='" + record.getId() + "'";
		return sql;
	}

	/**
	 * 投稿時刻の昇順に並べ替えて全レコードを返すSQL文を生成する.
	 *
	 * @return SQL文
	 */
	public static String makeList() {

		String sql = "SELECT * FROM bbs.list ORDER BY postingtime ASC";
		return sql;
	}

	/**
	 * IDに一致したレコードを削除するSQLを生成する.
	 *
	 * @param removeID ID
	 * @return SQL文
	 */
	public static String makeDelete(String removeID) {

		String sql = "DELETE FROM bbs.list WHERE ID='" + removeID + "'";
		return sql;
	}

	/**
	 * IDに一致したレコードを検索するSQLを生成する.
	 *
	 * @param IDCode ID
	 * @return SQL文
	 */
	public static String selectOneData(String IDCode) {

		String sql = "SELECT * FROM bbs.list WHERE ID='" + IDCode + "'";
		return sql;
	}

	/**
	 * 現在の日付時刻の文字列を作成する.
	 *
	 * @return 日時の文字列
	 */
	private static String makeNowTime() {

		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormatter.format(calendar.getTime());
	}
}