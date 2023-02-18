package com.example.jetdating.ui.getuserinfo

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GetUserInfoViewModel(

): ViewModel() {

    private val questionOrder: List<UserInfoQuestion> = listOf(
        UserInfoQuestion.NAME,
        UserInfoQuestion.GENDER,
        UserInfoQuestion.BIRTHDATE,
        UserInfoQuestion.HEIGHT,
        UserInfoQuestion.IS_STUDENT,
        UserInfoQuestion.COMPANY,
        UserInfoQuestion.JOB,
        UserInfoQuestion.SCHOOL,
        UserInfoQuestion.PERSONALITY,
        UserInfoQuestion.INTEREST,
        UserInfoQuestion.SELFIE
    )

    private var questionIndex = 0

    // ----- Responses exposed as State -----

    private val _nameResponse = mutableStateOf<String?>(null)
    val nameResponse: String?
        get() = _nameResponse.value

    private val _genderResponse = mutableStateOf<Gender?>(null)
    val genderResponse: Gender?
        get() = _genderResponse.value

    private val _birthdateResponse = mutableStateOf<Long?>(null)
    val birthdateResponse: Long?
        get() = _birthdateResponse.value

    private val _heightResponse = mutableStateOf<Int?>(null)
    val heightResponse: Int?
        get() = _heightResponse.value

    private val _isStudentResponse = mutableStateOf<Boolean?>(null)
    val isStudentResponse: Boolean?
        get() = _isStudentResponse.value

    private val _companyResponse = mutableStateOf<String?>(null)
    val companyResponse: String?
        get() = _companyResponse.value

    private val _jobResponse = mutableStateOf<String?>(null)
    val jobResponse: String?
        get() = _jobResponse.value

    private val _schoolResponse = mutableStateOf<String?>(null)
    val schoolResponse: String?
        get() = _schoolResponse.value

    private val _personalityResponse = mutableStateListOf<Int>()
    val personalityResponse: List<Int>
        get() = _personalityResponse

    private val _interestResponse = mutableStateListOf<Int>()
    val interestResponse: List<Int>
        get() = _interestResponse

    private val _selfieUri = mutableStateListOf<Uri>()
    val selfieUri
        get() = _selfieUri

    // ----- Question status exposed as State -----

    private val _getUserInfoScreenData = mutableStateOf(createGetUserInfoScreenData())
    val getUserInfoScreenData: GetUserInfoScreenData?
        get() = _getUserInfoScreenData.value

    private val _isContinueEnabled = mutableStateOf(false)
    val isContinueEnabled: Boolean
        get() = _isContinueEnabled.value

    private fun createGetUserInfoScreenData(): GetUserInfoScreenData {
        return GetUserInfoScreenData(
            questionIndex = questionIndex,
            questionCount = questionOrder.size,
            doesExistsPassButton = true, /* TODO */
            userInfoQuestion = questionOrder[questionIndex],
        )
    }
}
enum class UserInfoQuestion {
    NAME,
    GENDER,
    BIRTHDATE,
    HEIGHT,
    IS_STUDENT,
    JOB,
    COMPANY,
    SCHOOL,
    PERSONALITY,
    INTEREST,
    SELFIE,
}


data class GetUserInfoScreenData(
    val questionIndex: Int,
    val questionCount: Int,
    val doesExistsPassButton: Boolean,
    val userInfoQuestion: UserInfoQuestion,
)

enum class Gender {
    MALE,
    FEMALE
}