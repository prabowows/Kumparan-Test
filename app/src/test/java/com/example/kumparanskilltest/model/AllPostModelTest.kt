package com.example.kumparanskilltest.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class AllPostModelTest {

    var fakeModelTest : PostModel = PostModel().apply {
        body = "body"
    }

    @Test
    fun `validating model return correctly`() {

        //Inject
        var model : ArrayList<PostModel> = AllPostModel()
        model.add(fakeModelTest)

        //Then
        assertEquals(model[0].body, fakeModelTest.body)
    }
}