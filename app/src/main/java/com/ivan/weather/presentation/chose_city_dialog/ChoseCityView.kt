package com.ivan.weather.presentation.chose_city_dialog

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.ivan.weather.domain.entity.City
import com.ivan.weather.presentation.base.mvp.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface ChoseCityView: BaseView {

    fun getCities(list: List<City>)

}