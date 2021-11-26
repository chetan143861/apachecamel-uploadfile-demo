package apache.camel.uploaddemo.bean;

import java.io.Serializable;


public class ResponseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ResponseStatus status;

    private Object message;

    private Object data;

    public ResponseBean() {

    }

    public ResponseBean(ResponseStatus status) {
        this.status = status;
    }

    public ResponseBean(ResponseStatus status, Object message) {
        this.status = status;
        this.message = message;
    }

    public ResponseBean(ResponseStatus status, Object message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public ResponseBean setStatus(final ResponseStatus status) {
        this.status = status;
        return this;
    }

    public Object getMessage() {
        return message;
    }

    public ResponseBean setMessage(final Object message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseBean setData(final Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "status=" + status +
                ", message=" + message +
                ", data=" + data +
                '}';
    }
}
