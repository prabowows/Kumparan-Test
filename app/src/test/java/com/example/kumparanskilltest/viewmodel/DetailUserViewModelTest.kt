package com.example.kumparanskilltest.viewmodel

import com.example.kumparanskilltest.model.response.GetAlbumResponse
import com.example.kumparanskilltest.model.response.GetThumbnailPhotosResponse
import com.example.kumparanskilltest.model.response.GetUserResponse
import com.example.kumparanskilltest.repository.AllRepository
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.mockkObject
import junit.framework.TestCase
import org.junit.Test

class DetailUserViewModelTest {

    @Test
    fun `validating getDetailUser return correctly`() {

        //Given
        var fakeViewModel = DetailUserViewModel()
        var fakeModel: GetUserResponse = mockk()
        mockkObject(AllRepository)

        //Inject
        justRun { AllRepository.getDetailUser(any()).value }
        every { fakeViewModel.getDetailUser(any())?.value } returns fakeModel

        //Then
        TestCase.assertEquals(fakeViewModel.getDetailUser("1")?.value, fakeViewModel.detailUser?.value
        )
    }

    @Test
    fun `validating getAlbumUser return correctly`() {

        //Given
        var fakeViewModel = DetailUserViewModel()
        var fakeModel: GetAlbumResponse = mockk()
        mockkObject(AllRepository)

        //Inject
        justRun { AllRepository.getAlbum(any()).value }
        every { fakeViewModel.getAlbumUser(any())?.value } returns fakeModel

        //Then
        TestCase.assertEquals(
            fakeViewModel.getAlbumUser("1")?.value, fakeViewModel.userAlbum?.value
        )
    }

    @Test
    fun `validating getThumbnail return correctly`() {

        //Given
        var fakeViewModel = DetailUserViewModel()
        var fakeModel: GetThumbnailPhotosResponse = mockk()
        mockkObject(AllRepository)

        //Inject
        justRun { AllRepository.getThumbailPhoto(any()).value }
        every { fakeViewModel.getThumbnailPhotoUser(any())?.value } returns fakeModel

        //Then
        TestCase.assertEquals(
            fakeViewModel.getThumbnailPhotoUser("1")?.value, fakeViewModel.userPhotoThumbnail?.value
        )
    }
}