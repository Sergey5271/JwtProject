package com.app.demo.converter.service;

import org.springframework.core.convert.ConversionService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ExtendedConversionService extends ConversionService {

    <T> List<T> convertAll(Collection<?> source, Class<T> targetClass);

}
