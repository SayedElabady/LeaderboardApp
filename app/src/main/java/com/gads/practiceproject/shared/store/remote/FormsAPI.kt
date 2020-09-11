package com.gads.practiceproject.shared.store.remote

import com.gads.practiceproject.shared.store.models.SubmitProjectPayload
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormsAPI(private val service: IGoogleFormsService) : IFormsAPI {
    override fun submitProject(payload: SubmitProjectPayload): Single<Unit> {
        val subject = BehaviorSubject.create<Unit>()

        service.submitProject(
            payload.firstName,
            payload.secondName,
            payload.email,
            payload.githubLink
        ).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.isSuccessful){
                    subject.onNext(Unit)
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                subject.onError(t)
            }
        })
        return subject.firstOrError()
    }

}