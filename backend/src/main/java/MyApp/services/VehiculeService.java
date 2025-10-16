package MyApp.services;

import MyApp.dtos.VehiculeDto;
import MyApp.entities.Vehicule;
import MyApp.exceptions.AppException;
import MyApp.mappers.VehiculeMapper;
import MyApp.repository.VehiculeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;


    public VehiculeDto getVehicule(Long id) {
       Vehicule vehicule = vehiculeRepository.findById(id).orElseThrow(
               ()-> new AppException("vehicules not found", HttpStatus.NOT_FOUND));
       return vehiculeMapper.toVehiculeDto(vehicule);
    }

    public List<VehiculeDto> allVehicules(){
        return  vehiculeMapper.toVehiculeDtos(vehiculeRepository.findAll());
    }

    public VehiculeDto createVehicule(@Valid VehiculeDto vehiculeDto) {
        Vehicule vehicule = vehiculeMapper.toVehicule(vehiculeDto);
        return vehiculeMapper.toVehiculeDto(vehiculeRepository.save(vehicule)) ;
    }

    public VehiculeDto deleteVehicule(Long id) {

        Vehicule vehicule = vehiculeRepository.findById(id).orElseThrow(
                () ->  new AppException("vehicules not found", HttpStatus.NOT_FOUND));
        vehiculeRepository.deleteById(id);
        return vehiculeMapper.toVehiculeDto(vehicule);
    }


    public VehiculeDto updateVehicule(Long id, VehiculeDto vehiculeDto) {
        Vehicule vehicule = vehiculeRepository.findById(id).orElseThrow(
                ()-> new AppException("vehicules not found", HttpStatus.NOT_FOUND));

        vehiculeMapper.updateVehicule(vehicule, vehiculeMapper.toVehicule(vehiculeDto));

        vehiculeRepository.save(vehicule);
        return vehiculeMapper.toVehiculeDto(vehicule);

    }
}
