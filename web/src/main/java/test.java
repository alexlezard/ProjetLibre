import java.sql.SQLException;

import com.web.db.DbManager;

public class test {
	
	   public static void main (String[] args){
		    System.out.println("Dbmanager ------>");
		    
		   
		    try {
				DbManager.getInstance().selectRecordsFromTable("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	   
}
