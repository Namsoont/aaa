package youCanDoIt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BoardDAO extends DAO {
	private static BoardDAO bb = new BoardDAO();
	private BoardDAO() {
		
	}
	public static BoardDAO getInstance( ) {
		return bb;
	}
	
	public List<Board> getBoardList() {
		String sql = "select * from tbl_board";
		conn();
		List<Board> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board bod = new Board();
				bod.setBno(rs.getInt("Bno"));
				bod.setTitle(rs.getString("title"));
				bod.setContent(rs.getString("Content"));
				bod.setWriter(rs.getString("Writer"));
				bod.setCreationDate(rs.getString("Creation_Date"));
				
				list.add(bod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteBoard(Board bb) {
		conn();
	      String sql = "delete from my_calendar where title=?and CreationDate=?";
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, bb.getTitle());
	         pstmt.setString(2, bb.getWriter());
	         pstmt.setString(3, bb.getContent());
	         
	         
	         int r = pstmt.executeUpdate();
	         if (r > 0) {
	            return true;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return false;
	   }
	

	public boolean insertBoard(Board bb) {
		String sql = "insert into tbl_board values(?,?,?)";
		conn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bb.getTitle());
			pstmt.setString(2, bb.getContent());
			pstmt.setString(3, bb.getWriter());
			int r = pstmt.executeUpdate();
			if (r > 0) 
				return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
}
