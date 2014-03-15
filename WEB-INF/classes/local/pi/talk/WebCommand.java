package local.pi.talk;



import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebCommand
 */
public class WebCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebCommand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 要求文字コードのセット
		// 要求文字コードのセット
		req.setCharacterEncoding("utf-8");
		// 応答文字コードのセット
		res.setContentType("text/html; charset=utf-8");
		// 出力ストリームの取得
		PrintWriter out = res.getWriter();

		String title = "HTTP POST メソッド・デモ";

		// フォームデータの取得
		//String[] msg = new String[8];
		String str = req.getParameter("cmd");
		byte[] utf8 = str.getBytes("utf-8");
		String key = new String(utf8, "utf-8");
		//byte[] key = msg[0].getBytes("UTF-8");
		//String key = URLDecoder.decode(str,"utf-8");
		//String key = new String(msg[0].getBytes("ISO-8859-1"), "utf-8");
		
		// クライアント（ブラウザ）への出力
		out.println("<html lang=\"ja\">");
		out.println("<head><title>" + title + "</title>");
		out.println("</head><body>");
		out.println("<h1>" + title + "</h1>");
		out.println(key);
		out.println("<p><input type=\"button\" value=\"戻る\" onclick=\"history.back()\"></p> ");
		out.println("</body></html>");

		ExecutePiTalk pt = new ExecutePiTalk();
		try {
			pt.Talk(key);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 出力ストリームを閉じる
		out.close();
	}
}


