package graphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.RendezVous;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    private RendezVousRepository rendezVousRepository;
    public Querries (RendezVousRepository repoR){
        this.rendezVousRepository= repoR;

    }
    public List<RendezVous> getallrendezVous(){
        return this.rendezVousRepository.getListeRendezVous();
    }
}