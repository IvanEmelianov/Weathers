package com.ivan.weather.presentation.app

import com.arellomobile.mvp.InjectViewState
import com.ivan.weather.presentation.Screens
import com.ivan.weather.presentation.base.mvp.BasePresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class AppPresenter(
    private val router: Router
) : BasePresenter<AppView>() {

    fun beginWork(){
        router.newRootChain(Screens.WeatherScreen)
    }
}