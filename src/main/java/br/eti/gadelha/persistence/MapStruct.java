package br.eti.gadelha.persistence;

import br.eti.gadelha.persistence.model.*;
import br.eti.gadelha.persistence.payload.request.*;
import br.eti.gadelha.persistence.payload.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface MapStruct {

    MapStruct MAPPER = Mappers.getMapper(MapStruct.class);
    DTOResponseCompany toDTOCompany(Company company);
    DTOResponseCountry toDTOCountry(Country country);
    DTOResponseEquipment toDTOEquipment(Equipment equipment);
    DTOResponseFederativeUnit toDTOFederativeUnit(FederativeUnit federativeUnit);

    Company toDTOCompany(DTORequestCompany dtoRequestCompany);
    Country toDTOCountry(DTORequestCountry dtoRequestCountry);
    Equipment toDTOEquipment(DTORequestEquipment dtoRequestEquipment);
    FederativeUnit toDTOFederativeUnit(DTORequestFederativeUnit dtoRequestFederativeUnit);

    User toUserEntity(DTORequestUser dtoRequestUser);
    Role toRole(DTORequestRole dtoRequestRole);
}