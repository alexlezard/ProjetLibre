import com.web.db.DbManager;

public class test {
	
	   public static void main (String[] args){
		    System.out.println("Dbmanager ------>");
		    
		   
		    DbManager.getInstance().dbConnect("SELECT * FROM projetlibre.user;");
		}
	   
}
