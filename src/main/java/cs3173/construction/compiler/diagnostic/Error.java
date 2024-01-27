package cs3173.construction.compiler.diagnostic;

import com.opencastsoftware.yvette.LabelledRange;
import com.opencastsoftware.yvette.Position;
import com.opencastsoftware.yvette.SourceCode;

import java.util.List;

public class Error {
    protected Position start;
    protected Position end;
    protected String msg;
    protected String hint;

    public static ErrorBuilder builder() {
        return new ErrorBuilder();
    }

    protected Error() {
        this.msg = null;
        this.start = null;
        this.end = null;
        this.hint = null;
    }

    protected Diagnostic toDiagnostic(SourceCode src) {
        return new Diagnostic(
                this.msg,
                List.of(new LabelledRange(this.hint, this.start, this.end)),
                src
        );
    }
}
