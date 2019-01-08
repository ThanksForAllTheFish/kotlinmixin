package org.t4atf.kotlinmixin.base

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

interface Auditable {
	@get:Column(name = "created_by")
	@get:CreatedBy
	var createdBy: Int?
	@get:Column(name = "created_at")
	@get:CreatedDate
	var createdAt: Date?
	@get:Column(name = "modified_by")
	@get:LastModifiedBy
	var modifiedBy: Int?
	@get:Column(name = "modified_at")
	@get:LastModifiedDate
	var modifiedAt: Date?
}

@Embeddable
class BaseAuditable(
	override var modifiedAt: Date? = null,
	override var modifiedBy: Int? = null,
	override var createdAt: Date? = null,
	override var createdBy: Int? = null
) : Auditable