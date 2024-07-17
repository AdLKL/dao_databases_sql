package com.ad.dbPostgr.dao.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ad.dbPostgr.TestDataUtil;
import com.ad.dbPostgr.domain.Author;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplIntegrationTests {
	private AuthorDaoImpl underTest;
	
	@Autowired
	public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest) {
		this.underTest = underTest;
	}
	
	@Test
	public void testThatAuthorCanBeCreatedAndRecalled() {
		Author author = TestDataUtil.createTestAuthorA();
		underTest.create(author);
		Optional<Author> result = underTest.findOne(author.getId());
		assertTrue(result.isPresent(), "Author should be present");
		assertEquals(author, result.get(), "The recalled author should match the created author");
	}
}
