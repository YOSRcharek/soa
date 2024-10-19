package graphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.RendezVous;
import repository.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {
    private final RendezVousRepository rendezVousRepository;

    public Mutation(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    public RendezVous createRendezVous(int id, String date, String heure, int refLog, String numTel) {
        RendezVous rendezVous = new RendezVous(id, date, heure, rendezVousRepository.getLogementByRDV(refLog), numTel);
        if (rendezVousRepository.addRendezVous(rendezVous)) {
            return rendezVous;
        }
        return null;
    }

    public boolean updateRendezVous(int id, String date, String heure, String numTel) {
        RendezVous rendezVous = new RendezVous(id, date, heure, rendezVousRepository.getLogementByRDV(id), numTel);
        return rendezVousRepository.updateRendezVous(rendezVous);
    }

    public boolean deleteRendezVous(int id) {
        return rendezVousRepository.deleteRendezVous(id);
    }

}
