package testapp;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class TestAppServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
		throws IOException {
		
		DatastoreService ds= DatastoreServiceFactory.getDatastoreService();
		
		//create an entity without identifier
		
		Entity plane = new Entity("Plane", 1);
		plane.setProperty("planeId", 1);
		plane.setProperty("brand", "Boeing");
		plane.setProperty("model", "737");
		plane.setProperty("capacity", 100);
		
		ds.put(plane);
		
		//create an entity with Identifier
		
		Entity user=new Entity("User", 415);
		user.setProperty("Userid", 415);
		user.setProperty("Username", "Kevin");
		user.setProperty("Password", "password");
		user.setProperty("Email", "kevin@mail.com");
		user.setProperty("Age", "35");
		
		ds.put(user);
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, welcome to GAE DATASTORE");
	}

}
