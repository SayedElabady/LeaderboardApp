package com.gads.practiceproject.feature.home.skillleaders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gads.practiceproject.shared.store.models.SkillIQLeaderModel
import com.gads.practiceproject.shared.store.repository.ILeaderRepository
import com.gads.practiceproject.shared.store.ui.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SkillIqLeaderboardViewModel(private val leadersRepository: ILeaderRepository) :
    BaseViewModel() {

    private val _leaders = MutableLiveData<List<SkillIQLeaderModel>>()

    val leaders: LiveData<List<SkillIQLeaderModel>> = _leaders

    fun initData() {
        leadersRepository.getSkillLeaders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoading.value = true }
            .doFinally { isLoading.value = false }
            .subscribe({
                _leaders.value = it.sortedByDescending { it.score }
            }) {
                handleError(it) {
                    initData()
                }
            }.addToDisposableBag()
    }

}