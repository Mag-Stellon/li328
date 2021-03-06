package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.SearchWithoutQueryFriendServices;


import com.mongodb.MongoException;

/**
 * Servlet impl�mentant la class SearchWithoutQueryFriendServlet
 * @author Mag-stellon Nadarajah & Kamalraj Muruganathan
 *
 */
public class SearchWithoutQueryFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * M�thode qui recueille les informations entr�es par l'utilisateur sur le formulaire.
	 * @param request Interface pour fournir des informations pour les servlets HTTP demand�s.
	 * @param reponse Interface HTTP pour fournir des fonctionnalités spécifiques à l'envoi d'une réponse.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,String[]> map = request.getParameterMap();
		response.setContentType("application/json");


		// Recupere la hashmap de l'URL et on ouvre  la reponse
		PrintWriter out = response.getWriter();

		// Creation service CreateUser
		SearchWithoutQueryFriendServices cus = new SearchWithoutQueryFriendServices(map);

		// Recuperation des JSONs et des tests
		List<JSONObject> success = null;
		try {
			success=cus.isSuccess();
			out.print(success);

		}catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("MongoException :\n"+e.getMessage());
		} 
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("UnknownHostException :\n"+e.getMessage());
		} 
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("JSONException :\n"+e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("SQLException :\n"+e.getMessage());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("ClassNotFoundException :\n"+e.getMessage());
		}




	}

}
