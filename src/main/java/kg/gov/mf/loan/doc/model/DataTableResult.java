package kg.gov.mf.loan.doc.model;

import java.math.BigInteger;
import java.util.List;

public class DataTableResult {

    private long count;
    private List data;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
