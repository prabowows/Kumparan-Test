package com.example.kumparanskilltest.model

import junit.framework.TestCase
import org.junit.Test

class PhotosModelTest {

    private var fakeId = 1
    private var fakeAlbumId = 99
    private var faketitle = "title"
    private var fakeurl = "url"
    private var fakeThumbnailUrl = "dummy@gmail.com"

    @Test
    fun `validating model return correctly`() {
        var fakeModel = PhotosModel(
            id = fakeId,
            url = fakeurl,
            thumbnailUrl = fakeThumbnailUrl,
            title = faketitle,
            albumId = fakeAlbumId
        )

        TestCase.assertEquals(fakeModel.id, fakeId)
        TestCase.assertEquals(fakeModel.url, fakeurl)
        TestCase.assertEquals(fakeModel.thumbnailUrl, fakeThumbnailUrl)
        TestCase.assertEquals(fakeModel.title, faketitle)
        TestCase.assertEquals(fakeModel.albumId, fakeAlbumId)
    }
}