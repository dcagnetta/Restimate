package co.za.codeboss.data.elastic.exception;

import lombok.Getter;

public class ElasticsearchException extends RuntimeException {
    @Getter
    private int errcode;

    @Getter
    private String errmsg;

    public ElasticsearchException(Integer errcode, String errmsg) {
        super(errmsg);
        this.errcode = errcode;
        this.errmsg = errmsg;
    }
}
