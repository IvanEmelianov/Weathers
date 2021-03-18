package com.ivan.weather.presentation.chose_city_dialog

import com.arellomobile.mvp.InjectViewState
import com.ivan.weather.domain.interactor.ChoseCityInteractor
import com.ivan.weather.presentation.base.mvp.BasePresenter

@InjectViewState
class ChoseCityPresenter(
    private val interactor: ChoseCityInteractor
) : BasePresenter<ChoseCityView>(){

    /*override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getCities()
    }*/

    fun getCities(){
        interactor.getAllCity()
            .map { viewState.getCities(it) }
            .subscribe()
            .autoDisposeOnDestroy()
    }

}