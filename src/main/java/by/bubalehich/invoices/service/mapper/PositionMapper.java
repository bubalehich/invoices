package by.bubalehich.invoices.service.mapper;

import by.bubalehich.invoices.dto.PositionDto;

public final class PositionMapper {
    public static PositionDto mapToPositionDtoFromString(String s) {
        var positionArray = s.split("-");

        return new PositionDto(positionArray[0], Integer.parseInt(positionArray[1]));
    }
}
