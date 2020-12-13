package tn.nouvelair.BackFormationPN.resources;

import tn.nouvelair.BackFormationPN.entities.Partie;
import tn.nouvelair.BackFormationPN.Interfaces.PartieServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("partie")
@RequestScoped
public class PartieRessource {
    @EJB
    PartieServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParties(){

        return Response.ok(metier.GetParties()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deletePartie (@PathParam (value = "id") int id)
    {

        metier.deletePartie(id);
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterPartie(Partie partie) {
        metier.AjouterPartie(partie);

        return Response.status(Response.Status.CREATED).entity(partie).build();

    }


    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdatePartie(@PathParam (value = "id") int id,Partie partie) {
        metier.UpdatePartie(partie);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok(partie).build();
    }
}
