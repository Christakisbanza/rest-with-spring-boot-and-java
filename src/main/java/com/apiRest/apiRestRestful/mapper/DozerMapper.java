package com.apiRest.apiRestRestful.mapper;

import com.apiRest.apiRestRestful.entity.User;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    private final static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

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
