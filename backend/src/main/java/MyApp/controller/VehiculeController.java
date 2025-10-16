package MyApp.controller;


import MyApp.dtos.VehiculeDto;
import MyApp.services.VehiculeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehiculeController {

    private  final VehiculeService vehiculeService;

    @GetMapping("/vehicules")
    public ResponseEntity<List<VehiculeDto>> allVehicules(){
        return ResponseEntity.ok(vehiculeService.allVehicules());
    }

    @GetMapping("/vehicules/{id}")
    public ResponseEntity<VehiculeDto> getVehicule(@PathVariable Long id){

        return ResponseEntity.ok(vehiculeService.getVehicule(id));
    }

    @PostMapping("/vehicules")
    public ResponseEntity<VehiculeDto> createVehicule(@Valid @RequestBody VehiculeDto vehiculeDto){
        VehiculeDto createdVehicule = vehiculeService.createVehicule(vehiculeDto);
        return  ResponseEntity.created(URI.create("/vehicules/" + createdVehicule.getId())).body(createdVehicule);
    }

    @DeleteMapping("/vehicules/{id}")
    public ResponseEntity<VehiculeDto> deleteVehicule(@PathVariable Long id){
        return ResponseEntity.ok(vehiculeService.deleteVehicule(id));
    }

    @PutMapping("/vehicules/{id}")
    public  ResponseEntity<VehiculeDto> updateVehicule(@PathVariable Long id,
                                                       @RequestBody VehiculeDto vehiculeDto){
        return ResponseEntity.ok(vehiculeService.updateVehicule(id, vehiculeDto));
    }

}
