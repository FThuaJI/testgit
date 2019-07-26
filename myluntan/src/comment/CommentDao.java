package comment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myluntan.DataBase;

public class CommentDao {
	
	Connection conn=DataBase.getConnection();
	
	public List<Comment> getComment(String articleId){
		
		List<Comment> comment=new ArrayList<Comment>();
		
		try {
			Statement stm = (Statement) conn.createStatement();
			String sql1="select * from comment where articleId='"+articleId+"'";
			ResultSet rs=stm.executeQuery(sql1);
			rs.beforeFirst();
			while(rs.next()){
				Comment c=new Comment();
				c.setCommentId(rs.getInt(1));
				c.setComContent(rs.getString(2));
				c.setComTime(rs.getString(3));
				c.setComName(rs.getString(4));
				c.setArticleId(rs.getInt(5));
				comment.add(c);
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comment;
	}
	
	public boolean addComment(String comcontent, String comTime, String comName, String articleId){
		boolean isok = false;
		try {
			Statement stm = (Statement) conn.createStatement();
			String sql3="insert into comment(comcontent,comTime,comName,articleId) value ('"+comcontent+"','"+comTime+"','"+comName+"','"+articleId+"')";
			int flag=stm.executeUpdate(sql3);
			if(flag!=0){
				isok=true;
			}else{
				isok=false;
			}
			stm.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataBase.closeConnection(conn);
		}
		return isok;
	}
	
	
}
