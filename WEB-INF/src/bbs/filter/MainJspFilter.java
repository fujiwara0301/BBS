package bbs.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bbs.dbmanage.DBManager;
import bbs.entity.Contribution;

/**
 * 投稿一覧画面表示時の事前処理.
 *
 * @author Naoto Fujiwara
 */
public class MainJspFilter implements Filter {

	/**
	 * インスタンス生成時の初期処理.
	 *
	 * @param filterConfig フィルター設定
	 * @throws ServletException サーブレット実行時の例外
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * 事前処理を行う.
	 *
	 * データベースにアクセスし投稿一覧を取得する.また、セッションに保存されている投稿データを削除する.
	 *
	 * @param request 要求
	 * @param response 結果
	 * @param chain 他のフィルターから受け渡された情報
	 * @throws IOException 入出力時の例外
	 * @throws ServletException サーブレット実行時の例外
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		ArrayList<Contribution> list = DBManager.getList();
		HttpSession session = httpRequest.getSession();
		session.setAttribute("list", list);
		session.removeAttribute("targetData");
		chain.doFilter(request, response);
	}

	/**
	 * インスタンス破棄時の終了処理.
	 */
	public void destroy() {
	}
}
