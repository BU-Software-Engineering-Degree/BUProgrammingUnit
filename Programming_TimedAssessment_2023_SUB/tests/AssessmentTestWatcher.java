import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AssessmentTestWatcher implements TestWatcher, BeforeAllCallback, AfterAllCallback {
    int testTotal = 0;
    int testSuccessful = 0;
    int testFailed = 0;

    int marksAvailable = 0;
    int marksGained = 0;

    HashMap<String, String> testResults = new HashMap<>();
    HashMap<String, Integer> testMarks = new HashMap<>();

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
        // do something
        testResults.put(extensionContext.getTestMethod().get().getName(), "Aborted - " + new Date().getTime());
        marksAvailable += getMarksForTest(extensionContext.getTestMethod().get().getName());
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
        // do something
        testResults.put(extensionContext.getTestMethod().get().getName(), "Disabled - " + new Date().getTime());
        marksAvailable += getMarksForTest(extensionContext.getTestMethod().get().getName());
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        // do something
        testResults.put(extensionContext.getTestMethod().get().getName(), "Fail - " + new Date().getTime());
        testResults.put("Reason", throwable.getMessage());
        testFailed++;
        testTotal++;
        marksAvailable += getMarksForTest(extensionContext.getTestMethod().get().getName());
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        // do something
        testResults.put(extensionContext.getTestMethod().get().getName(), "Pass - " + new Date().getTime());
        testSuccessful++;
        testTotal++;
        marksAvailable += getMarksForTest(extensionContext.getTestMethod().get().getName());
        marksGained += getMarksForTest(extensionContext.getTestMethod().get().getName());
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        PrintWriter pW = new PrintWriter(new BufferedWriter(new FileWriter(Paths.get("").toAbsolutePath()+"/meta/tests/Results - "+extensionContext.getDisplayName()+".txt")));

        pW.println(extensionContext.getDisplayName());
        pW.println("=============================");
        pW.println("Run: "+ new Date().toGMTString());
        pW.println();
        pW.println("Tests Summary");
        pW.println("=============================");
        pW.println("Tests Run: "+testTotal);
        pW.println("Tests Successful: "+testSuccessful);
        pW.println("Tests Failed: "+testFailed);

        pW.println();
        pW.println("Marks Summary");
        pW.println("=============================");
        pW.println("Marks Available: "+marksAvailable);
        pW.println("Marks Gained: "+marksGained);

        pW.println();
        pW.println();

        pW.println("Test Results");
        pW.println("=============================");

        int count = 1;
        for(Map.Entry<String, String> entry : testResults.entrySet()) {
            if(entry.getKey().startsWith("test")){
                if(count != 1) {
                    pW.println("--");
                }
                pW.println("Test " + count + ": " + entry.getKey() + "(): "+ entry.getValue());
                count++;
            }else{
                pW.println(entry.getKey() + ": "+ entry.getValue());
            }
        }

        pW.println();
        pW.println();

        pW.println("Test Marks");
        pW.println("=============================");

        int marksCount = 1;
        for(Map.Entry<String, String> entry : testResults.entrySet()) {
            if(entry.getKey().startsWith("test")){
                if(marksCount != 1) {
                    pW.println("--");
                }
                pW.println("Test " + marksCount + ": " + entry.getKey() + "(): ");
                marksCount++;
            }
            pW.println("\t\tMarks Available: " + getMarksForTest(entry.getKey()));
            pW.println("\t\tMarks Gained: " + ((entry.getValue().startsWith("Pass")) ? getMarksForTest(entry.getKey()) : 0));
        }

        pW.close();

    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        File marksFile = new File(Paths.get("").toAbsolutePath()+"/meta/marks/marksAvailable.txt");
        Scanner marksScanner = new Scanner(marksFile);
        while(marksScanner.hasNextLine()){
            String line = marksScanner.nextLine();
            if(!line.isEmpty()){
                testMarks.put(line.split(":")[0], Integer.parseInt(line.split(":")[1]));
            }
        }
        marksScanner.close();
    }

    private Integer getMarksForTest(String test){
        return testMarks.get(test);
    }
}
