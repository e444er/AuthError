package com.droidli.autherror.domain

import com.droidli.autherror.R
import com.droidli.autherror.data.MyRepositoryImpl
import com.droidli.autherror.util.Resource
import com.droidli.autherror.util.UiText

class SubmitEmail(
    private val repository: MyRepository = MyRepositoryImpl()
) {
    suspend fun execute(email: String): Resource<Unit> {
        if(!email.contains("@")) {
            return Resource.Error(
                UiText.StringResource(R.string.error_invalid_email)
            )
        }
        return repository.submitEmail(email)
    }
}