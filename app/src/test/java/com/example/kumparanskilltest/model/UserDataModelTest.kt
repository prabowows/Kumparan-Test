package com.example.kumparanskilltest.model

import io.mockk.mockk
import junit.framework.TestCase
import org.junit.Test

class UserDataModelTest {

    private var fakeUserName = "username"
    private var fakePhone = "08561111222"
    private var fakeName = "name"
    private var fakeEmail = "dummy@gmail.com"
    private var fakeWeb = "kumparan@gmail.com"
    private var fakeAddress: UserAddressModel? = mockk()
    private var fakeCompany: UserCompanyModel? = mockk()

    @Test
    fun `validating model return correctly`() {
        var fakeModel = UserDataModel(
            username = fakeUserName,
            website = fakeWeb,
            email = fakeEmail,
            name = fakeName,
            phone = fakePhone,
            address = fakeAddress,
            company = fakeCompany
        )

        TestCase.assertEquals(fakeModel.username, fakeUserName)
        TestCase.assertEquals(fakeModel.website, fakeWeb)
        TestCase.assertEquals(fakeModel.email, fakeEmail)
        TestCase.assertEquals(fakeModel.name, fakeName)
        TestCase.assertEquals(fakeModel.phone, fakePhone)
        TestCase.assertEquals(fakeModel.address, fakeAddress)
        TestCase.assertEquals(fakeModel.company, fakeCompany)
    }
}