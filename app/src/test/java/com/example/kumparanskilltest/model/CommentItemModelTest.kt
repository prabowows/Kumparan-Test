package com.example.kumparanskilltest.model

import junit.framework.TestCase
import org.junit.Test

class CommentItemModelTest {

    private var fakeId = 1
    private var fakePostId = 99
    private var fakeName = "name"
    private var fakeBody = "body"
    private var fakeEmail = "dummy@gmail.com"

    @Test
    fun `validating model return correctly`() {
        var fakeModel = CommentItemModel(
            id = fakeId,
            body = fakeBody,
            email = fakeEmail,
            name = fakeName,
            postId = fakePostId
        )

        TestCase.assertEquals(fakeModel.id, fakeId)
        TestCase.assertEquals(fakeModel.body, fakeBody)
        TestCase.assertEquals(fakeModel.email, fakeEmail)
        TestCase.assertEquals(fakeModel.name, fakeName)
        TestCase.assertEquals(fakeModel.postId, fakePostId)
    }
}