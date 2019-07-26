package reply;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myluntan.DataBase;

public class ReplyDao {
	
	Connection conn=DataBase.getConnection();
	
	public List<Reply> getReply(String commentId){
		
		List<Reply> reply=new ArrayList<Reply>();
		try {
			Statement stm = (Statement) conn.createStatement();
			String sql1="select * from reply where commentId='"+commentId+"'";
			ResultSet rs=stm.executeQuery(sql1);
			rs.beforeFirst();
			while(rs.next()){
				Reply c=new Reply();
				c.setReplyId(rs.getInt(1));
				c.setRepContent(rs.getString(2));
				c.setRepTime(rs.getString(3));
				c.setRepName(rs.getString(4));
				c.setCommentId(rs.getInt(5));
				reply.add(c);
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataBase.closeConnection(conn);
		}
		return reply;
		
	}
}
