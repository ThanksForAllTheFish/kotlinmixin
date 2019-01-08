package org.t4atf.kotlinmixin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.data.repository.CrudRepository
import org.t4atf.kotlinmixin.delegation.DelegatedObject

@SpringBootApplication
class App

fun main(args: Array<String>) {
	runApplication<App>(*args)
}

@Configuration
class AuditConf {
	@Bean
	fun createAuditingListener() = AuditingEntityListener()
}

interface TestDelegatedObjectRepository : CrudRepository<DelegatedObject, Int>