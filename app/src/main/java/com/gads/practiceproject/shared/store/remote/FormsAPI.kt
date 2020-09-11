package com.gads.practiceproject.shared.store.remote

import com.gads.practiceproject.shared.store.models.SubmitProjectPayload
import io.reactivex.Single

class FormsAPI(private val service: IGoogleFormsService) : IFormsAPI {
    override fun submitProject(payload: SubmitProjectPayload): Single<Void> {
        return service.submitProject(
            payload.firstName,
            payload.secondName,
            payload.email,
            payload.githubLink
        )
    }

}