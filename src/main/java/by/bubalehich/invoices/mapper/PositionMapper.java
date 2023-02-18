package by.bubalehich.invoices.mapper;

import by.bubalehich.invoices.dto.PositionDto;

public final class PositionMapper {
    private static final String DELIMITER = "-";

    public static PositionDto mapToPositionDtoFromString(String s) {
        var positionArray = s.split(DELIMITER);

        return new PositionDto(positionArray[0], Integer.parseInt(positionArray[1]));
    }
}
