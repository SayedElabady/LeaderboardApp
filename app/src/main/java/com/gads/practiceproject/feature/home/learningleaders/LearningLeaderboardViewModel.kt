package com.gads.practiceproject.feature.home.learningleaders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gads.practiceproject.shared.store.models.LearningLeaderModel
import com.gads.practiceproject.shared.store.repository.ILeaderRepository
import com.gads.practiceproject.shared.store.ui.BaseViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LearningLeaderboardViewModel(private val leadersRepository: ILeaderRepository) :
    BaseViewModel() {

    private val _leaders = MutableLiveData<List<LearningLeaderModel>>()

    val leaders: LiveData<List<LearningLeaderModel>> = _leaders

    fun initData() {
        leadersRepository.getLearningLeaders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoading.value = true }
            .doFinally { isLoading.value = false }
            .subscribe({
                _leaders.value = it.sortedByDescending { it.hours }
            }) {
                handleError(it) {
                    initData()
                }
            }.addToDisposableBag()
    }

}