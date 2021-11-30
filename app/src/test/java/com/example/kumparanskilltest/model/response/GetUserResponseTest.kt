package com.example.kumparanskilltest.model.response

import com.example.kumparanskilltest.model.UserDataModel
import junit.framework.TestCase
import org.junit.Test

class GetUserResponseTest {

    var fakeModelTest: UserDataModel = UserDataModel().apply {
        name = "name"
    }

    @Test
    fun `validating response return correctly`() {

        //Inject
        var model: ArrayList<UserDataModel> = GetUserResponse()
        model.add(fakeModelTest)

        //Then
        TestCase.assertEquals(model[0].name, fakeModelTest.name)
    }
}