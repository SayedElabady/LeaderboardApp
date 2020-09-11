package com.gads.practiceproject.shared.store.remote

import com.gads.practiceproject.shared.store.models.SubmitProjectPayload
import io.reactivex.Single

interface IFormsAPI{

    fun submitProject(payload: SubmitProjectPayload): Single<Unit>
}