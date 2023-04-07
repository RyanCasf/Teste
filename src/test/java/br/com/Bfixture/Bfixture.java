package br.com.Bfixture;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Fixture")
class Bfixture {
	
	@DisplayName("BeforeAll.") @BeforeAll
	void beforeAll() {
		System.out.println("BeforeAll");
	}
	
	@DisplayName("AfterAll.") @AfterAll
	void afterAll() {
		System.out.println("AfterAll");
	}
	
	@DisplayName("BeforeEach.") @BeforeEach
	void beforeEach() {
		System.out.println("BeforeEach");
	}
	
	@DisplayName("AfterEach.") @AfterEach
	void afterEach() {
		System.out.println("AfterEach");
	}
	
	@Test @DisplayName("Test 1.")
	void test1() {
		System.out.println("Test 1");
	}
	
	@Test @DisplayName("Test 2.")
	void test2() {
		System.out.println("Test 2");
	}
}