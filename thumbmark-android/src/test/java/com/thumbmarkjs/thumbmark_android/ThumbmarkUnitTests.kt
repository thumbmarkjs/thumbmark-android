package com.thumbmarkjs.thumbmark_android

import android.content.Context
import com.thumbmarkjs.thumbmark_android.mocks.MockComponent
import com.thumbmarkjs.thumbmark_android.mocks.MockFingerprint
import org.junit.Test

import org.junit.Assert.*

/**
 * Basic unit tests to verify core functionality of Thumbmark library.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ThumbmarkUnitTests {
    @Test
    fun additionalComponentsCanBeSetToSingleValue() {
        val mockComponents = listOf(MockComponent())
        Thumbmark.setAdditionalComponents(mockComponents)
        val value = Thumbmark.components
        assertEquals(mockComponents.count(), value?.count())
    }

    @Test
    fun additionalComponentsCanBeSetToMultipleValues() {
        val mockComponents = listOf(MockComponent(), MockComponent())
        Thumbmark.setAdditionalComponents(mockComponents)
        val value = Thumbmark.components
        assertEquals(mockComponents.count(), value?.count())
    }

    @Test
    fun additionalComponentsCanBeSetToNull() {
        val mockComponents = listOf(MockComponent(), MockComponent())
        Thumbmark.setAdditionalComponents(mockComponents)
        Thumbmark.setAdditionalComponents(null)
        val value = Thumbmark.components
        assertNull(value)
    }

    // Need to figure out a way to get context here so that we can test that an id is stable.
//    @Test
//    fun testKnownFingerprintReturnsStableId() {
//        val fingerprint = MockFingerprint.fingerprint
//        val expectedId = MockFingerprint.expectedId
//        val value = Thumbmark.id(this, "SHA-256", fingerprint)
//        assertEquals(expectedId, value)
//    }
}