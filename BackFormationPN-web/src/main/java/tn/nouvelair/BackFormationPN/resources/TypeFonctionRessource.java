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
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterTypeFonction(TypeFonction typeFonction) {
        metier.AjouterTypeFonction(typeFonction);

        return Response.status(Response.Status.CREATED).entity(typeFonction).build();

    }


    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateTypeFonction(@PathParam (value = "id") int id,TypeFonction typeFonction) {
        metier.UpdateTypeFonction(typeFonction);
        Response.status(Status.CREATED).entity(typeFonction).build();
        return Response.ok(typeFonction).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/detail/{id}")
    public Response getTypeFonctionById (@PathParam (value = "id") int id)
    {

        return Response.ok(metier.getTypeFonctionById(id)).build() ;
    }

}
