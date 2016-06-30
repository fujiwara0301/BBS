package bbs.dbmanage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bbs.entity.Contribution;
import bbs.service.StringConvertEscape;

/**
 * データベースへの入出力管理を行う.
 *
 * @author Naoto Fujiwara
 */
public class DBManager {

	/**
	 * データベースへのコネクション取得の際に必要なURL.
	 */
	private static final String ACCESS_URL = "jdbc:mysql://localhost:3306/BBS";

	/**
	 * データベースへのコネクション取得の際に必要なユーザー名.
	 */
	private static final String ACCESS_USER = "root";

	/**
	 * データベースへのコネクション取得の際に必要なパスワード.
	 */
	private static final String ACCESS_PASSWORD = "SSS-pc35";

	/**
	 *  タグ文字及び改行文字の変換クラス
	 */
	private static StringConvertEscape converter = new StringConvertEscape();

	/**
	 * コネクションの取得.
	 *
	 * @return コネクション
	 */
	private static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					ACCESS_URL, ACCESS_USER, ACCESS_PASSWORD);
			return connection;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 受け取ったSQL文を実行する.
	 *
	 * @param sql SQL文
	 * @throws SQLException SQL送信時に発生する例外
	 */
	public static void runSQL(String sql) {

		Connection connection = null;
		Statement statement = null;

		try {
		connection = DBManager.getConnection();
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 投稿データ一覧を取得する.<br>
	 *
	 * データベースより投稿データを全て取得し、
	 * 投稿リストへ格納する。
	 *
	 * @return 投稿データの一覧
	 */
	public static ArrayList<Contribution> getList() {

		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBManager.getConnection();
			statement = connection.createStatement();
			String sql = MakeSQL.makeList();
			ResultSet rSet = statement.executeQuery(sql);
			ArrayList<Contribution> list = new ArrayList<Contribution>();

			while(rSet.next()) {
				Contribution contribution = new Contribution();
				String name = rSet.getString("name");

				/* 名前が入力されていた場合登録、されていない場合名無しと登録 */
				if (name.equals("")) {
					name = "名無し";
				}
				contribution.setName(name);
				contribution.setMail(rSet.getString("mail"));
				contribution.setTitle(rSet.getString("title"));
				String message = rSet.getString("message");
				message = converter.strConvertEscape(message);
				message = converter.strConvertIndention(message);
				contribution.setMessage(message);
				contribution.setId(rSet.getString("ID"));
				contribution.setPassword(rSet.getString("password"));

				SimpleDateFormat dateFormatter
					= new SimpleDateFormat("yyyy/M/d/ (E) HH:mm:ss");
				String nowTime = dateFormatter.format(rSet.getTimestamp("postingtime"));
				contribution.setPosttime(nowTime);
				list.add(contribution);
			}
			statement.close();
			connection.close();
			return list;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 1レコードを取得し、データの整形をする.
	 *
	 * @param id ID
	 * @return 投稿データ
	 */
	public static Contribution getContribution(String id) {

		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBManager.getConnection();
			statement = connection.createStatement();
			String sql = MakeSQL.selectOneData(id);
			ResultSet rSet = statement.executeQuery(sql);
			rSet.next();
			Contribution contribution = new Contribution();
			String name = rSet.getString("name");

			/* 名前が入力されていた場合登録、されていない場合名無しと登録 */
			if (name.equals("")) {
				name = "名無し";
			}
			contribution.setName(name);
			contribution.setMail(rSet.getString("mail"));
			contribution.setTitle(rSet.getString("title"));

			/* 本文のサニタイズ */
			String message = rSet.getString("message");
			message = converter.strConvertEscape(message);

			/* 改行文字を<br>に変換 */
			message = converter.strConvertIndention(message);
			contribution.setMessage(message);
			contribution.setId(rSet.getString("ID"));
			contribution.setPassword(rSet.getString("password"));
			SimpleDateFormat dateFormatter
				= new SimpleDateFormat("yyyy/M/d/ (E) HH:mm:ss");
			String nowTime = dateFormatter.format(rSet.getTimestamp("postingtime"));
			contribution.setPosttime(nowTime);

			statement.close();
			connection.close();
			return contribution;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 1レコードを未整形で取得する.
	 *
	 * @param id ID
	 * @return 投稿データ
	 */
	public static Contribution getPlainContribution(String id) {

		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBManager.getConnection();
			statement = connection.createStatement();
			String sql = MakeSQL.selectOneData(id);
			ResultSet rSet = statement.executeQuery(sql);
			rSet.next();
			Contribution contribution = new Contribution();
			contribution.setName(rSet.getString("name"));
			contribution.setMail(rSet.getString("mail"));
			contribution.setTitle(rSet.getString("title"));
			contribution.setMessage(rSet.getString("message"));
			contribution.setId(rSet.getString("ID"));
			contribution.setPassword(rSet.getString("password"));

			statement.close();
			connection.close();
			return contribution;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
}