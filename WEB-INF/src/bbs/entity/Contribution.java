package bbs.entity;

/**
 * 投稿データのフォーマットを提供するクラス.
 * @author Naoto Fujiwara
 */
public class Contribution {

	/**
	 * 名前.
	 */
	private String name = "";

	/**
	 * メールアドレス.
	 */
	private String mail = "";

	/**
	 * タイトル.
	 */
	private String title = "";

	/**
	 * メッセージ本文.
	 */
	private String message = "";

	/**
	 * ID.
	 */
	private String id = "";

	/**
	 * パスワード.
	 */
	private String password = "";

	/**
	 * 投稿時間.
	 */
	private String posttime = "";

	/**
	 * 名前を入力する.
	 *
	 * @param name 名前
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * 名前を出力する.
	 *
	 * @return　名前
	 */
	public String getName() {

		return name;
	}

	/**
	 * メールアドレスを入力する.
	 *
	 * @param mail メールアドレス
	 */
	public void setMail(String mail) {

		this.mail = mail;
	}

	/**
	 * メールアドレスを出力する.
	 *
	 * @return メールアドレス
	 */
	public String getMail() {

		return mail;
	}

	/**
	 * タイトルを入力する.
	 *
	 * @param title タイトル
	 */
	public void setTitle(String title) {

		this.title = title;
	}

	/**
	 * タイトルを出力する.
	 *
	 * @return タイトル
	 */
	public String getTitle() {

		return title;
	}

	/**
	 * 本文を入力する.
	 *
	 * @param message 本文
	 */
	public void setMessage(String message) {

		this.message = message;
	}

	/**
	 * 本文を出力する.
	 *
	 * @return 本文
	 */
	public String getMessage() {

		return message;
	}

	/**
	 * IDを入力する.
	 *
	 * @param id ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * IDを出力する.
	 *
	 * @return ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * パスワードを入力する.
	 *
	 * @param password パスワード
	 */
	public void setPassword(String password) {

		this.password = password;
	}

	/**
	 * パスワードを出力する.
	 *
	 * @return パスワード
	 */
	public String getPassword() {

		return password;
	}

	/**
	 * 投稿時間を入力する.
	 *
	 * @param time　投稿時間
	 */
	public void setPosttime(String time) {

		posttime = time;
	}

	/**
	 * 投稿時間を出力する.
	 *
	 * @return 投稿時間
	 */
	public String getPosttime() {

		return posttime;
	}
}