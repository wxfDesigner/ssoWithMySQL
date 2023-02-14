package com.tdh.gps.console.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.tdh.gps.console.utils.DateUtils;

/**
 * 
 * @ClassName: RefreshToken  
 * @Description: (刷新Token实体类)  
 * @author wxf
 * @date 2018年12月6日 下午2:51:39  
 *
 */
@Document(collection = "RefreshToken")
public class RefreshToken implements Serializable {
    private static final long serialVersionUID = 5529390717010301531L;


    @Id
    private String tokenId;


    @CreatedDate
    private Date createTime = DateUtils.now();

    @Version
    private Long version;


    private byte[] token;

    private byte[] authentication;


    public RefreshToken() {
    }

    public String tokenId() {
        return tokenId;
    }

    public RefreshToken tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public Date createTime() {
        return createTime;
    }


    public Long version() {
        return version;
    }


    public OAuth2RefreshToken token() {
        return SerializationUtils.deserialize(token);
    }

    public RefreshToken token(OAuth2RefreshToken token) {
        this.token = SerializationUtils.serialize(token);
        return this;
    }

    public OAuth2Authentication authentication() {
        return SerializationUtils.deserialize(authentication);
    }

    public RefreshToken authentication(OAuth2Authentication authentication) {
        this.authentication = SerializationUtils.serialize(authentication);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "tokenId='" + tokenId + '\'' +
                ", createTime=" + createTime +
                ", version=" + version +
                '}';
    }
}
