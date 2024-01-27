package cs3173.construction.compiler.diagnostic;


import com.opencastsoftware.yvette.Position;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.IOException;

public class ReportTest {


    @Test
    public void helloWorld() {
        Error err = Error.builder()
                .message("This is an Error Message")
                .start(new Position(0, 0))
                .end(new Position(0, 5))
                .hint("This is a Hint")
                .build();

        Reporter reporter = new Reporter("Hello World", false);
        reporter.report(err);
        try {
            Approvals.verify(reporter.display());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
