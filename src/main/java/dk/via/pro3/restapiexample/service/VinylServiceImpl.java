package dk.via.pro3.restapiexample.service;

import dk.via.pro3.restapiexample.model.Vinyl;
import dk.via.pro3.restapiexample.repository.VinylDAO;
import dk.via.pro3.restapiexample.repository.VinylList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VinylServiceImpl implements VinylService {
    private VinylDAO vinylDAO;

    @Autowired
    public VinylServiceImpl(VinylDAO vinylDAO) {
        this.vinylDAO = vinylDAO;
    }

    @Override
    public VinylList getAllVinyls() {
        return vinylDAO.getAllVinyls();
    }

    @Override
    public VinylDAO addVinyl(Vinyl vinyl) {
        vinylDAO.addVinyl(vinyl);
        return vinylDAO;
    }

    @Override
    public Vinyl getVinylById(int id) {
        return vinylDAO.getVinylById(id);
    }
}
