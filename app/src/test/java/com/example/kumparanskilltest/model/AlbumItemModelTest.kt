package com.example.kumparanskilltest.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class AlbumItemModelTest {

    private var fakeId = 1
    private var fakeUserId = 99
    private var fakeTitle = "Title"

    @Test
    fun `validating model return correctly`() {
        var fakeModel = AlbumItemModel(
            id = fakeId,
            userId = fakeUserId,
            title = fakeTitle
        )

        assertEquals(fakeModel.id, fakeId)
        assertEquals(fakeModel.title, fakeTitle)
        assertEquals(fakeModel.userId, fakeUserId)
    }
}