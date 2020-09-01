package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.TypeFonction;
import tn.nouvelair.BackFormationPN.Interfaces.TypeFonctionServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("typeFonction")
@RequestScoped
public class TypeFonctionRessource {
    @EJB
    TypeFonctionServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypeFonctions(){

        return Response.ok(metier.GetTypeFonctions()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteTypeFonction (@PathParam (value = "id") int id)
    {

        metier.deleteTypeFonction(id);
        return Response.status(Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterTypeFonction(TypeFonction typeFonction) {
        metier.AjouterTypeFonction(typeFonction);

        return Response.status(Response.Status.CREATED).entity("success").build();

    }


    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateTypeFonction(@PathParam (value = "id") int id,TypeFonction typeFonction) {
        metier.UpdateTypeFonction(typeFonction);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }
}
