package com.example.kumparanskilltest.model.response

import com.example.kumparanskilltest.model.CommentItemModel
import junit.framework.TestCase
import org.junit.Test

class GetCommentsResponseTest {

    var fakeModelTest : CommentItemModel = CommentItemModel().apply {
       body = "body"
    }

    @Test
    fun `validating response return correctly`() {

        //Inject
        var model : ArrayList<CommentItemModel> = GetCommentsResponse()
        model.add(fakeModelTest)

        //Then
        TestCase.assertEquals(model[0].body, fakeModelTest.body)
    }
}