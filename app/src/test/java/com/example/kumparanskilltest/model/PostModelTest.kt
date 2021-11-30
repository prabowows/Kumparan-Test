package com.example.kumparanskilltest.model

import junit.framework.TestCase
import org.junit.Test

class PostModelTest {

    private var fakeId = 1
    private var fakeUserId = 99
    private var fakeTitle = "Title"
    private var fakeBody = "Body"

    @Test
    fun `validating model return correctly`() {
        var fakeModel = PostModel(
            id = fakeId,
            userId = fakeUserId,
            title = fakeTitle,
            body = fakeBody
        )

        TestCase.assertEquals(fakeModel.id, fakeId)
        TestCase.assertEquals(fakeModel.title, fakeTitle)
        TestCase.assertEquals(fakeModel.userId, fakeUserId)
        TestCase.assertEquals(fakeModel.body, fakeBody)
    }
}