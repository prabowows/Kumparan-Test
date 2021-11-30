package com.example.kumparanskilltest.model.response

import com.example.kumparanskilltest.model.AlbumItemModel
import junit.framework.TestCase
import org.junit.Test

class GetAlbumResponseTest {

    var fakeModelTest : AlbumItemModel = AlbumItemModel().apply {
        title = "title"
    }

    @Test
    fun `validating response return correctly`() {

        //Inject
        var model : ArrayList<AlbumItemModel> = GetAlbumResponse()
        model.add(fakeModelTest)

        //Then
        TestCase.assertEquals(model[0].title, fakeModelTest.title)
    }
}