package com.fzanutto.core.domain.model

import java.lang.Exception

sealed class GoalType(val name: String) {
    object LoseWeight: GoalType("lose_wight")
    object KeepWeight: GoalType("keep_wight")
    object GainWeight: GoalType("gain_wight")

    companion object {
        fun fromString(name: String): GoalType {
            return when (name) {
                "lose_wight" -> LoseWeight
                "keep_wight" -> KeepWeight
                "gain_wight" -> GainWeight
                else -> KeepWeight
            }
        }
    }
}
