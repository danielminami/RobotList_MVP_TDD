package com.danielminami.robotlistmvp.repository;

import com.danielminami.robotlistmvp.model.Robot;

import java.util.List;

public interface RobotsRepositoryInterface {

    void OnFinishedListener(List<Robot> robotList);

    void onFailure(Throwable t);

}
