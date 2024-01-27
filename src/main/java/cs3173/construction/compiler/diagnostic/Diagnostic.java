// Refer to: https://github.com/DavidGregory084/mina/blob/main/compiler/common/src/main/java/org/mina_lang/common/diagnostics/Diagnostic.java
package cs3173.construction.compiler.diagnostic;

import com.opencastsoftware.yvette.*;

import java.net.URI;
import java.util.List;

public class Diagnostic extends com.opencastsoftware.yvette.Diagnostic {
    private final List<LabelledRange> labels;
    private final SourceCode sourceCode;

    public Diagnostic(String message, List<LabelledRange> labels, SourceCode sourceCode) {
        super(message);
        this.labels = labels;
        this.sourceCode = sourceCode;
    }

    @Override
    public String code() {
        // No need to define error code to simplify the complexity
        return null;
    }

    @Override
    public Severity severity() {
        // Just report as error to simplify the complexity
        return Severity.Error;
    }

    @Override
    public String help() {
        // Students are not require to display helping message
        return null;
    }

    @Override
    public URI url() {
        return null;
    }

    @Override
    public SourceCode sourceCode() {
        return this.sourceCode;
    }

    @Override
    public List<LabelledRange> labels() {
        return labels;
    }

}
