package com.danielminami.robotlistmvp.presenter;

import com.danielminami.robotlistmvp.model.Robot;
import com.danielminami.robotlistmvp.repository.RobotRepository;
import com.danielminami.robotlistmvp.view.MainActivityView;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainActivityPresenterTest {

    //This is a does nothing test
    @Test
    public void shouldPass() {
        Assert.assertEquals(1, 1);
    }

    //To perform this test, an instance of each mock class was created. The methods are declared
    // in the interfaces to achieve loose coupling. So the presenter know only about the interfaces
    // and does not know about the actual classes.
    @Test
    public void shouldPassRobotListToView() {

        //Given - Initial condition
        MainActivityView view = new MockView();
        RobotRepository robotRepository = new MockRobotRepository();
        MainActivityPresenter presenter = new MainActivityPresenter(view, robotRepository);

        //When - Action
        presenter.loadRobots();

        //Then - Return result
        //I need to cast here because the declared type of the view is MainActivityView and this
        // is the parent class os MockView and so it does not know about the MockView attribute.
        Assert.assertEquals(true, ((MockView)view).passed);

    }


    public class MockView implements MainActivityView {

        boolean passed;

        @Override
        public void displayRobots(List<Robot> robotList) {
            passed = true;
        }
    }

    public class MockRobotRepository implements RobotRepository {

        @Override
        public List<Robot> getRobots() {
            return Arrays.asList(new Robot(), new Robot(), new Robot());
        }
    }
}