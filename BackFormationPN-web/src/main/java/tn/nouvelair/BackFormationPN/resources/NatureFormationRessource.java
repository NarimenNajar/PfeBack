package tn.nouvelair.BackFormationPN.resources;

import tn.nouvelair.BackFormationPN.entities.NatureFormation;
import tn.nouvelair.BackFormationPN.Interfaces.NatureFormationServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("natureFormation")
@RequestScoped
public class NatureFormationRessource {
    @EJB
    NatureFormationServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNatureFormations(){

        return Response.ok(metier.GetNatureFormations()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteNatureFormation (@PathParam (value = "id") int id)
    {

        metier.deleteNatureFormation(id);
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterNatureFormation(NatureFormation natureFormation) {
        metier.AjouterNatureFormation(natureFormation);

        return Response.status(Response.Status.CREATED).entity(natureFormation).build();

    }


    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateNatureFormation(@PathParam (value = "id") int id,NatureFormation natureFormation) {
        metier.UpdateNatureFormation(natureFormation);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok(natureFormation).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/detail/{id}")
    public Response getNatureFormationyId (@PathParam (value = "id") int id)
    {

        return Response.ok(metier.getNatureFormationById(id)).build() ;
    }
}
