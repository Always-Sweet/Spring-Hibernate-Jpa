package com.demo.domain;

import com.demo.utils.validatorgroup.SaveBookCheck;
import com.demo.utils.validatorgroup.UpdateBookCheck;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 书籍
 */
@ApiModel(value = "书籍doamin", description = "书籍领域信息模型")
@Entity
public class Book {

    @ApiModelProperty(value = "标识", name = "id", example = "5aee4cab-d44e-440f-b817-78b4a3c8bbaa")
    @NotBlank(message = "标识不能为空", groups = {UpdateBookCheck.class})
    @Id
    private String id;

    @ApiModelProperty(value = "书名", name = "name", example = "程序员入门")
    @NotBlank(message = "书名不能为空", groups = {SaveBookCheck.class, UpdateBookCheck.class})
    private String name;

    @ApiModelProperty(value = "作者", name = "author", example = "老前辈")
    private String author;

    @ApiModelProperty(value = "价格", name = "price", example = "100.00")
    private Double price;

    @ApiModelProperty(value = "入库时间", name = "storageDate", example = "2020-12-01 20:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date storageDate;

    @ApiModelProperty(value = "封面照片", name = "image", example = "####.png")
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(Date storageDate) {
        this.storageDate = storageDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
