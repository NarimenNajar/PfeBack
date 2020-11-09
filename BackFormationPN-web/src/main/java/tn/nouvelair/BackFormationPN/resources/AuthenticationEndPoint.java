package tn.nouvelair.BackFormationPN.resources;

import tn.nouvelair.BackFormationPN.entities.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Path("authentication")
public class AuthenticationEndPoint {
    // ======================================
    // = Injection Points =
    // ======================================
    ContainerRequestContext requestContext;
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Context
    private UriInfo uriInfo;

    @POST
    @Produces(MediaType.TEXT_PLAIN)

    public Response authenticateUser(@QueryParam(value = "username") String username, @QueryParam(value = "password") String password) {
        try {

            // Authenticate the user using the credentials provided
            authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(String username, String password) {
        System.out.println("Authenticating user...");
        try {
            System.out.println("username : " + username + " / password : " + password);
           // String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
            int count = em.createQuery("SELECT usr FROM Utilisateur usr WHERE usr.codePN =:username AND usr.cin = :password AND usr.enabled = true")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getResultList().size();
            if (count == 0)
                throw new IllegalArgumentException("informations invalidd");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("informations invalidd");
        }

    }


    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token

        Utilisateur user = (Utilisateur) em.createQuery("SELECT usr FROM Utilisateur usr WHERE usr.codePN = :username")
                .setParameter("username", username)
                .getSingleResult();
        return user.getConfirmationToken();

    }
    // ======================================
    // = Private methods =
    // ======================================

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

    }

}
