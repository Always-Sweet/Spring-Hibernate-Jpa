package com.demo.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * 工具类
 */
public class ToolUtils {

    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        BeanWrapperImpl src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyProperties = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyProperties.add(pd.getName());
        }

        String[] result = new String[emptyProperties.size()];
        BeanUtils.copyProperties(source, target, emptyProperties.toArray(result));
    }
}
