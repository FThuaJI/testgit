package myluntan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import myluntan.User;

public class UserDao {
	public 	User login(String username, String password){ 
		User user = null; 
		Connection conn = DataBase.getConnection(); 
		
		try { 
			Statement stm=(Statement) conn.createStatement();
			String sql1="select * from user where 用户名='"+ username + "' and 密码='" + password + "'";
			ResultSet rs=stm.executeQuery(sql1);
			rs.beforeFirst();
			boolean isok=false;
			while(rs.next()){ 
				String n=rs.getString(1);
				String p=rs.getString(2);
				if(username.equals(n)&&password.equals(p)) {
					isok=true;
				}else {
					isok=false;
				}
				user = new User(); 
				user.setUsername(n); 
			}
			if(isok) {
				System.out.println("登录成功");
			}else {
				System.out.println("失败");
			}
			//
			rs.close(); 
			stm.close(); 
			} catch (Exception e) {
				e.printStackTrace(); 
				}finally{
		          
		            DataBase.closeConnection(conn);
		        }
		return user;
	}
	
	public void addUser(String username,String password){
		
	}
	
}
	
	

