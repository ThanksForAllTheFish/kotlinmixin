package org.t4atf.kotlinmixin.delegation

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.t4atf.kotlinmixin.base.Auditable
import org.t4atf.kotlinmixin.base.BaseAuditable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "test_delegated_object")
@EntityListeners(AuditingEntityListener::class)
data class DelegatedObject(
	@Column(name = "age")
	var age: Int,
	@Id
	@GeneratedValue
	var id: Int? = null
) : Auditable by BaseAuditable()