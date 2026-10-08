package dk.via.pro3.restapiexample.service;

import dk.via.pro3.restapiexample.model.Vinyl;
import dk.via.pro3.restapiexample.repository.VinylDAO;
import dk.via.pro3.restapiexample.repository.VinylList;

public interface VinylService {
    // get all vinyl records
    VinylList getAllVinyls();
    // add vinyl
    VinylDAO addVinyl(Vinyl vinyl);
    // get vinyl by its id.
    Vinyl getVinylById(int id);
}
