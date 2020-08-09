package com.app.demo.converter.service;

import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtendedConversionServiceImpl extends DefaultConversionService implements ExtendedConversionService {

    private static <T> Stream<T> stream(Collection<T> collection) {
        if (Objects.isNull(collection)) {
            return Stream.empty();
        }
        return collection.stream();
    }

    @Override
    public <T> List<T> convertAll(Collection<?> source, Class<T> targetClass) {
        Stream<?> stream = stream(source);
        return stream
                .filter(Objects::nonNull)
                .map(item -> convert(item, targetClass))
                .collect(Collectors.toList());
    }
}
