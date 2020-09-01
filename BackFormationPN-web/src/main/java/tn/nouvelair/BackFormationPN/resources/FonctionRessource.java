package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.Fonction;
import tn.nouvelair.BackFormationPN.Interfaces.FonctionServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("fonction")
@RequestScoped
public class FonctionRessource {
    @EJB
    FonctionServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFonctions(){

        return Response.ok(metier.GetFonctions()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteFonction (@PathParam(value = "id") int id)
    {

        metier.deleteFonction(id);
        return Response.status(Response.Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterFonction(Fonction fonction) {
        metier.AjouterFonction(fonction);

        return Response.status(Response.Status.CREATED).entity("success").build();


    }


    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateFonction(@PathParam (value = "id") int id,Fonction fonction) {
        metier.UpdateFonction(fonction);
        Response.status(Response.Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }
}
