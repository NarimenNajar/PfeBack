package tn.nouvelair.BackFormationPN.services;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.nouvelair.BackFormationPN.Interfaces.UtilisateurServiceRemote;
import tn.nouvelair.BackFormationPN.entities.*;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;


@Stateless
@LocalBean
public class UtilisateurService implements UtilisateurServiceRemote {

    public static Utilisateur userConnected = new Utilisateur();


    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;


    @Override
    public void AjouterUtilisateur(Utilisateur utilisateur) {
        utilisateur.setConfirmation("1");
       // utilisateur.setEnabled(true);
        String keyString = "secretkey";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        System.out.println("the key is : " + key.hashCode());
/*
        String jwtToken = Jwts.builder()
                .setSubject(utilisateur.getCodePN())
                .setIssuer("Nari")
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusYears(20L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        utilisateur.setConfirmationToken(jwtToken);

        System.out.println("the returned token is : " + jwtToken);*/
        em.persist(utilisateur);
    }

    @Override
    public Utilisateur getUserByEmailAndPassword(String codePN, int cin) {
        TypedQuery<Utilisateur> query = em.createQuery("Select p from Utilisateur p  "
                        +"where p.codePN=:codePN and "
                        +"p.cin=:cin"
                , Utilisateur.class);

        query.setParameter("codePN",codePN);
        query.setParameter("cin",cin);

        Utilisateur user = null ;

        try {
            user = query.getSingleResult();
        } catch (NoResultException p ) {
            Logger.getAnonymousLogger().info("Aucun utilisateur trouvé avec login :" + codePN);
        }
        return user;
    }

    @Override
    public List<Utilisateur> GetUsers() {
        List<Utilisateur> users=null;
        TypedQuery<Utilisateur> query = em.createQuery("Select e from Utilisateur e "
                , Utilisateur.class);
        try {
            users = query.getResultList();
        } catch (NoResultException e ) {

        }
        return users;


    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        em.merge(utilisateur);

    }

    @Override
    public List<Utilisateur> SelectUsersByCategorie(Integer idCategorie) {

        List<Utilisateur> users=null;
        TypedQuery<Utilisateur> query = em.createQuery("Select e from Utilisateur e where e.categorie="+idCategorie
                , Utilisateur.class);
        try {
            users = query.getResultList();
        } catch (NoResultException e ) {

        }
        return users;

    }

    @Override
    public List<Utilisateur> SelectUsersByRole(Integer idRole) {

        List<Utilisateur> users=null;
        TypedQuery<Utilisateur> query = em.createQuery("Select e from Utilisateur e where e.role="+idRole
                , Utilisateur.class);
        try {
            users = query.getResultList();
        } catch (NoResultException e ) {

        }
        return users;

    }

    @Override
    public void deleteUser(int idUser) {
        em.remove(em.find(Utilisateur.class, idUser));

    }

    @Override
    public Utilisateur getUtilisateurById(int idUtilisateur){
        return em.find(Utilisateur.class, idUtilisateur);

    }


