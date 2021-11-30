package com.example.kumparanskilltest.viewmodel

import com.example.kumparanskilltest.model.PostModel
import com.example.kumparanskilltest.model.response.GetCommentsResponse
import com.example.kumparanskilltest.model.response.GetUserResponse
import com.example.kumparanskilltest.repository.AllRepository
import io.mockk.*
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DetailPostViewModelTest {

    @Test
    fun `validating getDetailPost return correctly`() {

        //Given
        var fakeViewModel = DetailPostViewModel()
        var fakeModel: PostModel = mockk()
        mockkObject(AllRepository)

        //Inject
        justRun { AllRepository.getPostDetail(any()).value }
        every { fakeViewModel.getDetailPost(any())?.value } returns fakeModel

        //Then
        assertEquals(fakeViewModel.getDetailPost("1")?.value, fakeViewModel.detailPost?.value)
    }

    @Test
    fun `validating getComment return correctly`() {

        //Given
        var fakeViewModel = DetailPostViewModel()
        var fakeModel: GetCommentsResponse = mockk()
        mockkObject(AllRepository)

        //Inject
        justRun { AllRepository.getCommentsPost(any()).value }
        every { fakeViewModel.getComment(any())?.value } returns fakeModel

        //Then
        assertEquals(fakeViewModel.getComment("1")?.value, fakeViewModel.listComment?.value)
    }

    @Test
    fun `validating getDetailUser return correctly`() {

        //Given
        var fakeViewModel = DetailPostViewModel()
        var fakeModel: GetUserResponse = mockk()
        mockkObject(AllRepository)

        //Inject
        justRun { AllRepository.getDetailUser(any()).value }
        every { fakeViewModel.getDetailUser(any())?.value } returns fakeModel

        //Then
        assertEquals(fakeViewModel.getDetailUser("1")?.value, fakeViewModel.detailUser?.value)
    }
}