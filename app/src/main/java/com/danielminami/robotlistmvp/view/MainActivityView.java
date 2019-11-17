package com.danielminami.robotlistmvp.view;

import com.danielminami.robotlistmvp.model.Robot;

import java.util.List;

public interface MainActivityView {

    void diplayRobotsEmpty();

    void displayRobots(List<Robot> robotList);

}
