package kr.co.hilt

import javax.inject.Inject

class AnalyticsAdapter @Inject constructor(
    private val service: AnalyticsService
) {}
