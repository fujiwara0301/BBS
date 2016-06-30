package bbs.form;

public class RegisterForm {
	
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
	 * パスワード.
	 */
	private String password = "";

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
}
