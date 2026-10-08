package dk.via.pro3.restapiexample.controller;

import dk.via.pro3.restapiexample.model.Vinyl;
import dk.via.pro3.restapiexample.repository.VinylList;
import dk.via.pro3.restapiexample.service.VinylService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// RESTful controller for managing vinyl records
@RestController
@RequestMapping("/api/v1/vinyls")
public class VinylController {
    private VinylService vinylService;

    @Autowired
    public VinylController(VinylService vinylService) {
        this.vinylService = vinylService;
    }

    // GET endpoint to fetch all vinyls
    @GetMapping("/")
    public VinylList getVinyls() {
        return vinylService.getAllVinyls();
    }

    @PostMapping("/")
    public ResponseEntity<Vinyl> addVinyl(@RequestBody Vinyl vinyl) {
        vinylService.addVinyl(vinyl);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vinyl.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public Vinyl getVinylById(@PathVariable int id) {
        return vinylService.getVinylById(id);
    }
}
