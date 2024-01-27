package cs3173.construction.compiler.diagnostic;

import com.opencastsoftware.yvette.Position;

public class ErrorBuilder {
    private final Error inner;

    public ErrorBuilder() {
        this.inner = new Error();
    }

    public ErrorBuilder start(Position pos) {
        inner.start = pos;
        return this;
    }

    public ErrorBuilder end(Position pos) {
        inner.end = pos;
        return this;
    }

    public Error build() {
        return inner;
    }

    public ErrorBuilder message(String msg) {
        inner.msg = msg;
        return this;
    }

    public ErrorBuilder hint(String hint) {
        inner.hint = hint;
        return this;
    }
}

