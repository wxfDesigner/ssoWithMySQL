package com.tdh.gps.console.dao.api;

import java.util.List;

import com.tdh.gps.console.model.AccessToken;
import com.tdh.gps.console.model.RefreshToken;

/**
 * 
 * @ClassName: AccessTokenRepository
 * @Description: (AccessTokenRepository Dao层Api)
 * @author wxf
 * @date 2018年12月6日 下午2:56:03
 *
 */
public interface AccessTokenRepository extends Repository {

	void saveAccessToken(AccessToken accessToken);

	AccessToken findAccessToken(String tokenId);

	void removeAccessToken(String tokenId);

	void saveRefreshToken(RefreshToken refreshToken);

	RefreshToken findRefreshToken(String tokenId);

	void removeRefreshToken(String tokenId);

	void removeAccessTokenByRefreshToken(String refreshToken);

	AccessToken findAccessTokenByRefreshToken(String refreshToken);

	AccessToken findAccessTokenByAuthenticationId(String authenticationId);

	List<AccessToken> findAccessTokensByUsername(String userName);

	List<AccessToken> findAccessTokensByClientId(String clientId);

	List<AccessToken> findAccessTokensByClientIdAndUsername(String clientId, String userName);

	void updateAccessToken(AccessToken accessToken);
}