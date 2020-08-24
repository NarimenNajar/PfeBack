package tn.nouvelair.BackFormationPN.resources;

import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Exercice;
import tn.nouvelair.BackFormationPN.services.CategorieServiceRemote;
import tn.nouvelair.BackFormationPN.services.ExerciceServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("exercice")
@RequestScoped
public class ExerciceRessource {
    @EJB
    ExerciceServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExercices(){

        return Response.ok(metier.GetExercices()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteExercice (@PathParam (value = "id") int id)
    {

        metier.deleteExercice(id);
        return Response.status(Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterExercice(Exercice exercice) {
        metier.AjouterExercice(exercice);

        return Response.status(Response.Status.CREATED).entity("success").build();


    }


    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateExercice(@PathParam (value = "id") int id,Exercice exercice) {
        metier.UpdateExercice(exercice);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }
}
