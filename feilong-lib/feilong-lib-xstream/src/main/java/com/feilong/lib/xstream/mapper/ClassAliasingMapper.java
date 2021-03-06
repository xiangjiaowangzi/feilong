/*
 * Copyright (C) 2005, 2006 Joe Walnes.
 * Copyright (C) 2006, 2007, 2008, 2009, 2011, 2015 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 09. April 2005 by Joe Walnes
 */
package com.feilong.lib.xstream.mapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.feilong.lib.xstream.core.util.Primitives;

/**
 * Mapper that allows a fully qualified class name to be replaced with an alias.
 *
 * @author Joe Walnes
 * @author J&ouml;rg Schaible
 */
public class ClassAliasingMapper extends MapperWrapper{

    private final Map     typeToName  = new HashMap();

    private final Map     classToName = new HashMap();

    private transient Map nameToType  = new HashMap();

    public ClassAliasingMapper(Mapper wrapped){
        super(wrapped);
    }

    public void addClassAlias(String name,Class type){
        nameToType.put(name, type.getName());
        classToName.put(type.getName(), name);
    }

    /**
     * @deprecated As of 1.3, method was a leftover of an old implementation
     */
    @Deprecated
    public void addClassAttributeAlias(String name,Class type){
        addClassAlias(name, type);
    }

    public void addTypeAlias(String name,Class type){
        nameToType.put(name, type.getName());
        typeToName.put(type, name);
    }

    @Override
    public String serializedClass(Class type){
        String alias = (String) classToName.get(type.getName());
        if (alias != null){
            return alias;
        }else{
            for (final Iterator iter = typeToName.keySet().iterator(); iter.hasNext();){
                final Class compatibleType = (Class) iter.next();
                if (compatibleType.isAssignableFrom(type)){
                    return (String) typeToName.get(compatibleType);
                }
            }
            return super.serializedClass(type);
        }
    }

    @Override
    public Class realClass(String elementName){
        String mappedName = (String) nameToType.get(elementName);

        if (mappedName != null){
            Class type = Primitives.primitiveType(mappedName);
            if (type != null){
                return type;
            }
            elementName = mappedName;
        }

        return super.realClass(elementName);
    }

    /**
     * @deprecated As of 1.4.9
     */
    @Deprecated
    public boolean itemTypeAsAttribute(Class clazz){
        return classToName.containsKey(clazz.getName());
    }

    /**
     * @deprecated As of 1.4.9
     */
    @Deprecated
    public boolean aliasIsAttribute(String name){
        return nameToType.containsKey(name);
    }

    private Object readResolve(){
        nameToType = new HashMap();
        for (final Iterator iter = classToName.keySet().iterator(); iter.hasNext();){
            final Object type = iter.next();
            nameToType.put(classToName.get(type), type);
        }
        for (final Iterator iter = typeToName.keySet().iterator(); iter.hasNext();){
            final Class type = (Class) iter.next();
            nameToType.put(typeToName.get(type), type.getName());
        }
        return this;
    }
}
