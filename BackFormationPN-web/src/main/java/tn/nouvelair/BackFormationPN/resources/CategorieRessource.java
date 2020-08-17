package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;
import tn.nouvelair.BackFormationPN.services.CategorieServiceRemote;
import tn.nouvelair.BackFormationPN.services.UtilisateurServiceRemote;

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

@Path("categorie")
@RequestScoped
public class CategorieRessource {
    @EJB
    CategorieServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories(){

        return Response.ok(metier.GetCategories()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteCategorie (@PathParam (value = "id") int id)
    {

        metier.deleteCategorie(id);
        return Response.status(Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/addCategorie")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterCategorie(Categorie categorie) {
        metier.AjouterCategorie(categorie);

        return Response.status(Response.Status.CREATED).entity("success").build();
        //return Response.ok(metier.AjouterCategorie(categorie)).build();

    }

}

