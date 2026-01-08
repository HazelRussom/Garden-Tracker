package com.gardentracker.domain

data class MonthTasks(
    val tasks: List<String>,
    val indoorPlanting: List<String> = listOf(),
)
