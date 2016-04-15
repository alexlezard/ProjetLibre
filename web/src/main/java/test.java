import java.sql.SQLException;

import com.web.controller.ListeController;
import com.web.db.DbManager;
import com.web.model.Category;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Key;
import io.jsonwebtoken.*;

import java.util.ArrayList;
import java.util.Date;

public class test {
	
	   public static void main (String[] args){
		   DbManager dbman 	= new DbManager();
		   Category cat 	= new Category();
		   
		   cat.setIdcategory(6);
		   cat.setName(" Automobile ferrari ");
		   cat.setUser_iduser(11);
		   
		   ArrayList list = new ArrayList();
		   //dbman.InsertCategory(cat);
		   //dbman.UpdateCategory(cat);
		   //dbman.getCategory("INDIA");
		   
		   ListeController lc = new ListeController();
		   
		   
	   }
	   
}
