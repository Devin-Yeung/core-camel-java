package cs3173.construction.compiler.diagnostic;

import com.opencastsoftware.yvette.SourceCode;
import com.opencastsoftware.yvette.StringSourceCode;
import com.opencastsoftware.yvette.handlers.ReportHandler;
import com.opencastsoftware.yvette.handlers.graphical.GraphicalReportHandler;
import com.opencastsoftware.yvette.handlers.graphical.RgbColours;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Reporter {

    private final Collection<Error> errors;
    private final ReportHandler handler;

    private final SourceCode src;

    private static ReportHandler getHandler(boolean withColor) {
        if (withColor) {
            return GraphicalReportHandler.builder().withRgbColours(RgbColours.PREFERRED).get();
        } else {
            return GraphicalReportHandler.builder().withColours(false).get();
        }
    }

    public Reporter(String src, boolean withColor) {
        this.errors = new ArrayList<>();
        this.handler = getHandler(withColor);
        this.src = new StringSourceCode("example.ml", src);
    }

    public void report(Error error) {
        errors.add(error);
    }

    public String display() throws IOException {
        StringBuilder builder = new StringBuilder();
        for (Error err : this.errors) {
            handler.display(err.toDiagnostic(this.src), builder);
        }
        return builder.toString();
    }

}
