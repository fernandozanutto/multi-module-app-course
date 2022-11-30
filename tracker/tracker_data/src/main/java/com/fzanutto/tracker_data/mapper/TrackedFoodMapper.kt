package com.fzanutto.tracker_data.mapper

import com.fzanutto.tracker_data.local.entity.TrackedFoodEntity
import com.fzanutto.tracker_domain.model.MealType
import com.fzanutto.tracker_domain.model.TrackableFood
import com.fzanutto.tracker_domain.model.TrackedFood
import java.time.LocalDate
import kotlin.math.roundToInt

fun TrackedFoodEntity.toTrackedFood(): TrackedFood {
    return TrackedFood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
        id = id
    )
}


fun TrackedFood.toTrackedFoodEntity(): TrackedFoodEntity {
    return TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        type = mealType.name,
        amount = amount,
        year = date.year,
        month = date.monthValue,
        dayOfMonth = date.dayOfMonth,
        calories = calories,
        id = id
    )
}