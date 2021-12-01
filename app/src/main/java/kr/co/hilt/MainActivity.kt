package kr.co.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import kr.co.hilt.ui.main.MainFragment
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var TAG = javaClass.simpleName
    //@Inject lateinit var analytics: AnalyticsAdapter
    @Inject lateinit var aType: ATypeClass
    @Inject lateinit var aclass: ClassA
    @Inject lateinit var bclass: ClassB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        Log.e(TAG, aType.doByteTest())
        Log.e(TAG, aclass.doTestA())
        Log.e(TAG, bclass.showString())
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}

class ClassA
@Inject
constructor(private val bTypeVal: AInterface){
    fun doTestA() : String{
        return bTypeVal.doTestB()
    }
}

class ClassB
@Inject
constructor(private val cDependency: String): AInterface{
    override fun showString(): String {
        return "get Go ${cDependency}!"
    }
}

@Module
@InstallIn(ActivityComponent::class)
class AModule{
    @Provides
    fun c(): String{
        return "c String"
    }
//    fun provideCString(): String{
//        return "c String"
//    }
    @Provides
    fun testProvides(cString: String): AInterface{
        return ClassB(cString)
    }
}

interface AInterface{
    fun showString(): String
    fun doTestB() : String = "doTestB()"
}

class ATypeClass
@Inject
constructor(private val bTypeClass: BTypeClass){
    fun doByteTest(): String{
        return bTypeClass.test()
    }
}

class BTypeClass
@Inject
constructor(){
    fun test(): String{
        return "test is done"
    }
}