package com.gads.practiceproject.shared.store.repository

import com.gads.practiceproject.shared.store.models.SubmitProjectPayload
import io.reactivex.Single

interface ISubmissionRepository {

    fun submitProject(payload: SubmitProjectPayload): Single<Unit>
}