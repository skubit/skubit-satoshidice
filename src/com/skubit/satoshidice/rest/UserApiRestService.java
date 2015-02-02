/* Copyright 2015 Skubit
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.skubit.satoshidice.rest;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

import com.skubit.satoshidice.responses.PlaceBetResponse;
import com.skubit.satoshidice.responses.StartRoundResponse;
import com.skubit.satoshidice.responses.UpdateAliasResponse;
import com.skubit.satoshidice.responses.UserAddressResponse;
import com.skubit.satoshidice.responses.UserBalanceResponse;
import com.skubit.satoshidice.responses.WithdrawResponse;
import com.skubit.satoshidice.services.rest.ResourcesPath;

public interface UserApiRestService {

	public static final String baseUri = ResourcesPath.USER_API;

	@GET(baseUri + "/adduser")
	void addUser(Callback<Response> callback);

	@GET(baseUri + "/userbalance")
	void getBalance(@Query("secret") String secret,
			Callback<UserBalanceResponse> callback);

	@GET(baseUri + "/useraddress")
	void getUserAddress(@Query("secret") String secret,
			Callback<UserAddressResponse> callback);

	@GET(baseUri + "/placebet.php")
	void placeBet(@Query("secret") String secret,
			@Query("betInSatoshis") long betInSatoshis, @Query("id") String id,
			@Query("serverHash") String serverHash,
			@Query("clientRoll") String clientRoll,
			@Query("belowRollToWin") int belowRollToWin,
			Callback<PlaceBetResponse> callback);

	@GET(baseUri + "/startround.php")
	void startRound(@Query("secret") String secret,
			Callback<StartRoundResponse> callback);

	@GET(baseUri + "/updateuser")
	void updateUser(@Query("secret") String secret, @Query("nick") String nick,
			Callback<UpdateAliasResponse> callback);

	@GET(baseUri + "/withdraw")
	void withdrawl(@Query("secret") String secret,
			@Query("address") String address, @Query("amount") String amount,
			Callback<WithdrawResponse> callback);

}
