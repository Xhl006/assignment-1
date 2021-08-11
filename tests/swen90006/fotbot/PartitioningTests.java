package swen90006.fotbot;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.*;
import static org.junit.Assert.*;

public class PartitioningTests
{
    protected FotBot fotbot;

    //Any method annotated with "@Before" will be executed before each test,
    //allowing the tester to set up some shared resources.
    @Before public void setUp()
	throws DuplicateUserException, InvalidUsernameException, InvalidPasswordException
    {
	fotbot = new FotBot();
	fotbot.register("userName1", "password1!");
    }

    //Any method annotated with "@After" will be executed after each test,
    //allowing the tester to release any shared resources used in the setup.
    @After public void tearDown()
    {
    }

    //Any method annotation with "@Test" is executed as a test.
    @Test public void aTest()
    {
	//the assertEquals method used to check whether two values are
	//equal, using the equals method
	final int expected = 2;
	final int actual = 1 + 1;
	assertEquals(expected, actual);
    }

    @Test public void anotherTest()
	throws DuplicateUserException, InvalidUsernameException, InvalidPasswordException
    {
	fotbot.register("userName2", "password2!");

	//the assertTrue method is used to check whether something holds.
	assertTrue(fotbot.isUser("userName2"));
	assertFalse(fotbot.isUser("nonUser"));
    }

    @Test public void sampleFotBotTest()
	throws NoSuchUserException, IncorrectPasswordException	
    {
	fotbot.incrementCurrentDay(2);

	List<Integer> newSteps = list(new Integer [] {1000, 2000});

	//username1 is created in the setUp() method, which is run before every test
	fotbot.update("userName1", "password1!", newSteps);

	List<Integer> steps = fotbot.getStepData("userName1", "password1!", "userName1");
	List<Integer> expected = list(new Integer [] {1000, 2000});
	assertEquals(expected, steps);	
    }
  
    //To test that an exception is correctly throw, specify the expected exception after the @Test
    @Test(expected = java.io.IOException.class) 
    public void anExceptionTest()
	throws Throwable
    {
	throw new java.io.IOException();
    }

    //This test should fail.
    //To provide additional feedback when a test fails, an error message
    //can be included
    @Test public void aFailedTest()
    {
	//include a message for better feedback
	final int expected = 2;
	final int actual = 1 + 2;
	//Uncomment the following line to make the test fail
	//assertEquals("Some failure message", expected, actual);
    }

    private List<Integer> list(Integer [] elements)
    {
	return new ArrayList<Integer>(Arrays.asList(elements));
    }
}
