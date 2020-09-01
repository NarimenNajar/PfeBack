package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.Population;
import tn.nouvelair.BackFormationPN.Interfaces.PopulationServiceRemote;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("population")
public class PopulationRessource {
    @EJB
    PopulationServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPopulations(){

        return Response.ok(metier.GetPopulations()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deletePopulation (@PathParam (value = "id") int id)
    {

        metier.deletePopulation(id);
        return Response.status(Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterPopulation(Population population) {
        metier.AjouterPopulation(population);

        return Response.status(Response.Status.CREATED).entity("success").build();

    }

    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdatePopulation(@PathParam (value = "id") int id,Population population) {
        metier.UpdatePopulation(population);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }



}
