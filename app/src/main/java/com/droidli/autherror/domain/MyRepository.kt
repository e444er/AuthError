package com.droidli.autherror.domain

import com.droidli.autherror.util.Resource

interface MyRepository {
    suspend fun submitEmail(email: String): Resource<Unit>
}