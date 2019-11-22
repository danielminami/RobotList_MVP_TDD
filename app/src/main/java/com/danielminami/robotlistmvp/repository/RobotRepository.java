package com.danielminami.robotlistmvp.repository;

import com.danielminami.robotlistmvp.model.ProductList;
import com.danielminami.robotlistmvp.model.Robot;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RobotRepository {

    List<Robot> robotList;

    public void getRobots(final RobotsRepositoryInterface robotsRepositoryInterface) {
        String API_BASE_URL = "https://shopicruit.myshopify.com/";

        Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetrofitRobotRepository retrofitRobotRepository =
                retrofit.create(RetrofitRobotRepository.class);

        Call<ProductList> call = retrofitRobotRepository.getProductList();
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                ProductList productList = response.body();
                robotList = new ArrayList<>();

                for (int i = 0; i < productList.getProducts().size(); i++) {
                    Robot robot = new Robot(i,
                            productList.getProducts().get(i).getTitle(),
                            productList.getProducts().get(i).getImage().getSrc());
                        robotList.add(robot);
                }
                robotsRepositoryInterface.OnFinishedListener(robotList);
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                robotsRepositoryInterface.onFailure(t);
            }
        });

    }

}
