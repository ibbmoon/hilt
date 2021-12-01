package kr.co.hilt

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Inject

interface AnalyticsService {
    fun analyticsMethods()
}
class AnalyticsServiceImpl @Inject constructor(
) : AnalyticsService {
    override fun analyticsMethods() {

    }
}

//@Module
//@InstallIn(ActivityComponent::class)
//abstract class AnalyticsModule {
//
//    @Binds
//    abstract fun bindAnalyticsService(
//        analyticsServiceImpl: AnalyticsServiceImpl
//    ): AnalyticsService
//}

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule {

    @Provides
    fun provideAnalyticsService(
        // Potential dependencies of this type
    ): AnalyticsService {
        return Retrofit.Builder()
            .baseUrl("https://example.com")
            .build()
            .create(AnalyticsService::class.java)
    }
}
