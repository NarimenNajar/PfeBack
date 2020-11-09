package tn.nouvelair.BackFormationPN.resources;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.nouvelair.BackFormationPN.Interfaces.UtilisateurServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;


@Path("users")
@RequestScoped
public class UtilisateurRessource {
    @EJB
    UtilisateurServiceRemote metier;
    @GET
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signInWithEmail(@QueryParam("codePN") String codePN, @QueryParam("cin") int cin) {
        if (metier.getUserByEmailAndPassword(codePN, cin).getCodePN().equals(codePN)&&
                (metier.getUserByEmailAndPassword(codePN, cin).getCin()==cin)) {
            //return Response.status(200).build();
            return Response.ok(metier.getUserByEmailAndPassword(codePN, cin)).build();
        }
        return Response.status(401).entity("Login or Password unvalid !").build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(){

        return Response.ok(metier.GetUsers()).build();
    }


    @GET
    @Path("/usersByCatergorie")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response SelectUsersByCategorie(@QueryParam("categorie") Integer idCategorie){

        return Response.ok(metier.SelectUsersByCategorie(idCategorie)).build();
    }

    @GET
    @Path("/usersByRole")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response SelectUsersByRole(@QueryParam("role") Integer idRole){

        return Response.ok(metier.SelectUsersByRole(idRole)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteUser/{id}")
    public Response deleteUser (@PathParam (value = "id") int id)
    {

        metier.deleteUser(id);
        return Response.status(Status.OK).build() ;
    }

    @POST
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterUtilisateur(Utilisateur utilisateur) {
        metier.AjouterUtilisateur(utilisateur);

        return Response.status(Response.Status.CREATED).entity(utilisateur).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/detail/{id}")
    public Response getUtilisateurById (@PathParam (value = "id") int id)
    {

        //metier.getSyllabusById(id);
        return Response.ok(metier.getUtilisateurById(id)).build() ;
    }

    @GET
    @Path("/instructions/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInstructionsByUser(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectInstructionsByUser(id)).build();
    }
    @GET
    @Path("/instructions/archive/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArchiveInstructionByUser(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectArchiveInstructions(id)).build();
    }


    @GET
    @Path("/instructions/instructor/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInstructionsByInstructor(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectInstructionsByInstructor(id)).build();
    }


    @GET
    @Path("/instructions/trainee/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInstructionsByTrainee(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectInstructionsByTrainee(id)).build();
    }

    @GET
    @Path("/fonctions/all/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFonctionsByUser(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectFonctionsByUser(id)).build();
    }

    @GET
    @Path("/fonctions/archive/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArchiveFonctionsByUser(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectArchiveFonctions(id)).build();
    }
    @GET
    @Path("/fonctions/current/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurrentFonctionsByUser(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectCurrentFonctions(id)).build();
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/auth")
    public Response authenticateUser(Utilisateur u) throws Exception {
        System.out.println("done");
        // Authenticate the user using the credentials provided
        if (authenticate(u) == false) {
            System.out.println("Auth failed, Exiting with FORBIDDEN status");
            return Response.status(Response.Status.FORBIDDEN).entity("Authentification failed !").build();
        }
        System.out.println("Authentification passed!");
        //User user = userServiceLocal.findUser(u);
        //String token = issueToken(user);
        //System.out.println("Our token is now : "+token);

        //   return Response.ok(token).header("Authorization", token).build();
        Utilisateur us=metier.getUserByCodePN(u.getCodePN());
        us.setConfirmation("");
        us.setCin(0);
        // return Response.ok(us).build();
        return Response.ok(us).build();
    }


    private boolean authenticate(Utilisateur u) throws Exception {
        if (metier.login(u) == false)
            return false;
        return true;
    }



    @Path("/logOut")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response logOut() {
        //  return Response.ok(userService.logOut(idUser)).build();
        boolean x = metier.logout();
        if (x == true)
            return Response.ok().build();
        else return Response.status(Response.Status.FORBIDDEN).build();
    }
}
