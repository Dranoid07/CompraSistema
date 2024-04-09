import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xhtml");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/compraSistema";
            String Username = "postgres";
            String Password = "francisco0713";
            Connection con = DriverManager.getConnection(url, Username, Password);
           
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from login where username='"+username+"' and password='"+password+"'");
            
            if(rs.next()) {
                response.sendRedirect("faces/index.xhtml");
            } else {
                out.println("Wrong username and password...");
            }
            
            con.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

