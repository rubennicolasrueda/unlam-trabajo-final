import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validar los datos (ejemplo básico)
        if (isValidUser(email, password)) {
            // Redirigir a la página de bienvenida si el login es exitoso
            response.sendRedirect("welcome.jsp");
        } else {
            // Enviar mensaje de error si falla
            response.setContentType("text/html");
            response.getWriter().write("<html><body><div style='color: red;'>Correo o contraseña incorrectos.</div></body></html>");
        }
    }

    // Método básico para validar el usuario (en un caso real deberías validar con una base de datos)
    private boolean isValidUser(String email, String password) {
        // Aquí debería ir la lógica de validación de los usuarios, por ejemplo, consultar una base de datos
        // Esto es solo un ejemplo para mostrar la validación
        String validEmail = "user@example.com";
        String validPassword = "123456";
        return email.equals(validEmail) && password.equals(validPassword);
    }
}
