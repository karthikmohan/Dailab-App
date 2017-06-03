package com.iitd.dailab.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iitd.dailab.Model.FeedModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface FeedApi {

    @GET("content.json")
    Call<FeedModelResponse> getfeed();


    class FeedModelResponse
    {
        @SerializedName("history")
        @Expose
        public List<FeedModel> FeedModelList = new ArrayList<>();

        public List<FeedModel> getFeedModelList() {
            return FeedModelList;
        }

        public void setFeedModelList(List<FeedModel> FeedModelList) {
            this.FeedModelList = FeedModelList;
        }

//        @SerializedName("ataist")
//        @Expose
//        public List<Ataist> FeedModelList1 = new ArrayList<>();
//
//        public List<Ataist> getFeedModelList1() {
//            return FeedModelList1;
//        }
//
//        public void setFeedModelList1(List<Ataist> FeedModelList1) {
//            this.FeedModelList1 = FeedModelList1;
//        }
    }
}
