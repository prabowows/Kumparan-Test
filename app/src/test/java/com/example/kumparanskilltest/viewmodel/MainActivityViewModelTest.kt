package com.example.kumparanskilltest.viewmodel

import com.example.kumparanskilltest.model.AllPostModel
import com.example.kumparanskilltest.model.response.GetUserResponse
import com.example.kumparanskilltest.repository.AllRepository
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.mockkObject
import junit.framework.TestCase
import org.junit.Test

class MainActivityViewModelTest {

    @Test
    fun `validating getAllPost return correctly`() {

        //Given
        var fakeViewModel = MainActivityViewModel()
        var fakeModel: AllPostModel = mockk()
        mockkObject(AllRepository)

        //Inject
        justRun { AllRepository.getAllPost().value }
        every { fakeViewModel.getAllPost()?.value } returns fakeModel

        //Then
        TestCase.assertEquals(
            fakeViewModel.getAllPost()?.value, fakeViewModel.listAllPost?.value
        )
    }

    @Test
    fun `validating getDetailUser return correctly`() {

        //Given
        var fakeViewModel = MainActivityViewModel()
        var fakeModel: GetUserResponse = mockk()
        mockkObject(AllRepository)

        //Inject
        justRun { AllRepository.getDetailUser(any()).value }
        every { fakeViewModel.getDetailUser(any())?.value } returns fakeModel

        //Then
        TestCase.assertEquals(fakeViewModel.getDetailUser("1")?.value, fakeViewModel.detailUser?.value
        )
    }
}