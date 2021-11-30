package com.example.kumparanskilltest.model

import junit.framework.TestCase
import org.junit.Test

class UserCompanyModelTest {

    private var fakeCatchPhrase = "catchphrase"
    private var fakeBs = "bs"
    private var fakename = "name"

    @Test
    fun `valCatchPhraseating model return correctly`() {
        var fakeModel = UserCompanyModel(
            catchPhrase = fakeCatchPhrase,
            bs = fakeBs,
            name = fakename
        )

        TestCase.assertEquals(fakeModel.catchPhrase, fakeCatchPhrase)
        TestCase.assertEquals(fakeModel.name, fakename)
        TestCase.assertEquals(fakeModel.bs, fakeBs)
    }
}