    @Override
    public List<Instruction> SelectInstructionsByUser(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur
                , Instruction.class);
        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }
    @Override
    public Instruction SelectInstructionsByActiviteAsTrainee(Integer idActivite) {

        List<Instruction> instructions=null;
        Instruction instruction = null ;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.activiteFormation="+idActivite +"and e.position like 'Trainee'"
                , Instruction.class);


        try {
            instruction = query.getSingleResult();
        } catch (NoResultException e ) {

        }
        return instruction;
    }

    @Override
    public Instruction SelectInstructionsByActiviteAsInstructor(Integer idActivite) {

        List<Instruction> instructions=null;
        Instruction instruction = null ;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.activiteFormation="+idActivite +"and e.position like 'Instructor'"
                , Instruction.class);


        try {
            instruction = query.getSingleResult();
        } catch (NoResultException e ) {

        }
        return instruction;
    }
    @Override
    public List<Instruction> SelectInstructionsByInstructor(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.position like 'Instructor'"
                , Instruction.class);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }

    @Override
    public List<Instruction> SelectInstructionsByTrainee(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.position like 'Trainee'"
                , Instruction.class);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }

    @Override
    public List<Instruction> SelectArchiveInstructions(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur  +"and e.activiteFormation.dateFinActivite < current_date "
                , Instruction.class);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }
    @Override
    public List<Instruction> SelectTodayInstructions(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.activiteFormation.dateFinActivite = current_date "
                , Instruction.class);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;
    }
    @Override
    public List<Instruction> SelectTodayInstructionsTrainee(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.position like 'Trainee'" +"and e.activiteFormation.dateFinActivite = current_date "
                , Instruction.class);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }

    @Override
    public List<Instruction> SelectTodayInstructionsInstructor(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.position like 'Instructor'" +"and e.activiteFormation.dateFinActivite = current_date "
                , Instruction.class);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }


    @Override
    public List<Instruction> SelectAlerteMyInstructionsEcheance(Integer idUtilisateur) {
        Date d = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 3);
        Date dateNowPlusThreeDays = c.getTime();

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.dateEch <= :dateNowPlusThreeDays"
                , Instruction.class);
        query.setParameter("dateNowPlusThreeDays", dateNowPlusThreeDays);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }
    @Override
    public List<Instruction> SelectAlerteAllInstructionsEcheance() {
        Date d = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 3);
        Date dateNowPlusThreeDays = c.getTime();

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.dateEch <= :dateNowPlusThreeDays"
                , Instruction.class);
        query.setParameter("dateNowPlusThreeDays", dateNowPlusThreeDays);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }
    @Override
    public List<Instruction> SelectAlerteMyInstructionsFinTolerEcheance(Integer idUtilisateur) {
        Date d = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 3);
        Date dateNowPlusThreeDays = c.getTime();

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.dateFinToler <= :dateNowPlusThreeDays"
                , Instruction.class);
        query.setParameter("dateNowPlusThreeDays", dateNowPlusThreeDays);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }
    @Override
    public List<Instruction> SelectAlerteAllInstructionsFinTolerEcheance() {
        Date d = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 3);
        Date dateNowPlusThreeDays = c.getTime();

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.dateFinToler <= :dateNowPlusThreeDays"
                , Instruction.class);
        query.setParameter("dateNowPlusThreeDays", dateNowPlusThreeDays);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }

    @Override
    public List<Fonction> SelectFonctionsByUser(Integer idUtilisateur) {

        List<Fonction> fonctions=null;
        TypedQuery<Fonction> query = em.createQuery("Select e from Fonction e where e.utilisateur="+idUtilisateur
                , Fonction.class);
        try {
            fonctions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return fonctions;

    }

    @Override
    public List<Fonction> SelectArchiveFonctions(Integer idUtilisateur) {

        List<Fonction> fonctions=null;
        TypedQuery<Fonction> query = em.createQuery("Select e from Fonction e where e.utilisateur="+idUtilisateur +"and e.dateFin < current_date "
                , Fonction.class);

        try {
            fonctions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return fonctions;

    }

    @Override
    public List<Fonction> SelectCurrentFonctions(Integer idUtilisateur) {

        List<Fonction> fonctions=null;
        TypedQuery<Fonction> query = em.createQuery("Select e from Fonction e where e.utilisateur="+idUtilisateur +"and e.dateFin >= current_date "
                , Fonction.class);

        try {
            fonctions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return fonctions;

    }
    @Override
    public boolean login(Utilisateur u) throws Exception {

        //String encode = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
        //System.out.println("encode: " + encode);
        //System.out.println("Login from service : " + u);
        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.codePN = :codePN "
                + "AND u.cin = :cin");
        query.setParameter("codePN", u.getCodePN());
        query.setParameter("cin", u.getCin());
        // query.setParameter("password", decode);
        int resultCount = query.getResultList().size();
        System.out.println("Found " + resultCount + " Result(s) ");
        if (resultCount != 1) {
            return false;
        } else {
            Utilisateur user = (Utilisateur) query.getResultList().get(0);
            user.setEnabled(true);
            user.setLastLogin(new java.util.Date());
            em.flush();
            userConnected = user;


            System.out.println(userConnected.getRole());
            return true;
        }

    }

    @Override
    public boolean logout() {
        if (userConnected.isEnabled()) {
            Utilisateur user = em.find(Utilisateur.class, userConnected.getId());
            user.setEnabled(false);
            em.flush();
            userConnected = new Utilisateur();
            System.out.println("logged out");
            return true;
        } else
            return false;
    }

    @Override
    public Utilisateur getUserByCodePN(String codePN) {
        try {
            Utilisateur user = (Utilisateur) em.createQuery("SELECT user FROM Utilisateur user WHERE user.codePN = :codePN")
                    .setParameter("codePN", codePN)
                    .getSingleResult();
            return user;

        } catch (javax.persistence.NoResultException exp) {
            return null;
        }
    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

    }


}
