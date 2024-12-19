package com.apiRest.apiRestRestful.mapper;


import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private static ModelMapper mapper = new ModelMapper();

    public static <O, D> D parseObj(O origem, Class<D> destination){
        return mapper.map(origem,destination);
    }

    public static <O, D> List<D> parseListObjs(List<O> origem, Class<D> destination){
        List<D> destinatioObj = new ArrayList<>();

        origem.forEach(o ->{
            destinatioObj.add(mapper.map(o, destination));
        });

        return destinatioObj;
    }

}
