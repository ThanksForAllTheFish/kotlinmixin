package org.t4atf.kotlinmixin.composition

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.t4atf.kotlinmixin.base.BaseAuditable
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "test_composed_object")
@EntityListeners(AuditingEntityListener::class)
class ComposedObject(
	@Column(name = "age")
	var age: Int,
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Int? = null,
	@Embedded
	val auditable: BaseAuditable = BaseAuditable()
)
