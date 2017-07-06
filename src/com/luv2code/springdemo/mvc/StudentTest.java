package com.luv2code.springdemo.mvc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.luv2code.springdemo.mvc.dao.StudentDao;
import com.luv2code.springdemo.mvc.dao.StudentDaoImpl;

public class StudentTest {

	private EmbeddedDatabase db;
    StudentDao userDao;

    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
    	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.HSQL)
    		.addScript("resources/db/sql/student.sql")
    		.build();
    }

    @Test
    public void testFindByname() {
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
    	StudentDaoImpl userDao = new StudentDaoImpl();
    	userDao.setNamedParameterJdbcTemplate(template);

    	Student user = userDao.findByName("mkyong");

    	Assert.assertNotNull(user);
    	

    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}
