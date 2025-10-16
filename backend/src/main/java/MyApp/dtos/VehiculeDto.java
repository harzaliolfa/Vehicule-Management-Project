package MyApp.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class VehiculeDto {

    private Long id;

    @NonNull
    private String brand;

    @NonNull
    private String model;

    @NonNull
    private String color;

    @NotNull
    private int year;


}
