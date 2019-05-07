package kz.mathncode.model;

import java.util.HashMap;
import java.util.Map;

public class RequestParams {
    private Country country;
    private Category category;
    private String q;
    private int pageSize = -1;
    private int page = -1;
    private String apiKey;

    private RequestParams() {

    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public static Builder newBuilder() {
        return new RequestParams().new Builder();
    }

    public Map<String, String> map() {
        return new HashMap<String, String> () {{
            if (country != null)
                put("country", country.getValue());
            if (category != null)
                put("category", category.getValue());
            if (q != null)
                put("q", q);
            if (pageSize != -1)
                put("pageSize", String.valueOf(pageSize));
            if (page != -1)
                put("page", String.valueOf(page));
            put("apiKey", apiKey);
        }};
    }

    public class Builder {
        private Builder() {

        }

        public Builder setCountry(Country country) {
            RequestParams.this.country = country;
            return this;
        }

        public Builder setCategory(Category category) {
            RequestParams.this.category = category;
            return this;
        }

        public Builder setQuery(String q) {
            RequestParams.this.q = q;
            return this;
        }

        public Builder setPageSize(int pageSize) {
            RequestParams.this.pageSize = pageSize;
            return this;
        }

        public Builder setPage(int page) {
            RequestParams.this.page = page;
            return this;
        }

        public Builder setApiKey(String apiKey) {
            RequestParams.this.apiKey = apiKey;
            return this;
        }

        public RequestParams build() {
            return RequestParams.this;
        }
    }
}
