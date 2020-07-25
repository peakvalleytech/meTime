package peakvalleytech.neverdown

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test
import org.junit.Assert.*


private const val FAKE_STRING = "HELLO_WORLD"
class RobolectricUnitTests {
    val context = ApplicationProvider.getApplicationContext<Context>()

    @Test fun readStringFromContext_LocalizedString() {
        // Given a Context object retrieved from Robolectric
//        val myObjectUnderTest = ClassUnderTest(context)

        // ...when the string is returned from the object under test...
//        val result: String = myObjectUnderTest.getHelloWorldString()

        // ... then the result should be the expected one.
//        assertEquals(result, FAKE_STRING)
    }
}