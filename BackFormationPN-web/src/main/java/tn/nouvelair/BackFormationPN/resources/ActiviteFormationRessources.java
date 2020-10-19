package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.Interfaces.ActiviteFormationServiceRemote;
import tn.nouvelair.BackFormationPN.entities.*;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("activiteFormation")
@RequestScoped
public class ActiviteFormationRessources {
    @EJB
    ActiviteFormationServiceRemote metier;


    ///// formation

    @GET
    @Path("/formation/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFormations(){

        return Response.ok(metier.GetFormations()).build();
    }

    @GET
    @Path("/formation/PNT/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFormationsPNT(){

        return Response.ok(metier.GetFormationsPNT()).build();
    }


    @GET
    @Path("/formation/PNC/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFormationsPNC(){

        return Response.ok(metier.GetFormationsPNC()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/formation/delete/{id}")
    public Response deleteFormation (@PathParam (value = "id") int id)
    {

        metier.deleteFormation(id);
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/formation/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterFormation(Formation formation) {
        metier.AjouterFormation(formation);

        return Response.status(Response.Status.CREATED).entity(formation).build();

    }


    @POST
    @Path("/formation/PNT/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterFormationPNT(Formation formation) {
        metier.AjouterFormationPNT(formation);

        return Response.status(Response.Status.CREATED).entity(formation).build();

    }


    @POST
    @Path("/formation/PNC/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterFormationPNC(Formation formation) {
        metier.AjouterFormationPNC(formation);

        return Response.status(Response.Status.CREATED).entity(formation).build();

    }


    @PUT
    @Path("/formation/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateFormation(@PathParam (value = "id") int id, Formation formation) {
        metier.UpdateFormation(formation);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok(formation).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/formation/detail/{id}")
    public Response getFormationById (@PathParam (value = "id") int id)
    {

        return Response.ok(metier.getFormationById(id)).build() ;
    }

    @GET
    @Path("/formation/instructions/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInstructionsByFormation(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectInstructionsByActiviteFormation(id)).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/formation/delete/instruction/{idActivite}/{idUser}")
    public Response deleteFormation (@PathParam (value = "idActivite") int idActivite, @PathParam (value = "idUser") int idUser)
    {

        metier.deleteInstructionByActiviteAndUser(idActivite,idUser);
        return Response.status(Status.OK).build() ;
    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/formation/delete/seanceFormation/{idSeanceFormation}")
    public Response deleteSeanceFormation (@PathParam (value = "idSeanceFormation") int idSeanceFormation)
    {
        metier.deleteSeanceFormation(idSeanceFormation);
        return Response.status(Status.OK).build() ;
    }


    ///// simulateur





    @GET
    @Path("/simulateur/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSimulateurs(){

        return Response.ok(metier.GetSimulateurs()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/simulateur/delete/{id}")
    public Response deleteSimulateur (@PathParam (value = "id") int id)
    {

        metier.deleteSimulateur(id);
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/simulateur/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterSimulateur(Simulateur simulateur) {
        metier.AjouterSimulateur(simulateur);

        return Response.status(Response.Status.CREATED).entity(simulateur).build();

    }


    @PUT
    @Path("/simulateur/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateSimulateur(@PathParam (value = "id") int id, Simulateur simulateur) {
        metier.UpdateSimulateur(simulateur);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok(simulateur).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/simulateur/detail/{id}")
    public Response getSimulateurById (@PathParam (value = "id") int id)
    {

        return Response.ok(metier.getSimulateurById(id)).build() ;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/simulateur/delete/seanceSimulateur/{idSeanceSimulateur}")
    public Response deleteSeanceSimulateur (@PathParam (value = "idSeanceSimulateur") int idSeanceSimulateur)
    {
        metier.deleteSeanceSimulateur(idSeanceSimulateur);
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/formation/instruction/add/{idActiviteFormation}/{idUtilisateur}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AjouterInstruction(Instruction instruction, @PathParam (value = "idActiviteFormation") int idActiviteFormation, @PathParam (value = "idUtilisateur") int idUtilisateur) {
        metier.AjouterInstruction(instruction, idActiviteFormation, idUtilisateur);

        return Response.status(Response.Status.CREATED).entity(instruction).build();

    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/simulateur/seance/detail/{id}")
    public Response getSeanceSimulateurById (@PathParam (value = "id") int id)
    {

        return Response.ok(metier.getSeanceSimulateurById(id)).build() ;
    }


    @GET
    @Path("/simulateur/notes/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotesBySeanceSimulateur(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectNotesBySeanceSimulateur(id)).build();
    }

    @GET
    @Path("/simulateur/levels/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLevelsBySeanceSimulateur(@PathParam (value = "id") int id){

        return Response.ok(metier.SelectLevelsBySeanceSimulateur(id)).build();
    }

    @POST
    @Path("/simulateur/level/add/{idSeanceSimulateur}/{idTache}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AjouterLevel(Level level, @PathParam (value = "idSeanceSimulateur") int idSeanceSimulateur, @PathParam (value = "idTache") int idTache) {
        metier.AjouterLevel(level, idSeanceSimulateur, idTache);

        return Response.status(Response.Status.CREATED).entity(level).build();

    }
    @POST
    @Path("/simulateur/note/add/{idSeanceSimulateur}/{idCompetence}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AjouterNote(Note note, @PathParam (value = "idSeanceSimulateur") int idSeanceSimulateur, @PathParam (value = "idCompetence") int idCompetence) {
        metier.AjouterNote(note, idSeanceSimulateur, idCompetence);

        return Response.status(Response.Status.CREATED).entity(note).build();

    }


    @PUT
    @Path("/simulateur/validation/instructor/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ValiderInstructeurSimuulateur(@PathParam (value = "id") int id, SeanceSimulateur seanceSimulateur) {
        metier.ValiderInstructeurSimuulateur(seanceSimulateur);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok(seanceSimulateur).build();
    }


    @PUT
    @Path("/simulateur/validation/trainee/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ValiderTraineeSimuulateur(@PathParam (value = "id") int id, SeanceSimulateur seanceSimulateur) {
        metier.ValiderTraineeSimuulateur(seanceSimulateur);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok(seanceSimulateur).build();
    }

    @PUT
    @Path("/simulateur/reclamer/trainee/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ReclamerTraineeSimuulateur(@PathParam (value = "id") int id, SeanceSimulateur seanceSimulateur) {
        metier.ReclamerTraineeSimuulateur(seanceSimulateur);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok(seanceSimulateur).build();
    }

    @GET
    @Path("/simulateur/instructor/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSimulateurInstructor(@PathParam (value = "id") int id){

        return Response.ok(metier.getSeanceSimulateurInstructor(id)).build();
    }

    @GET
    @Path("/simulateur/trainee/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSimulateurTrainee(@PathParam (value = "id") int id){

        return Response.ok(metier.getSeanceSimulateurTrainee(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/simulateur/seance/simulateur/{id}")
    public Response GetSimulateurBySeanceSimulateur (@PathParam (value = "id") int id)
    {

        return Response.ok(metier.getSimulateurBySeanceSimulateur(id)).build() ;
    }


}
