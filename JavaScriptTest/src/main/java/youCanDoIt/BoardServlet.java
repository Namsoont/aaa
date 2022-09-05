package youCanDoIt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
@WebServlet("/BoardList")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		// 조회의 기능 구현.
		BoardDAO dao = BoardDAO.getInstance();
		List<Board> list = dao.getBoardList();
		JsonArray ary = new JsonArray();
		for (Board bno : list) {
			JsonObject obj = new JsonObject();
			obj.addProperty("bno", bno.getBno());
			obj.addProperty("title", bno.getTitle());
			obj.addProperty("content", bno.getContent());
			obj.addProperty("writer", bno.getWriter());
			obj.addProperty("creation_date", bno.getCreationDate());
			
			
			ary.add(obj);
		}
		Gson gson = new GsonBuilder().create();
		
		String json = gson.toJson(ary);
		
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		// 추가, 삭제의 기능을 구현.
		
		String a = request.getParameter("a");
		if (a.equals("insert")) {
			Board dd = new Board();
			dd.setTitle(request.getParameter("title"));
			dd.setWriter(request.getParameter("Writer"));
			dd.setContent(request.getParameter("Content"));
			dd.setBno(1);
			BoardDAO dao = BoardDAO.getInstance();
			if (dao.insertBoard(dd)) {
				response.getWriter().print("success");
			} else {
				response.getWriter().print("fail");
			}
			

		} else if (a.equals("delete")) {
			
			Board dd = new Board();
//			dd.setBno(request.getInt("Bno"));
			dd.setTitle(request.getParameter("title"));
			dd.setWriter(request.getParameter("Writer"));
			dd.setContent(request.getParameter("Content"));
			BoardDAO dao = BoardDAO.getInstance();
			if (dao.insertBoard(dd)) {
				response.getWriter().print("success");
			} else {
				response.getWriter().print("fail");
			}
		}
	}
}

	


