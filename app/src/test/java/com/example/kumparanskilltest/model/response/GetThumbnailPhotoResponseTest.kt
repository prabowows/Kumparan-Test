package com.example.kumparanskilltest.model.response

import com.example.kumparanskilltest.model.PhotosModel
import junit.framework.TestCase
import org.junit.Test

class GetThumbnailPhotoResponseTest {

    var fakeModelTest : PhotosModel = PhotosModel().apply {
        title = "title"
    }

    @Test
    fun `validating response return correctly`() {

        //Inject
        var model : ArrayList<PhotosModel> = GetThumbnailPhotosResponse()
        model.add(fakeModelTest)

        //Then
        TestCase.assertEquals(model[0].title, fakeModelTest.title)
    }
}