package hr.hackaton.codebandits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class Location {
    @NonNull
    private Double longitude;

    @NonNull
    private Double latitude;

}