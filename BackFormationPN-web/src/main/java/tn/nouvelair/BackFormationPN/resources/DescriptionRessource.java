package tn.nouvelair.BackFormationPN.resources;

import tn.nouvelair.BackFormationPN.entities.Description;
import tn.nouvelair.BackFormationPN.Interfaces.DescriptionServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("description")
@RequestScoped
public class DescriptionRessource {
    @EJB
    DescriptionServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDescriptions(){

        return Response.ok(metier.GetDescriptions()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteDescription (@PathParam (value = "id") int id)
    {

        metier.deleteDescription(id);
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterDescription(Description description) {
        metier.AjouterDescription(description);

        return Response.status(Response.Status.CREATED).entity(description).build();
        //return Response.ok(metier.AjouterCategorie(categorie)).build();

    }


    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateDescription(@PathParam (value = "id") int id,Description description) {
        metier.UpdateDescription(description);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok(description).build();
    }
}
