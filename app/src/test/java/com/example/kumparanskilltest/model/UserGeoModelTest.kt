package com.example.kumparanskilltest.model

import junit.framework.TestCase
import org.junit.Test

class UserGeoModelTest {

    private var fakeLong = "80"
    private var fakeLat = "90"

    @Test
    fun `validating model return correctly`() {
        val fakeModel = UserGeoModel(
            lng = fakeLong,
            lat = fakeLat
        )

        TestCase.assertEquals(fakeModel.lng, fakeLong)
        TestCase.assertEquals(fakeModel.lat, fakeLat)
    }
}