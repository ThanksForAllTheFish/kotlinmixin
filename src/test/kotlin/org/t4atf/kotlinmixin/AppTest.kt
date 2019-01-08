package org.t4atf.kotlinmixin

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.transaction.annotation.Transactional
import org.t4atf.kotlinmixin.delegation.DelegatedObject

@SpringBootTest
@EnableJpaAuditing
@Transactional
class AppTest(@Autowired val testDelegatedObjectRepository: TestDelegatedObjectRepository) {
	@Test
	fun shouldAuditDelegatedObject() {
		val testDelegatedObject = DelegatedObject(10)
		val delegatedObject = testDelegatedObjectRepository.save(testDelegatedObject)
		Assertions.assertThat(delegatedObject.createdAt).isNotNull()
	}
}

@TestConfiguration
class TestDbConfiguration {
	@Bean
	fun dataSource() = EmbeddedDatabaseBuilder()
		.generateUniqueName(true)
		.setType(EmbeddedDatabaseType.HSQL)
		.build()
}
