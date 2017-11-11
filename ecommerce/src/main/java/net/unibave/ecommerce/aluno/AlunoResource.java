package net.unibave.ecommerce.aluno;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Stateless
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("alunos")
public class AlunoResource {

    @PersistenceContext(unitName = "unibavePU")
    private EntityManager em;

    @GET
    public List<Aluno> findAll() {

        List alunos = em.createQuery("FROM Aluno a ORDER BY a.id").getResultList();

        return alunos;
    }


}
