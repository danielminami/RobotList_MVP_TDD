package com.danielminami.robotlistmvp.presenter;

import com.danielminami.robotlistmvp.repository.RobotRepository;
import com.danielminami.robotlistmvp.view.MainActivityView;

// For testing, this class will be instantiated with the MockView and MockPresenter.
public class MainActivityPresenter {

    //3. this is the View Interface. Now the Presenter knows about the interface
    private MainActivityView view;
    private RobotRepository robotRepository;

    public MainActivityPresenter(MainActivityView view, RobotRepository robotRepository) {
        this.view = view;
        this.robotRepository = robotRepository;
    }

    public void loadRobots() {
        view.displayRobots(robotRepository.getRobots());
    }

}