package com.danielminami.robotlistmvp.presenter;

import android.util.Log;

import com.danielminami.robotlistmvp.model.Robot;
import com.danielminami.robotlistmvp.repository.RobotRepository;
import com.danielminami.robotlistmvp.repository.RobotsRepositoryInterface;
import com.danielminami.robotlistmvp.view.MainActivityView;

import java.util.List;

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
        robotRepository.getRobots(new RobotsRepositoryInterface() {
            @Override
            public void OnFinishedListener(List<Robot> robotList) {
                //Log.d("RETROFIT", "Was called");
                view.displayRobots(robotList);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("RETROFIT", t.toString());
            }
        });

    }

}
