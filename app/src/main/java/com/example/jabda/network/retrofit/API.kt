package com.example.jabda.network.retrofit

import com.example.jabda.network.request.work_home_requests.HomeWorkRequest
import com.example.jabda.network.request.auth.LoginRequest
import com.example.jabda.network.request.auth.RegisterOwnerRequest
import com.example.jabda.network.request.auth.RegisterOwnerResponse
import com.example.jabda.network.request.auth.RegisterRequest
import com.example.jabda.network.request.companies.ChangeTimeRequest
import com.example.jabda.network.request.companies.EditCompanyInfoRequest
import com.example.jabda.network.request.managers.EditInfoRequest
import com.example.jabda.network.request.notices.NoticeRequest
import com.example.jabda.network.request.staff.EditMemberInfoRequest
import com.example.jabda.network.request.staff.EditMyInfoRequest
import com.example.jabda.network.response.join_requests.JoinListResponse
import com.example.jabda.network.response.auth.LoginResponse
import com.example.jabda.network.response.auth.RefreshResponse
import com.example.jabda.network.response.auth.RegisterResponse
import com.example.jabda.network.response.companies.CompaniesResponse
import com.example.jabda.network.response.companies.CompanyWorkSystemResponse
import com.example.jabda.network.response.companies.MyCompanyResponse
import com.example.jabda.network.response.join_requests.IsApproveResponse
import com.example.jabda.network.response.join_requests.JoinCountResponse
import com.example.jabda.network.response.managers.OwnerInfoResponse
import com.example.jabda.network.response.notices.NoticesResponse
import com.example.jabda.network.response.notices.RecentNoticeResponse
import com.example.jabda.network.response.staff.*
import com.example.jabda.network.response.work_home_requests.HomeWorkCountResponse
import com.example.jabda.network.response.work_home_requests.ListWorkHomeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @POST("/auth/managers")
    fun registerOwner(
        @Body body: RegisterOwnerRequest
    ): Call<RegisterOwnerResponse>

    @POST("/auth/staff")
    fun register(
        @Body body: RegisterRequest
    ): Call<RegisterResponse>

    @POST("/auth")
    fun login(
        @Body body: LoginRequest
    ): Call<LoginResponse>

    @PATCH("/auth")
    fun refresh(): Call<RefreshResponse>

    @PATCH("/managers")
    fun editInfo(
        @Body body: EditInfoRequest
    ): Call<Void>

    @GET("/managers")
    fun getInfo(): Call<OwnerInfoResponse>

    @PATCH("/companies/work-time")
    fun setWorkTime(
        @Body body: ChangeTimeRequest
    ): Call<Void>

    @PATCH("/companies")
    fun editCompanyInfo(
        @Body body: EditCompanyInfoRequest
    ): Call<Void>

    @GET("/companies")
    fun getCompanies(
        @Query("name") name: String
    ): Call<CompaniesResponse>

    @GET("/companies")
    fun myCompany(): Call<MyCompanyResponse>

    @GET("/staff")
    fun commuteListSearch(
        @Query("name") name: String
    ): Call<CommuteListResponse>

    @GET("/staff")
    fun commuteList(): Call<CommuteListResponse>

    @GET("/staff/{staff-id}")
    fun detailStaff(
        @Path("staff-id") staffId: String
    ): Call<DetailStaffResponse>

    @PATCH("/staff/{staff-id}")
    fun editMember(
        @Body body: EditMemberInfoRequest
    ): Call<Void>

    @PATCH("/staff/leave-early/{staff-id}")
    fun editMemberLeave(
        @Path("staff-id") staffId: String
    ): Call<Void>

    @GET("/staff/average")
    fun timeAverage(): Call<TimeAverageResponse>

    @GET("/staff/timeline")
    fun timeLine(): Call<TimeLineResponse>

    @GET("/staff/today")
    fun todayStaff(): Call<TodayStaffResponse>

    @GET("/staff/work-time")
    fun myWorkTime(): Call<MyWorkTimeResponse>

    @GET("/staff/work-time/week")
    fun myWorkTimeWeek(): Call<MyWorkTimeWeekResponse>

    @GET("/staff/myself")
    fun myInfo(): Call<MyInfoResponse>

    @PATCH("/staff/myself")
    fun editMyInfo(
        @Body body: EditMyInfoRequest
    ): Call<Void>

    @PATCH("/staff/attendance")
    fun attend(): Call<Void>

    @GET("/join-requests")
    fun joinList(): Call<JoinListResponse>

    @PATCH("/join-request/{staff-id}")
    fun approveJoin(
        @Path("staff-id") staffId: String
    ): Call<Void>

    @DELETE("/join-requests/{staff-id}")
    fun rejectJoin(
        @Path("staff-id") staffId: String
    ): Call<Void>

    @POST("/join-requests/{company-id}")
    fun reJoin(
        @Path("company-id") companyId: String
    ): Call<Void>

    @GET("/join-requests/approve-status")
    fun isApprove(): Call<IsApproveResponse>

    @GET("/join-requests/count")
    fun joinCount(): Call<JoinCountResponse>

    @POST("/notices")
    fun writeNotice(
        @Body body: NoticeRequest
    ): Call<Void>

    @PATCH("/notices/{notice-id}")
    fun editNotice(
        @Path("notice-id") noticeId: String,
        @Body body: NoticeRequest
    ): Call<Void>

    @GET("/notices")
    fun listNotice(): Call<NoticesResponse>

    @GET("/notices/first")
    fun recentNotice(): Call<RecentNoticeResponse>

    @DELETE("/work-home-requests/{staff-id}/approve")
    fun approveHomeWork(
        @Path("staff-id") staffId: String
    ): Call<Void>

    @DELETE("/work-home-requests/{staff-id}/cancel")
    fun rejectHomeWork(
        @Path("staff-id") staffId: String
    ): Call<Void>
    
    @POST("/work-home-requests")
    fun requestHomeWork(
        @Body body: HomeWorkRequest
    ): Call<Void>

    @GET("/work-home-requests")
    fun listWorkHome(): Call<ListWorkHomeResponse>

    @GET("/work-home-requests/count")
    fun homeWorkCount(): Call<HomeWorkCountResponse>
}