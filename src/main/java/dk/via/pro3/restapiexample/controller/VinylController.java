package dk.via.pro3.restapiexample.controller;

import dk.via.pro3.restapiexample.model.Vinyl;
import dk.via.pro3.restapiexample.repository.VinylList;
import dk.via.pro3.restapiexample.service.VinylService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// RESTful controller for managing vinyl records
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/vinyls")
@Tag(name="Vinyl Management", description="APIs for managing Vinyl Albums")
public class VinylController {
    private VinylService vinylService;

    @Autowired
    public VinylController(VinylService vinylService) {
        this.vinylService = vinylService;
    }

    // GET endpoint to fetch all vinyls
    @Operation(summary = "Get all Vinyl Albums", description = "Retrieve a list of all Vinyls in the systems")
    @GetMapping("/")
    public VinylList getVinyls() {
        return vinylService.getAllVinyls();
    }

    @Operation(summary = "Create a new Vinyl Album", description = "Add a new Vinyl to the system")
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

    @Operation(summary = "Get a specific Vinyl Album by id", description = "Search for a specific Vinyl Album by its id")
    @GetMapping("/{id}")
    public Vinyl getVinylById(@PathVariable int id) {
        return vinylService.getVinylById(id);
    }
}
