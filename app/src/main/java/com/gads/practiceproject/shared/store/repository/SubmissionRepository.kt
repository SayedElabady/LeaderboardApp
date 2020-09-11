package com.gads.practiceproject.shared.store.repository

import com.gads.practiceproject.shared.store.models.SubmitProjectPayload
import com.gads.practiceproject.shared.store.remote.IFormsAPI
import io.reactivex.Single

class SubmissionRepository(private val api: IFormsAPI) : ISubmissionRepository {
    override fun submitProject(payload: SubmitProjectPayload): Single<Unit> {
        return api.submitProject(payload)
    }

}