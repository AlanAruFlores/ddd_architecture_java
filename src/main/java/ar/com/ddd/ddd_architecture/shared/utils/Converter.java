package ar.com.ddd.ddd_architecture.shared.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Converter {
    
    private static ModelMapper modelMapper = new ModelMapper();

    private static ObjectMapper objectMapper  = new ObjectMapper();


    public static <T> T convertToEntity(Object object, Class<T> entityClass) {
        return modelMapper.map(object, entityClass);
    }

    public static <T> List<T> convertToEntityList(List<?> objects, Class<T> entityClass) {
        return objects.stream()
                .map(object -> modelMapper.map(object, entityClass))
                .collect(Collectors.toList());
    }

    public static <T> T convertToModel(Object object, Class<T> dtoClass) {
        return objectMapper.convertValue(object, dtoClass);
    }


    public static <T> T convertToDto(Object object, Class<T> dtoClass) {
        return objectMapper.convertValue(object, dtoClass);
    }
    
    public static <T> List<T> convertToList(List<?> objects, Class<T> entityClass) {
        return objects.stream()
                .map(object -> objectMapper.convertValue(object, entityClass))
                .collect(Collectors.toList());
    }
}
