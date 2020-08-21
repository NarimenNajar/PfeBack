package tn.nouvelair.BackFormationPN.resources;

import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Fonctionnalite;
import tn.nouvelair.BackFormationPN.services.CategorieServiceRemote;
import tn.nouvelair.BackFormationPN.services.FonctionnaliteServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("fonctionnalite")
@RequestScoped
public class FonctionnaliteRessource {
    @EJB
    FonctionnaliteServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFonctionnalites(){

        return Response.ok(metier.GetFonctionnalites()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteFonctionnalite (@PathParam(value = "id") int id)
    {

        metier.deleteFonctionnalite(id);
        return Response.status(Response.Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterFonctionnalite(Fonctionnalite fonctionnalite) {
        metier.AjouterFonctionnalite(fonctionnalite);

        return Response.status(Response.Status.CREATED).entity("success").build();


    }


    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateFonctionnalite(@PathParam (value = "id") int id,Fonctionnalite fonctionnalite) {
        metier.UpdateFonctionnalite(fonctionnalite);
        Response.status(Response.Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }
}
