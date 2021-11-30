package com.example.kumparanskilltest.model

import io.mockk.mockk
import junit.framework.TestCase
import org.junit.Test

class UserAddresModelTest {

    private var fakeGeo: UserGeoModel? = mockk()
    private var fakeStreet = "street"
    private var fakecity = "city"
    private var fakezipcode = "zipcode"
    private var fakeSuites = "suites"

    @Test
    fun `validating model return correctly`() {
        var fakeModel = UserAddressModel(
            geo = fakeGeo,
            street= fakeStreet,
            zipcode = fakezipcode,
            suite = fakeSuites,
            city = fakecity
        )

        TestCase.assertEquals(fakeModel.geo, fakeGeo)
        TestCase.assertEquals(fakeModel.zipcode, fakezipcode)
        TestCase.assertEquals(fakeModel.suite, fakeSuites)
        TestCase.assertEquals(fakeModel.city, fakecity)
        TestCase.assertEquals(fakeModel.street, fakeStreet)
    }
}