package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.Interfaces.CategorieServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
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


    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateCategorie(@PathParam (value = "id") int id,Categorie categorie) {
        metier.UpdateCategorie(categorie);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }
}

