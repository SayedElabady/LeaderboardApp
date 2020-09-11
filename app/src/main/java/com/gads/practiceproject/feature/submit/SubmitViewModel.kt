package com.gads.practiceproject.feature.submit

import androidx.lifecycle.MutableLiveData
import com.gads.practiceproject.shared.store.models.SubmitProjectPayload
import com.gads.practiceproject.shared.store.repository.ISubmissionRepository
import com.gads.practiceproject.shared.store.repository.SubmissionRepository
import com.gads.practiceproject.shared.store.ui.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SubmitViewModel(private val submissionRepository: ISubmissionRepository) : BaseViewModel() {

    val success = MutableLiveData<Boolean>()
    fun submit(firstName: String, lastName: String, email: String, githubLink: String) {
        submissionRepository.submitProject(
            SubmitProjectPayload.create(
                firstName, lastName, email, githubLink
            )
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                success.value = true
            }) {
                handleError(it) {

                }
            }.addToDisposableBag()
    }
}