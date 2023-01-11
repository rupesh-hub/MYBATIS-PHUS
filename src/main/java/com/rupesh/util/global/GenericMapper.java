package com.rupesh.util.global;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class GenericMapper<T> {

//    private final SqlSessionTemplate sqlSessionTemplate;
//
//    @Autowired
//    GenericMapper(SqlSessionTemplate sqlSessionTemplate) {
//        this.sqlSessionTemplate = sqlSessionTemplate;
//    }
//
//    public <T> T getMapper(Class<T> type) {
//        return this.sqlSessionTemplate.getMapper(type);
//    }

    private final T clazz;

    public GenericMapper(T clazz) {
        this.clazz = clazz;
    }


}
