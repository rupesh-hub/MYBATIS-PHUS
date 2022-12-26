package com.rupesh.util.mapper;

import com.rupesh.entity.Address;
import com.rupesh.model.AddressDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {

    public static AddressDTO toDto(final Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCountry(address.getCountry());
        addressDTO.setCity(address.getCity());
        addressDTO.setZone(address.getZone());
        addressDTO.setStreet(address.getStreet());
        return addressDTO;
    }

    public static Address toEntity(final AddressDTO addressDTO){
        Address address = new Address();
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setZone(addressDTO.getZone());
        address.setStreet(addressDTO.getStreet());
        return address;
    }

    public static List<AddressDTO> toDtoList(final List<Address> addressList) {
        return addressList.stream().map(AddressMapper::toDto).collect(Collectors.toList());
    }

}
