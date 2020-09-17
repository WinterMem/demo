package com.pch.common.config;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author: pch
 * @date: 2020/9/17
 */
public class HibernateIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sessionImplementor, Object object)
            throws HibernateException {
        return IdSnowflake.nextId();
    }
}
