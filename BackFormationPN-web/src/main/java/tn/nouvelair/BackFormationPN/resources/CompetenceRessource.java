package tn.nouvelair.BackFormationPN.resources;

import tn.nouvelair.BackFormationPN.entities.Competence;
import tn.nouvelair.BackFormationPN.Interfaces.CompetenceServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("competence")
@RequestScoped
public class CompetenceRessource {
    @EJB
    CompetenceServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompetences(){

        return Response.ok(metier.GetCompetences()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteCompetence (@PathParam (value = "id") int id)
    {

        metier.deleteCompetence(id);
        return Response.status(Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterCompetence(Competence competence) {
        metier.AjouterCompetence(competence);

        return Response.status(Response.Status.CREATED).entity("success").build();

    }


    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateCompetence(@PathParam (value = "id") int id,Competence competence) {
        metier.UpdateCompetence(competence);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }
}
