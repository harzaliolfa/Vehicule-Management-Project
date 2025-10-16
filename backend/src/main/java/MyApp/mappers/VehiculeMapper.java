package MyApp.mappers;

import MyApp.dtos.VehiculeDto;
import MyApp.entities.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    Vehicule toVehicule(VehiculeDto vehiculeDto);

    VehiculeDto toVehiculeDto(Vehicule vehicule);

    List<VehiculeDto> toVehiculeDtos(List<Vehicule> vehicules);

    void  updateVehicule(@MappingTarget Vehicule target, Vehicule source);
}
