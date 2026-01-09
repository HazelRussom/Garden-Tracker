package com.gardentracker.data.repository

import com.gardentracker.domain.MonthTasks
import java.time.Month

class MonthlyTasksRepository {
    private val tasksMap = mapOf(
        Month.JANUARY to MonthTasks(
            tasks = listOf(
            ),
            indoorPlanting = listOf(
                "Delphinium",
                "Sweetpea",
                "Verbena",
                "Yellow Onion seeds"
            )
        ),
        Month.FEBRUARY to MonthTasks(
            tasks = listOf(""),
        ),
        Month.MARCH to MonthTasks(
            tasks = listOf(""),
        ),
        Month.APRIL to MonthTasks(
            tasks = listOf(""),
        ),
        Month.MAY to MonthTasks(
            tasks = listOf(""),
        ),
        Month.JUNE to MonthTasks(
            tasks = listOf(""),
        ),
        Month.JULY to MonthTasks(
            tasks = listOf(""),
        ),
        Month.AUGUST to MonthTasks(
            tasks = listOf(""),
        ),
        Month.SEPTEMBER to MonthTasks(
            tasks = listOf(""),
        ),
        Month.OCTOBER to MonthTasks(
            tasks = listOf(""),
        ),
        Month.NOVEMBER to MonthTasks(
            tasks = listOf(""),
        ),
        Month.DECEMBER to MonthTasks(
            tasks = listOf("December!"),
        )
    )

    fun getTasksFor(month: Month): MonthTasks {
        val monthTasks = tasksMap[month] ?: throw Error("Not implemented month $month")
        return monthTasks
    }
}