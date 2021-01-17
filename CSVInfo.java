import java.util.List;

public class CSVInfo<T> {
    private String path;
    private int colNumber;
    private int rowNumber;
    private List<T> data;

    private CSVInfo() {
        //do nothing
    }

    private CSVInfo(CSVInfo<T> csvInfo) {
        this.path = csvInfo.path;
        this.colNumber = csvInfo.colNumber;
        this.rowNumber = csvInfo.rowNumber;
        this.data = csvInfo.data;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getColNumber() {
        return colNumber;
    }

    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static class Builder<T> {
        private final CSVInfo<T> csvInfo;

        public Builder() {
            this.csvInfo = new CSVInfo<>();
        }

        public Builder<T> path(String path) {
            this.csvInfo.path = path;
            return this;
        }

        public Builder<T> colNumber(int colNumber) {
            this.csvInfo.colNumber = colNumber;
            return this;
        }

        public Builder<T> rowNumber(int rowNumber) {
            this.csvInfo.rowNumber = rowNumber;
            return this;
        }

        public Builder<T> data(List<T> data) {
            if (this.csvInfo.rowNumber != data.size()) {
                this.csvInfo.rowNumber = data.size();
            }

            if (this.csvInfo.colNumber != data.get(0).getClass().getDeclaredFields().length) {
                this.csvInfo.colNumber = data.get(0).getClass().getDeclaredFields().length;
            }

            this.csvInfo.data = data;
            return this;
        }

        public CSVInfo<T> build() {
            return new CSVInfo<>(this.csvInfo);
        }
    }

}
