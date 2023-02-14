package com.tdh.gps.console.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.tdh.gps.console.utils.DateUtils;


/**
 * 
 * @ClassName: AccessToken  
 * @Description: (获取Token实体类)  
 * @author wxf
 * @date 2018年12月6日 下午2:46:50  
 *
 */
@Document(collection = "AccessToken")
public class AccessToken implements Serializable {

    private static final long serialVersionUID = 7588602587200382326L;


    @Id
    private String tokenId;


    @CreatedDate
    private Date createTime = DateUtils.now();

    @Version
    private Long version;


    private byte[] token;

    private String authenticationId;

    private byte[] authentication;

    private String username;

    private String clientId;

    private String refreshToken;

    public AccessToken() {
    }


    public String tokenId() {
        return tokenId;
    }

    public AccessToken tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public Date createTime() {
        return createTime;
    }


    public Long version() {
        return version;
    }


    public OAuth2AccessToken token() {
        return SerializationUtils.deserialize(token);
    }

    public AccessToken token(OAuth2AccessToken token) {
        this.token = SerializationUtils.serialize(token);
        return this;
    }

    public String authenticationId() {
        return authenticationId;
    }

    public AccessToken authenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
        return this;
    }

    public OAuth2Authentication authentication() {
        return SerializationUtils.deserialize(authentication);
    }

    public AccessToken authentication(OAuth2Authentication authentication) {
        this.authentication = SerializationUtils.serialize(authentication);
        return this;
    }

    public String username() {
        return username;
    }

    public AccessToken username(String username) {
        this.username = username;
        return this;
    }

    public String clientId() {
        return clientId;
    }

    public AccessToken clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String refreshToken() {
        return refreshToken;
    }

    public AccessToken refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    
    public String getTokenId() {
		return tokenId;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public Long getVersion() {
		return version;
	}


	public byte[] getToken() {
		return token;
	}


	public String getAuthenticationId() {
		return authenticationId;
	}


	public byte[] getAuthentication() {
		return authentication;
	}


	public String getUsername() {
		return username;
	}


	public String getClientId() {
		return clientId;
	}


	public String getRefreshToken() {
		return refreshToken;
	}


	@Override
    public String toString() {
        return "{" +
                "tokenId='" + tokenId + '\'' +
                ", createTime=" + createTime +
                ", version=" + version +
                ", authenticationId='" + authenticationId + '\'' +
                ", username='" + username + '\'' +
                ", clientId='" + clientId + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}
