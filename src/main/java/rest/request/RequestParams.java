package rest.request;

import java.util.Map;

public class RequestParams {
    private int drow;
    private int start;
    private int length;
    private Map search;

    public Map getSearch() {
        return search;
    }

    public void setSearch(Map search) {
        this.search = search;
    }

    public RequestParams() {
    }

    public int getDrow() {

        return drow;
    }

    public void setDrow(int drow) {
        this.drow = drow;
    }



    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
