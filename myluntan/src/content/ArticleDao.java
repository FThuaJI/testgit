package content;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myluntan.DataBase;

public class ArticleDao {
	
	Connection conn=DataBase.getConnection();
	
	public List<Article> getArticle(){
	
		List<Article> article=new ArrayList<Article>();
	try {
		Statement stm=(Statement) conn.createStatement();
		String sql1="select * from content";
		ResultSet rs=stm.executeQuery(sql1);
		rs.beforeFirst();
		while(rs.next()) {
			Article a=new Article();
			a.setArticleId(rs.getInt(1));
			a.setTitle(rs.getString(2));
			a.setContent(rs.getString(3));
			a.setSendTime(rs.getString(4));
			a.setSenderName(rs.getString(5));
			article.add(a);
		}
		rs.close();
		stm.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return article;
	}
	
	public int ArticleToDay(){
		
		int x = 0;
		try {
			Statement stm = (Statement) conn.createStatement();
			String sql2="select count(*) from content";
			ResultSet rs=stm.executeQuery(sql2);
			if(rs.next()){
				x=rs.getInt(1);
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	public boolean addArticle(String title, String content, String sendTime, String senderName){
		
		boolean isok = false;
		try {
			Statement stm = (Statement) conn.createStatement();
			String sql3="insert into content(title,content,sendTime,senderName) value ('"+title+"','"+content+"','"+sendTime+"','"+senderName+"')";
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
		}
		return isok;
	}
	
	public List<Article> checkArticle(String title){
		
		List<Article> article=new ArrayList<Article>();
		try {
			Statement stm=(Statement) conn.createStatement();
			String sql1="select * from content where title like '%"+title+"%'";
			ResultSet rs=stm.executeQuery(sql1);
			rs.beforeFirst();
			while(rs.next()) {
				Article a=new Article();
				a.setArticleId(rs.getInt(1));
				a.setTitle(rs.getString(2));
				a.setContent(rs.getString(3));
				a.setSendTime(rs.getString(4));
				a.setSenderName(rs.getString(5));
				article.add(a);
			}
			rs.close();
			stm.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DataBase.closeConnection(conn);
		}
		return article;
		
	}
}
