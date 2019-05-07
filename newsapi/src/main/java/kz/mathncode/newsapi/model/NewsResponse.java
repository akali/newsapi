package kz.mathncode.newsapi.model;

import java.util.List;

public class NewsResponse {
    private String status;
    private int result;
    private List<Article> articles;

    public NewsResponse(String status, int result, List<Article> articles) {
        this.status = status;
        this.result = result;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsResponse{" +
                "status='" + status + '\'' +
                ", result=" + result +
                ", articles=" + articles +
                '}';
    }
}
