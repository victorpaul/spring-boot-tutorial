package com.example.tutorial.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class DBUtilImpl implements DBUtil {

    @Autowired
    EntityManager em;

    @Override
    public String getHealthStatus() {
        List results = em.createNativeQuery("SELECT 'connection to db is established'").getResultList();
        return results.get(0).toString();
    }
}
