package com.lanou.bean;

public class Scrap {
    private Integer id;

    private String scrapCode;

    private String scrapName;

    private String category;

    private String unit;

    private Integer price;

    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScrapCode() {
        return scrapCode;
    }

    public void setScrapCode(String scrapCode) {
        this.scrapCode = scrapCode == null ? null : scrapCode.trim();
    }

    public String getScrapName() {
        return scrapName;
    }

    public void setScrapName(String scrapName) {
        this.scrapName = scrapName == null ? null : scrapName.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    @Override
    public String toString() {
        return "Scrap{" +
                "id=" + id +
                ", scrapCode='" + scrapCode + '\'' +
                ", scrapName='" + scrapName + '\'' +
                ", category='" + category + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", score=" + score +
                '}';
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}